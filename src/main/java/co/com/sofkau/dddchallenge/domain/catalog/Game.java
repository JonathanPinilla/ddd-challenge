package co.com.sofkau.dddchallenge.domain.catalog;

import co.com.sofkau.dddchallenge.domain.common.GameId;
import co.com.sofkau.dddchallenge.domain.common.Name;
import co.com.sofkau.dddchallenge.domain.catalog.values.Genre;
import co.com.sofkau.dddchallenge.domain.catalog.values.Price;
import co.com.sofkau.dddchallenge.domain.catalog.values.ReleaseDate;
import co.com.sofkau.dddchallenge.domain.common.PublisherId;
import co.com.sofkau.dddchallenge.generic.Entity;

public class Game extends Entity<GameId> {

    protected GameId gameId;
    protected Name name;
    protected Genre genre;
    protected PublisherId publisherId;
    protected ReleaseDate releaseDate;
    protected Price price;

    public Game(GameId gameId, Name name, Genre genre, PublisherId publisherId, ReleaseDate releaseDate, Price price) {
        super(gameId);
        this.gameId = gameId;
        this.name = name;
        this.genre = genre;
        this.publisherId = publisherId;
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

    public PublisherId publisher() {
        return publisherId;
    }

    public ReleaseDate releaseDate() {
        return releaseDate;
    }

    public Price price() {
        return price;
    }

}
