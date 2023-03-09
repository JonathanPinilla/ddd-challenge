package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.time.LocalDate;

public class PublisherToCatalogAdded extends DomainEvent {

    private final String catalogId;
    private final String publisherId;
    private final LocalDate foundationDate;

    public PublisherToCatalogAdded(String catalogId, String publisherId, LocalDate foundationDate) {
        super("dddchallenge.domain.catalog.events.publisherToCatalogAdded");
        this.catalogId = catalogId;
        this.publisherId = publisherId;
        this.foundationDate = foundationDate;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

}
