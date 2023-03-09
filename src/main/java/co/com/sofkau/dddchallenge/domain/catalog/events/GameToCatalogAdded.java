package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.domain.catalog.Publisher;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.time.LocalDate;

public class GameToCatalogAdded extends DomainEvent {

    private final String catalogId;
    private final String gameId;
    private final String name;
    private final String genre;
    private final Publisher publisher;
    private final LocalDate releaseDate;
    private final Double price;

    public GameToCatalogAdded(String catalogId, String gameId, String name, String genre, Publisher publisher, LocalDate releaseDate, Double price) {
        super("dddchallenge.domain.catalog.events.gameToCatalogAdded");
        this.catalogId = catalogId;
        this.gameId = gameId;
        this.name = name;
        this.genre = genre;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public String getGameId() {
        return gameId;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Double getPrice() {
        return price;
    }

}
