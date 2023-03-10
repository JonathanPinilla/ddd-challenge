package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.social.commands.AddPlayerToSocialCommand;
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
class AddPlayerToSocialUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddPlayerToSocialUseCase addPlayerToSocialUseCase;

    @BeforeEach
    public void setup() {
        addPlayerToSocialUseCase = new AddPlayerToSocialUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        // Arrange
        SocialCreated socialCreated = new SocialCreated(
                "socialId",
                "Open",
                "catalogId"
        );
        socialCreated.setAggregateRootId("socialId");

        AddPlayerToSocialCommand command = new AddPlayerToSocialCommand(
                "socialId",
                "playerId",
                "name",
                "nickName"
        );
        PlayerToSocialAdded playerToSocialAdded = new PlayerToSocialAdded(
                "socialId",
                "playerId",
                "name",
                "nickName"
        );
        playerToSocialAdded.setAggregateRootId("socialId");

        Mockito.when(eventsRepository.findByAggregateRootId("socialId")).thenReturn(List.of(socialCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        List<DomainEvent> domainEvents = addPlayerToSocialUseCase.apply(command);

        // Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("playerId", ((PlayerToSocialAdded) domainEvents.get(0)).getPlayerId());
        Assertions.assertEquals("name", ((PlayerToSocialAdded) domainEvents.get(0)).getName());
    }

}