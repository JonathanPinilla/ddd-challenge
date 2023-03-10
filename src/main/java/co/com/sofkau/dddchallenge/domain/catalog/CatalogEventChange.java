package co.com.sofkau.dddchallenge.domain.catalog;

import co.com.sofkau.dddchallenge.domain.common.CatalogId;
import co.com.sofkau.dddchallenge.domain.common.GameId;
import co.com.sofkau.dddchallenge.domain.common.Name;
import co.com.sofkau.dddchallenge.domain.common.PublisherId;
import co.com.sofkau.dddchallenge.domain.catalog.events.*;
import co.com.sofkau.dddchallenge.domain.catalog.values.*;
import co.com.sofkau.dddchallenge.generic.EventChange;

import java.util.ArrayList;

public class CatalogEventChange extends EventChange {

    public CatalogEventChange(Catalog catalog) {
        apply((CatalogCreated event) -> {
            catalog.catalogId = new CatalogId(event.getCatalogId());
            catalog.publishers = new ArrayList<>();
            catalog.games = new ArrayList<>();
            catalog.totalGames = new TotalGames(0);
            catalog.totalPublishers = new TotalPublishers(0);
            catalog.gamesSold = new GamesSold(0);
        });
        apply((TotalPublishersUpdated event) -> {
            catalog.totalPublishers = new TotalPublishers(catalog.totalPublishers.value() + 1);
        });
        apply((GamesSoldUpdated event) -> {
            catalog.gamesSold = new GamesSold(catalog.gamesSold.value() + 1);
        });
        apply((GamePriceChanged event) -> {
            catalog.games.stream().filter(game -> game.gameId.value().equals(event.getGameId())).forEach(game -> {
                game.price = new Price(event.getPrice());
            });
        });
        apply((GameToCatalogAdded event) -> {
            catalog.games.add(
                    new Game(GameId.of(event.getGameId()),
                            new Name(event.getName()),
                            new Genre(event.getGenre()),
                            PublisherId.of(event.getPublisherId()),
                            new ReleaseDate(event.getReleaseDate()),
                            new Price(event.getPrice())))
            ;
        });
        apply((PublisherToCatalogAdded event) -> {
            catalog.publishers.add(
                    new Publisher(
                            PublisherId.of(event.getPublisherId()),
                            new Name(event.getName()),
                            new FoundationDate(event.getFoundationDate())
                    )
            );
        });
    }

}
