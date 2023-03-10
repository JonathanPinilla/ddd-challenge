package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.DisconnectClientFromServerCommand;
import co.com.sofkau.dddchallenge.domain.gameSession.events.*;
import co.com.sofkau.dddchallenge.domain.gameSession.values.GameState;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DisconnectClientFromServerUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private DisconnectClientFromServerUseCase disconnectClientFromServerUseCase;

    @BeforeEach
    public void setup(){
        disconnectClientFromServerUseCase = new DisconnectClientFromServerUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        //Arrange
        GameSessionCreated gameSessionCreated = new GameSessionCreated(
                "gameSessionId",
                new GameState(0, 60, "inProgress"),
                "SocialId"
        );
        gameSessionCreated.setAggregateRootId("gameSessionId");

        ServerToGameSessionAdded serverToGameSessionAdded = new ServerToGameSessionAdded(
                "gameSessionId",
                "serverId",
                "ServerName",
                "location",
                "serverIp",
                true
        );
        serverToGameSessionAdded.setAggregateRootId("gameSessionId");

        ClientToGameSessionAdded clientToGameSessionAdded = new ClientToGameSessionAdded(
                "gameSessionId",
                "clientId",
                "ip",
                "location",
                "playerId"
        );
        clientToGameSessionAdded.setAggregateRootId("gameSessionId");
        ClientToServerConnected clientToServerConnected = new ClientToServerConnected(
                "gameSessionId",
                "clientId",
                "serverId"
        );
        clientToServerConnected.setAggregateRootId("gameSessionId");

        DisconnectClientFromServerCommand disconnectClientFromServerCommand = new DisconnectClientFromServerCommand(
                "gameSessionId",
                "clientId",
                "serverId"
        );
        ClientFromServerDisconnected clientFromServerDisconnected = new ClientFromServerDisconnected(
                "gameSessionId",
                "clientId"
        );
        clientFromServerDisconnected.setAggregateRootId("gameSessionId");

        Mockito.when(eventsRepository.findByAggregateRootId("gameSessionId")).thenReturn(List.of(
                gameSessionCreated,
                serverToGameSessionAdded,
                clientToGameSessionAdded,
                clientToServerConnected
        ));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation ->invocation.getArgument(0));

        //Act
        List<DomainEvent> domainEvents = disconnectClientFromServerUseCase.apply(disconnectClientFromServerCommand);

        //Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("gameSessionId", domainEvents.get(0).aggregateRootId());
        Assertions.assertEquals("clientId", ((ClientFromServerDisconnected) domainEvents.get(0)).getClientId());
        assertNull(((ClientFromServerDisconnected) domainEvents.get(0)).getServerId());
    }

}