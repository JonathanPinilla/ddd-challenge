package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.time.LocalDate;

public class PublisherToCatalogAdded extends DomainEvent {

    private final String catalogId;
    private final String publisherId;
    private final String name;
    private final LocalDate foundationDate;

    public PublisherToCatalogAdded(String catalogId, String publisherId, String name, LocalDate foundationDate) {
        super("dddchallenge.domain.catalog.events.publisherToCatalogAdded");
        this.catalogId = catalogId;
        this.publisherId = publisherId;
        this.name = name;
        this.foundationDate = foundationDate;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

}
