package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.UpdateGameStateCommand;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameSessionCreated;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameStateUpdated;
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
class UpdateGameStateUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private UpdateGameStateUseCase updateGameStateUseCase;

    @BeforeEach
    public void setup(){
        updateGameStateUseCase = new UpdateGameStateUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        //Arrange
        GameSessionCreated gameSessionCreated = new GameSessionCreated(
                "gameSessionId",
                new GameState(0, 60, "inProgress"),
                "socialId"
        );
        gameSessionCreated.setAggregateRootId("gameSessionId");

        UpdateGameStateCommand updateGameStateCommand = new UpdateGameStateCommand(
                "gameSessionId",
                50,
                0,
                "playerId",
                "socialId"
        );
        GameStateUpdated gameStateUpdated = new GameStateUpdated(
                "gameSessionId",
                50,
                0,
                "playerId",
                "socialId"
        );
        gameStateUpdated.setAggregateRootId("gameSessionId");

        Mockito.when(eventsRepository.findByAggregateRootId("gameSessionId")).thenReturn(List.of(gameSessionCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        //Act
        List<DomainEvent> domainEvents = updateGameStateUseCase.apply(updateGameStateCommand);

        //Assert
        Assertions.assertEquals(50, ((GameStateUpdated) domainEvents.get(0)).getScore());
        Assertions.assertEquals(0, ((GameStateUpdated) domainEvents.get(0)).getTimeLeft());
        Assertions.assertEquals("playerId", ((GameStateUpdated) domainEvents.get(0)).getWinnerId());
    }

}