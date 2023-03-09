package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class CatalogCreated extends DomainEvent {

    private final String catalogId;

    public CatalogCreated(String catalogId) {
        super("dddchallenge.catalog.catalogCreated");
        this.catalogId = catalogId;
    }

    public String getCatalogId() {
        return catalogId;
    }

}
