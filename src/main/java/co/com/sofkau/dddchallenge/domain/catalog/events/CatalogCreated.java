package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class CatalogCreated extends DomainEvent {

    private final String catalogId;
    private final String created;

    public CatalogCreated(String catalogId, String created) {
        super("dddchallenge.catalog.catalogCreated");
        this.catalogId = catalogId;
        this.created = created;
    }

    public String getCatalogId() {
        return catalogId;
    }

}
