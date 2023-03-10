package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.social.commands.ChangeSocialStateCommand;
import co.com.sofkau.dddchallenge.domain.social.events.SocialCreated;
import co.com.sofkau.dddchallenge.domain.social.events.SocialStateChanged;
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
class ChangeSocialStateUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ChangeSocialStateUseCase changeSocialStateUseCase;

    @BeforeEach
    public void setup(){
        changeSocialStateUseCase = new ChangeSocialStateUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        // Arrange
        SocialCreated socialCreated = new SocialCreated("socialId", "open", "catalogId");
        socialCreated.setAggregateRootId("socialId");

        ChangeSocialStateCommand command = new ChangeSocialStateCommand("socialId", "archived");
        SocialStateChanged socialStateChanged = new SocialStateChanged("socialId", "archived");
        socialStateChanged.setAggregateRootId("socialId");

        Mockito.when(eventsRepository.findByAggregateRootId("socialId")).thenReturn(List.of(socialCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        List<DomainEvent> domainEvents = changeSocialStateUseCase.apply(command);

        // Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("archived", ((SocialStateChanged) domainEvents.get(0)).getState());
        Assertions.assertEquals("socialId", ((SocialStateChanged) domainEvents.get(0)).aggregateRootId());
    }

}