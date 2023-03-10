package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.social.commands.AddMessageToSocialCommand;
import co.com.sofkau.dddchallenge.domain.social.events.MessageToSocialAdded;
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
class AddMessageToSocialUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddMessageToSocialUseCase addMessageToSocialUseCase;

    @BeforeEach
    public void setup(){
        addMessageToSocialUseCase = new AddMessageToSocialUseCase(eventsRepository);
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

        PlayerToSocialAdded playerToSocialAdded = new PlayerToSocialAdded(
                "socialId",
                "playerId",
                "Jonathan",
                "Knath"
        );
        playerToSocialAdded.setAggregateRootId("socialId");

        PlayerToSocialAdded player2ToSocialAdded = new PlayerToSocialAdded(
                "socialId",
                "player2Id",
                "Daniel",
                "Hollow"
        );
        player2ToSocialAdded.setAggregateRootId("socialId");

        AddMessageToSocialCommand addMessageToSocialCommand = new AddMessageToSocialCommand(
                "socialId",
                "messageId",
                "This is a new message",
                "playerId",
                "player2Id"
        );
        MessageToSocialAdded messageToSocialAdded = new MessageToSocialAdded(
                "socialId",
                "messageId",
                "This is a new message",
                "playerId",
                "player2Id"
        );
        messageToSocialAdded.setAggregateRootId("socialId");

        Mockito.when(eventsRepository.findByAggregateRootId("socialId")).thenReturn(List.of(
                socialCreated,
                playerToSocialAdded,
                player2ToSocialAdded
        ));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        List<DomainEvent> domainEvents = addMessageToSocialUseCase.apply(addMessageToSocialCommand);

        // Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("This is a new message", ((MessageToSocialAdded) domainEvents.get(0)).getContent());
        Assertions.assertEquals("playerId", ((MessageToSocialAdded) domainEvents.get(0)).getEmitterId());
    }

}