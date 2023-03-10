package co.com.sofkau.dddchallenge.domain.catalog;

import co.com.sofkau.dddchallenge.domain.catalog.events.GameToCatalogAdded;
import co.com.sofkau.dddchallenge.domain.catalog.events.GamesSoldUpdated;
import co.com.sofkau.dddchallenge.domain.catalog.events.PublisherToCatalogAdded;
import co.com.sofkau.dddchallenge.domain.common.CatalogId;
import co.com.sofkau.dddchallenge.domain.catalog.events.CatalogCreated;
import co.com.sofkau.dddchallenge.domain.catalog.values.GamesSold;
import co.com.sofkau.dddchallenge.domain.catalog.values.TotalGames;
import co.com.sofkau.dddchallenge.domain.catalog.values.TotalPublishers;
import co.com.sofkau.dddchallenge.generic.AggregateRoot;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Catalog extends AggregateRoot<CatalogId> {

    protected CatalogId catalogId;
    protected List<Game> games;
    protected List<Publisher> publishers;
    protected TotalGames totalGames;
    protected TotalPublishers totalPublishers;
    protected GamesSold gamesSold;

    public Catalog(CatalogId catalogId, String created) {
        super(catalogId);
        subscribe(new CatalogEventChange(this));
        appendChange(new CatalogCreated(catalogId.value(), created)).apply();
    }

    private Catalog(CatalogId catalogId) {
        super(catalogId);
        subscribe(new CatalogEventChange(this));
    }

    public static Catalog from(CatalogId catalogId, List<DomainEvent> events) {
        Catalog catalog = new Catalog(catalogId);
        events.forEach(catalog::applyEvent);
        return catalog;
    }

    public void addGame(String catalogId, String gameId, String name, String genre, String publisher, LocalDate releaseDate, Double price) {
        Objects.requireNonNull(catalogId);
        Objects.requireNonNull(gameId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(genre);
        Objects.requireNonNull(publisher);
        Objects.requireNonNull(releaseDate);
        Objects.requireNonNull(price);
        appendChange(new GameToCatalogAdded(
                catalogId,
                gameId,
                name,
                genre,
                publisher,
                releaseDate,
                price
        )).apply();
    }

    public void addPublisher(String catalogId, String publisherId, String name, LocalDate foundationDate) {
        Objects.requireNonNull(catalogId);
        Objects.requireNonNull(publisherId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(foundationDate);
        appendChange(new PublisherToCatalogAdded(catalogId, publisherId, name, foundationDate)).apply();
    }

    public List<Publisher> publishers() {
        return publishers;
    }

    public List<Game> games() {
        return games;
    }


    public void updateGamesSold(CatalogId catalogId) {
        appendChange(new GamesSoldUpdated(catalogId.value())).apply();
    }
}
