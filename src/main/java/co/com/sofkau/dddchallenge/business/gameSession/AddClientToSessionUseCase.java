package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.AddClientToSessionCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public class AddClientToSessionUseCase implements UseCaseCommand<AddClientToSessionCommand> {

    EventsRepository eventsRepository;

    public AddClientToSessionUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddClientToSessionCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getGameSessionId());

        var gameSession = GameSession.from(GameSessionId.of(command.getGameSessionId()), events);

        gameSession.addClient(
                command.getGameSessionId(),
                command.getClientId(),
                command.getIp(),
                command.getLocation(),
                command.getServerId(),
                command.getPlayerId()
        );

        return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}

