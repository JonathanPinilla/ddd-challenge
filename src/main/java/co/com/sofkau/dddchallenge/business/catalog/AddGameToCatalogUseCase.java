package co.com.sofkau.dddchallenge.business.catalog;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.catalog.Catalog;
import co.com.sofkau.dddchallenge.domain.catalog.commands.AddGameToCatalogCommand;
import co.com.sofkau.dddchallenge.domain.common.CatalogId;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddGameToCatalogUseCase implements UseCaseCommand<AddGameToCatalogCommand> {

    EventsRepository eventsRepository;

    public AddGameToCatalogUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(AddGameToCatalogCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getCatalogId());
        var catalog = Catalog.from(CatalogId.of(command.getCatalogId()), events);

        if(catalog.games().stream().anyMatch(g -> g.gameId().value().equals(command.getGameId()))){
            throw new IllegalArgumentException("Game already exists");
        }

        catalog.addGame(
                command.getCatalogId(),
                command.getGameId(),
                command.getName(),
                command.getGenre(),
                command.getPublisher(),
                command.getReleaseDate(),
                command.getPrice()
        );

        return catalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
