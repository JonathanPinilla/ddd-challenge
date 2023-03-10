package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.social.commands.CreateSocialCommand;
import co.com.sofkau.dddchallenge.domain.social.events.SocialCreated;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
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
class CreateSocialUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateSocialUseCase createSocialUseCase;

    @BeforeEach
    public void setup(){
        createSocialUseCase = new CreateSocialUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
// Arrange
        CreateSocialCommand command = new CreateSocialCommand(
                "socialId",
                "open",
                "catalogId"
        );
        SocialCreated socialCreated = new SocialCreated(
                "socialId",
                "open",
                "catalogId"
        );
        socialCreated.setAggregateRootId("socialId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        List<DomainEvent> domainEvents = createSocialUseCase.apply(command);

        // Assert
        assertEquals(1, domainEvents.size());
        assertEquals("socialId", domainEvents.get(0).aggregateRootId());
    }

}