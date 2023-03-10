package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.DisconnectClientFromServerCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisconnectClientFromServerUseCase implements UseCaseCommand<DisconnectClientFromServerCommand> {

    EventsRepository eventsRepository;

    public DisconnectClientFromServerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(DisconnectClientFromServerCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getGameSessionId());
        GameSession gameSession = GameSession.from(GameSessionId.of(command.getGameSessionId()), events);

        if (gameSession.getServer() != null && gameSession.getServer().serverId().value().equals(command.getServerId())) {
            gameSession.disconnectClientFromServer(command.getGameSessionId(),command.getClientId(), command.getServerId());
            return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
        }
        else{
            throw new IllegalArgumentException("The server is not in the game session");
        }
    }
}
