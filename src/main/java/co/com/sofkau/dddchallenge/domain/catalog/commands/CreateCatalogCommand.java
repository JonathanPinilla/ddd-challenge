package co.com.sofkau.dddchallenge.domain.catalog.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class CreateCatalogCommand extends Command {

    private final String catalogId;

    public CreateCatalogCommand(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogId() {
        return catalogId;
    }

}
