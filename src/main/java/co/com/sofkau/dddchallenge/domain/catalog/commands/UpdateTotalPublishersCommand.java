package co.com.sofkau.dddchallenge.domain.catalog.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class UpdateTotalPublishersCommand extends Command {

    private final String catalogId;
    private final Integer totalPublishers;

    public UpdateTotalPublishersCommand(String catalogId, Integer totalPublishers) {
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
