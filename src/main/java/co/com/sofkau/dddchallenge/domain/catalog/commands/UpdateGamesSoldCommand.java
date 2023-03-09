package co.com.sofkau.dddchallenge.domain.catalog.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class UpdateGamesSoldCommand extends Command {

    private final String catalogId;
    private final Integer gamesSold;

    public UpdateGamesSoldCommand(String catalogId, Integer gamesSold) {
        this.catalogId = catalogId;
        this.gamesSold = gamesSold;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public Integer getGamesSold() {
        return gamesSold;
    }

}
