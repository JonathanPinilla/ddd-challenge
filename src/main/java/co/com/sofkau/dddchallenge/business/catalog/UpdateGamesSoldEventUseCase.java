package co.com.sofkau.dddchallenge.business.catalog;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseEvent;
import co.com.sofkau.dddchallenge.domain.catalog.Catalog;
import co.com.sofkau.dddchallenge.domain.common.CatalogId;
import co.com.sofkau.dddchallenge.domain.social.events.GameToPlayerAdded;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateGamesSoldEventUseCase implements UseCaseEvent<GameToPlayerAdded> {

    EventsRepository eventsRepository;

    public UpdateGamesSoldEventUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(GameToPlayerAdded event) {

        List<DomainEvent> events = eventsRepository.findByAggregateRootId(event.getCatalogId());
        var catalog = Catalog.from(CatalogId.of(event.getCatalogId()), events);

        if (catalog.games().stream().anyMatch(g -> g.gameId().value().equals(event.getGameId()))){
            catalog.updateGamesSold(CatalogId.of(event.getCatalogId()));
        } else {
            throw new IllegalArgumentException("Game does not exist");
        }

        return catalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
