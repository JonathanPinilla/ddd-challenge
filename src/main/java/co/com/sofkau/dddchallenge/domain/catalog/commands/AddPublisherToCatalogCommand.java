package co.com.sofkau.dddchallenge.domain.catalog.commands;

import co.com.sofkau.dddchallenge.generic.Command;

import java.time.LocalDate;

public class AddPublisherToCatalogCommand extends Command {

    private final String catalogId;
    private final String publisherId;
    private final String name;
    private final LocalDate foundationDate;

    public AddPublisherToCatalogCommand(String catalogId, String publisherId, String name, LocalDate foundationDate) {
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
