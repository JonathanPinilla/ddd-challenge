package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class TotalPublishersUpdated extends DomainEvent {

    private final String catalogId;
    private final Integer totalPublishers;

    public TotalPublishersUpdated(String catalogId, Integer totalPublishers) {
        super("dddchallenge.domain.catalog.events.totalPublishersUpdated");
        this.catalogId = catalogId;
        this.totalPublishers = totalPublishers;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public Integer getTotalPublishers() {
        return totalPublishers;
    }

}
