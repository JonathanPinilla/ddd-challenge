package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.AddServerToSessionCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddServerToSessionUseCase implements UseCaseCommand<AddServerToSessionCommand> {

    EventsRepository eventsRepository;

    public AddServerToSessionUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddServerToSessionCommand command) {

        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getGameSessionId());

        var gameSession = GameSession.from(GameSessionId.of(command.getGameSessionId()), events);

        gameSession.addServer(
                command.getGameSessionId(),
                command.getServerId(),
                command.getName(),
                command.getLocation(),
                command.getIp(),
                command.getIsOpen()
        );

        return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }

}
