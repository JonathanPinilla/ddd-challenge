package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.AddClientToSessionCommand;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ClientToGameSessionAdded;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameSessionCreated;
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
class AddClientToSessionUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddClientToSessionUseCase addClientToSessionUseCase;

    @BeforeEach
    public void setup(){
        addClientToSessionUseCase = new AddClientToSessionUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        //Arrange
        GameSessionCreated gameSessionCreated = new GameSessionCreated("gameSessionId", new GameState(0, 60, "inProgress"), "SocialId");
        gameSessionCreated.setAggregateRootId("gameSessionId");

        AddClientToSessionCommand addClientToSessionCommand = new AddClientToSessionCommand(
                "gameSessionId",
                "clientId",
                "ip",
                "location",
                "playerId"
        );

        ClientToGameSessionAdded clientToGameSessionAdded = new ClientToGameSessionAdded(
                "gameSessionId",
                "clientId",
                "ip",
                "location",
                "playerId"
        );

        clientToGameSessionAdded.setAggregateRootId("gameSessionId");

        Mockito.when(eventsRepository.findByAggregateRootId("gameSessionId")).thenReturn(List.of(gameSessionCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        //Act
        List<DomainEvent> domainEvents = addClientToSessionUseCase.apply(addClientToSessionCommand);

        //Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("gameSessionId", domainEvents.get(0).aggregateRootId());
        Assertions.assertEquals("clientId", ((ClientToGameSessionAdded) domainEvents.get(0)).getClientId());
    }

}