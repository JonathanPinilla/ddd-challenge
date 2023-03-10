package co.com.sofkau.dddchallenge.domain.catalog;

import co.com.sofkau.dddchallenge.domain.common.GameId;
import co.com.sofkau.dddchallenge.domain.common.Name;
import co.com.sofkau.dddchallenge.domain.catalog.values.Genre;
import co.com.sofkau.dddchallenge.domain.catalog.values.Price;
import co.com.sofkau.dddchallenge.domain.catalog.values.ReleaseDate;
import co.com.sofkau.dddchallenge.generic.Entity;

public class Game extends Entity<GameId> {

    protected GameId gameId;
    protected Name name;
    protected Genre genre;
    protected Publisher publisher;
    protected ReleaseDate releaseDate;
    protected Price price;

    public Game(GameId gameId, Name name, Genre genre, Publisher publisher, ReleaseDate releaseDate, Price price) {
        super(gameId);
        this.gameId = gameId;
        this.name = name;
        this.genre = genre;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public void updateGenre(Genre genre) {
        this.genre = genre;
    }

    public void updatePrice(Price price) {
        this.price = price;
    }

    public GameId gameId() {
        return gameId;
    }

    public Name name() {
        return name;
    }

    public Genre genre() {
        return genre;
    }

    public Publisher publisher() {
        return publisher;
    }

    public ReleaseDate releaseDate() {
        return releaseDate;
    }

    public Price price() {
        return price;
    }

}
