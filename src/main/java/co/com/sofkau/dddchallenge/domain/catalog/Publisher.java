package co.com.sofkau.dddchallenge.domain.catalog;

import co.com.sofkau.dddchallenge.common.Name;
import co.com.sofkau.dddchallenge.common.PublisherId;
import co.com.sofkau.dddchallenge.domain.catalog.values.FoundationDate;
import co.com.sofkau.dddchallenge.generic.Entity;

import java.util.ArrayList;
import java.util.List;

public class Publisher extends Entity<PublisherId> {

    protected PublisherId publisherId;
    protected Name name;
    protected FoundationDate foundationDate;
    protected List<Game> games;

    public Publisher(PublisherId publisherId, Name name, FoundationDate foundationDate) {
        super(publisherId);
        this.publisherId = publisherId;
        this.name = name;
        this.foundationDate = foundationDate;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public void updateName(Name name) {
        this.name = name;
    }

    public void updateFoundationDate(FoundationDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public PublisherId publisherId() {
        return publisherId;
    }

    public Name name() {
        return name;
    }

    public FoundationDate foundationDate() {
        return foundationDate;
    }

}
