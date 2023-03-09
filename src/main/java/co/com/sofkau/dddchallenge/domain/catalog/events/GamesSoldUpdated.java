package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class GamesSoldUpdated extends DomainEvent {

    private final String catalogId;
    private final Integer gamesSold;

    public GamesSoldUpdated(String catalogId, Integer gamesSold) {
        super("dddchallenge.domain.catalog.events.gamesSoldUpdated");
        this.catalogId = catalogId;
        this.gamesSold = gamesSold;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public Integer getGamesSold() {
        return gamesSold;
    }

}
