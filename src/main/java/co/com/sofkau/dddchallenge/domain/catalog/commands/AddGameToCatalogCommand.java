package co.com.sofkau.dddchallenge.domain.catalog.commands;

import co.com.sofkau.dddchallenge.domain.catalog.Publisher;
import co.com.sofkau.dddchallenge.generic.Command;

import java.time.LocalDate;

public class AddGameToCatalogCommand extends Command {

    private final String catalogId;
    private final String gameId;
    private final String name;
    private final String genre;
    private final Publisher publisher;
    private final LocalDate releaseDate;
    private final Double price;

    public AddGameToCatalogCommand(String catalogId, String gameId, String name, String genre, Publisher publisher, LocalDate releaseDate, Double price) {
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
