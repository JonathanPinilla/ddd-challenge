package co.com.sofkau.dddchallenge.business.catalog;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.catalog.commands.CreateCatalogCommand;
import co.com.sofkau.dddchallenge.domain.catalog.events.CatalogCreated;
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
class CreateCatalogUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateCatalogUseCase createCatalogUseCase;

    @BeforeEach
    public void setup(){
        createCatalogUseCase = new CreateCatalogUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        //Arrange
        CreateCatalogCommand createCatalogCommand = new CreateCatalogCommand(
                "catalogId"
        );

        CatalogCreated catalogCreated = new CatalogCreated(
                "catalogId",
                "created"
        );
        catalogCreated.setAggregateRootId("catalogId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));
        //Act
        List<DomainEvent> domainEvents = createCatalogUseCase.apply(createCatalogCommand);

        //Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("catalogId", domainEvents.get(0).aggregateRootId());
    }

}