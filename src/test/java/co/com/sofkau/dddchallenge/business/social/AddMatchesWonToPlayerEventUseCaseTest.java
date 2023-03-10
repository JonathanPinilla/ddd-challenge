package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameStateUpdated;
import co.com.sofkau.dddchallenge.domain.social.events.MatchesWonToPlayerAdded;
import co.com.sofkau.dddchallenge.domain.social.events.PlayerToSocialAdded;
import co.com.sofkau.dddchallenge.domain.social.events.SocialCreated;
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
class AddMatchesWonToPlayerEventUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddMatchesWonToPlayerEventUseCase addMatchesWonToPlayerEventUseCase;

    @BeforeEach
    public void setup() {
        addMatchesWonToPlayerEventUseCase = new AddMatchesWonToPlayerEventUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        // Arrange
        SocialCreated socialCreated = new SocialCreated(
                "socialId",
                "open",
                "catalogId"
        );
        socialCreated.setAggregateRootId("socialId");
        PlayerToSocialAdded playerToSocialAdded = new PlayerToSocialAdded(
                "socialId",
                "playerId",
                "name",
                "lastName"
        );
        playerToSocialAdded.setAggregateRootId("socialId");

        GameStateUpdated gameStateUpdated = new GameStateUpdated(
                "gameSessionId",
                50,
                2,
                "playerId",
                "socialId"
        );
        gameStateUpdated.setAggregateRootId("gameSessionId");
        MatchesWonToPlayerAdded matchesWonToPlayerAdded = new MatchesWonToPlayerAdded(
                "socialId",
                "playerId"
        );
        matchesWonToPlayerAdded.setAggregateRootId("socialId");

        Mockito.when(eventsRepository.findByAggregateRootId("socialId")).thenReturn(List.of(socialCreated, playerToSocialAdded));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));
        // Act
        List<DomainEvent> domainEvents = addMatchesWonToPlayerEventUseCase.apply(gameStateUpdated);

        // Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("playerId", ((MatchesWonToPlayerAdded) domainEvents.get(0)).getPlayerId());
        Assertions.assertEquals("socialId", ((MatchesWonToPlayerAdded) domainEvents.get(0)).getSocialId());
    }

}