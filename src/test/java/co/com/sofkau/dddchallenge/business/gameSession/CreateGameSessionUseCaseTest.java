package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.CreateGameSessionCommand;
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
class CreateGameSessionUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateGameSessionUseCase createGameSessionUseCase;

    @BeforeEach
    public void setup(){
        createGameSessionUseCase = new CreateGameSessionUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        //Arrange
        CreateGameSessionCommand createGameSessionCommand = new CreateGameSessionCommand(
                "gameSessionId",
                0,
                70,
                "inProgress",
                "SocialId"
        );
        GameSessionCreated gameSessionCreated = new GameSessionCreated(
                "gameSessionId",
                new GameState(0, 60, "inProgress"),
                "SocialId"
        );
        gameSessionCreated.setAggregateRootId("gameSessionId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        //Act
        List<DomainEvent> domainEvents = createGameSessionUseCase.apply(createGameSessionCommand);

        //Assert
        Assertions.assertEquals("gameSessionId", domainEvents.get(0).aggregateRootId());
        Assertions.assertEquals(70, ((GameSessionCreated) domainEvents.get(0)).getTimeLeft());
    }

}