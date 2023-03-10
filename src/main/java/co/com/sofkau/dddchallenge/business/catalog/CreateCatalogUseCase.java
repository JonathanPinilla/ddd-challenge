package co.com.sofkau.dddchallenge.business.catalog;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.catalog.Catalog;
import co.com.sofkau.dddchallenge.domain.catalog.commands.CreateCatalogCommand;
import co.com.sofkau.dddchallenge.domain.common.CatalogId;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateCatalogUseCase implements UseCaseCommand<CreateCatalogCommand> {

    EventsRepository eventsRepository;

    public CreateCatalogUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(CreateCatalogCommand command) {

        var catalog = new Catalog(CatalogId.of(command.getCatalogId()), "created");

        return catalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }

}
