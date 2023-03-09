package co.com.sofkau.dddchallenge.domain.catalog.commands;

import co.com.sofkau.dddchallenge.generic.Command;

import java.time.LocalDate;

public class AddPublisherToCatalogCommand extends Command {

    private final String catalogId;
    private final String publisherId;
    private final LocalDate foundationDate;

    public AddPublisherToCatalogCommand(String catalogId, String publisherId, LocalDate foundationDate) {
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
