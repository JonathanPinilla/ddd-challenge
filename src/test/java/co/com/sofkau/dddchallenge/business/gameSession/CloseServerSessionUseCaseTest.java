package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.CloseServerSessionCommand;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameSessionCreated;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ServerSessionClosed;
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
class CloseServerSessionUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CloseServerSessionUseCase closeServerSessionUseCase;

    @BeforeEach
    public void setup(){
        closeServerSessionUseCase = new CloseServerSessionUseCase(eventsRepository);
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

        CloseServerSessionCommand closeServerSessionCommand = new CloseServerSessionCommand(
                "gameSessionId",
                "serverId",
                false
        );
        ServerSessionClosed serverSessionClosed = new ServerSessionClosed(
                "gameSessionId",
                "serverId",
                false
        );

        Mockito.when(eventsRepository.findByAggregateRootId("gameSessionId")).thenReturn(List.of(gameSessionCreated, serverToGameSessionAdded));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        //Act
        List<DomainEvent> domainEvents = closeServerSessionUseCase.apply(closeServerSessionCommand);

        //Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("gameSessionId", domainEvents.get(0).aggregateRootId());
        Assertions.assertEquals("serverId", ((ServerSessionClosed) domainEvents.get(0)).getServerId());
        Assertions.assertEquals(false, ((ServerSessionClosed) domainEvents.get(0)).getIsOpen());
    }
}