package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.AddServerToSessionCommand;
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
class AddServerToSessionUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddServerToSessionUseCase addServerToSessionUseCase;

    @BeforeEach
    public void setup(){
        addServerToSessionUseCase = new AddServerToSessionUseCase(eventsRepository);
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

        AddServerToSessionCommand addServerToSessionCommand = new AddServerToSessionCommand(
                "gameSessionId",
                "serverId",
                "ServerName",
                "location",
                "serverIp",
                true
        );

        ServerToGameSessionAdded serverToGameSessionAdded = new ServerToGameSessionAdded(
                "gameSessionId",
                "serverId",
                "ServerName",
                "location",
                "serverIp",
                true
        );

        serverToGameSessionAdded.setAggregateRootId("gameSessionId");

        Mockito.when(eventsRepository.findByAggregateRootId("gameSessionId")).thenReturn(List.of(gameSessionCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));
        //Act
        List<DomainEvent> domainEvents = addServerToSessionUseCase.apply(addServerToSessionCommand);

        //Assert

        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("gameSessionId", domainEvents.get(0).aggregateRootId());
        Assertions.assertEquals("location", ((ServerToGameSessionAdded) domainEvents.get(0)).getLocation());
    }

}