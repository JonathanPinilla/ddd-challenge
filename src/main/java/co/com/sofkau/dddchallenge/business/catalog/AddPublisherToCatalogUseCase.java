package co.com.sofkau.dddchallenge.business.catalog;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.catalog.Catalog;
import co.com.sofkau.dddchallenge.domain.catalog.commands.AddPublisherToCatalogCommand;
import co.com.sofkau.dddchallenge.domain.common.CatalogId;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public class AddPublisherToCatalogUseCase implements UseCaseCommand<AddPublisherToCatalogCommand> {

    EventsRepository eventsRepository;

    public AddPublisherToCatalogUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(AddPublisherToCatalogCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getCatalogId());
        var catalog = Catalog.from(CatalogId.of(command.getCatalogId()), events);

        if(catalog.publishers().stream().anyMatch(p -> p.publisherId().value().equals(command.getPublisherId()))){
            throw new IllegalArgumentException("Publisher already exists");
        }

        catalog.addPublisher(
                command.getCatalogId(),
                command.getPublisherId(),
                command.getName(),
                command.getFoundationDate()
        );

        return catalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
