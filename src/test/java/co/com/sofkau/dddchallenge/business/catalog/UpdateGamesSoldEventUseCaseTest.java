package co.com.sofkau.dddchallenge.business.catalog;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.domain.catalog.Catalog;
import co.com.sofkau.dddchallenge.domain.catalog.events.CatalogCreated;
import co.com.sofkau.dddchallenge.domain.catalog.events.GameToCatalogAdded;
import co.com.sofkau.dddchallenge.domain.catalog.events.GamesSoldUpdated;
import co.com.sofkau.dddchallenge.domain.catalog.events.PublisherToCatalogAdded;
import co.com.sofkau.dddchallenge.domain.social.events.GameToPlayerAdded;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateGamesSoldEventUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private UpdateGamesSoldEventUseCase updateGamesSoldEventUseCase;

    @BeforeEach
    public void setup(){
        updateGamesSoldEventUseCase = new UpdateGamesSoldEventUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        //Arrange
        CatalogCreated catalogCreated = new CatalogCreated(
                "catalogId",
                "created"
        );
        catalogCreated.setAggregateRootId("catalogId");

        PublisherToCatalogAdded publisherToCatalogAdded = new PublisherToCatalogAdded(
                "catalogId",
                "publisherId",
                "publisherName",
                LocalDate.of(1998, 7, 6)
        );
        publisherToCatalogAdded.setAggregateRootId("catalogId");

        GameToCatalogAdded gameToCatalogAdded = new GameToCatalogAdded(
                "catalogId",
                "gameId",
                "Best game ever",
                "Action",
                "publisherId",
                LocalDate.of(2021, 7, 6),
                39.99
        );
        gameToCatalogAdded.setAggregateRootId("catalogId");

        GameToPlayerAdded gameToPlayerAdded = new GameToPlayerAdded(
                "socialId",
                "playerId",
                "gameId",
                "catalogId"
        );

        GamesSoldUpdated gamesSoldUpdated = new GamesSoldUpdated(
                "catalogId"
        );

        Mockito.when(eventsRepository.findByAggregateRootId("catalogId")).thenReturn(List.of(
                catalogCreated,
                publisherToCatalogAdded,
                gameToCatalogAdded
        ));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        //Act
        List<DomainEvent> domainEvents = updateGamesSoldEventUseCase.apply(gameToPlayerAdded);

        //Assert
        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals("catalogId", ((GamesSoldUpdated) domainEvents.get(0)).getCatalogId());
    }

}