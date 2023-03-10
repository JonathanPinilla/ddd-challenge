package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.ConnectClientToServerCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConnectClientToServerUseCase implements UseCaseCommand<ConnectClientToServerCommand> {

    EventsRepository eventsRepository;

    public ConnectClientToServerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ConnectClientToServerCommand command) {

        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getGameSessionId());
        GameSession gameSession = GameSession.from(GameSessionId.of(command.getGameSessionId()), events);

        if (gameSession.getServer() != null && gameSession.getServer().serverId().value().equals(command.getServerId())) {
            if (gameSession.getClients().stream().anyMatch(client -> client.clientId().value().equals(command.getClientId()))){
                gameSession.connectClientToServer(command.getGameSessionId(), command.getClientId(), command.getServerId());
                return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
            }
            else {
                throw new IllegalArgumentException("The client is not in the game session");
            }
        }
        else{
            throw new IllegalArgumentException("The server is not in the game session");
        }
    }

}
