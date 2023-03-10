package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.Client;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.ConnectClientToServerCommand;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ClientToGameSessionAdded;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ClientToServerConnected;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameSessionCreated;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ServerToGameSessionAdded;
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
class ConnectClientToServerUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ConnectClientToServerUseCase connectClientToServerUseCase;

    @BeforeEach
    public void setup(){
        connectClientToServerUseCase = new ConnectClientToServerUseCase(eventsRepository);
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

        ConnectClientToServerCommand connectClientToServerCommand = new ConnectClientToServerCommand(
                "gameSessionId",
                "clientId",
                "serverId"
        );
        ClientToServerConnected clientToServerConnected = new ClientToServerConnected(
                "gameSessionId",
                "clientId",
                "serverId"
        );
        clientToServerConnected.setAggregateRootId("gameSessionId");

        Mockito.when(eventsRepository.findByAggregateRootId("gameSessionId")).thenReturn(List.of(
                gameSessionCreated,
                serverToGameSessionAdded,
                clientToGameSessionAdded
        ));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        //Act
        List<DomainEvent> domainEvents = connectClientToServerUseCase.apply(connectClientToServerCommand);

        //Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("serverId", ((ClientToServerConnected) domainEvents.get(0)).getServerId());
        Assertions.assertEquals("clientId", ((ClientToServerConnected) domainEvents.get(0)).getClientId());
    }
}