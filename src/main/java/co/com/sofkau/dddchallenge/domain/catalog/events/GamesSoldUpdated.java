package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class GamesSoldUpdated extends DomainEvent {

    private final String catalogId;

    public GamesSoldUpdated(String catalogId) {
        super("dddchallenge.domain.catalog.events.gamesSoldUpdated");
        this.catalogId = catalogId;
    }

    public String getCatalogId() {
        return catalogId;
    }

}
