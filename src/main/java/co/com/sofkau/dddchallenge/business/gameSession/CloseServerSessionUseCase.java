package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.CloseServerSessionCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public class CloseServerSessionUseCase implements UseCaseCommand<CloseServerSessionCommand> {

    EventsRepository eventsRepository;

    public CloseServerSessionUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CloseServerSessionCommand command) {

        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getGameSessionId());

        GameSession gameSession = GameSession.from(GameSessionId.of(command.getGameSessionId()), events);

        if (gameSession.getServer() != null && gameSession.getServer().serverId().value().equals(command.getServerId())) {
            gameSession.closeServerSession(command.getGameSessionId(), command.getServerId(),command.getIsOpen());
            return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
        }
        else{
            throw new IllegalArgumentException("The server is not in the game session");
        }
    }
}
