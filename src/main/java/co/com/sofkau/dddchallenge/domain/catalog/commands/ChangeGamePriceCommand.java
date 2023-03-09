package co.com.sofkau.dddchallenge.domain.catalog.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class ChangeGamePriceCommand extends Command {

    private final String catalogId;
    private final String gameId;
    private final Double price;

    public ChangeGamePriceCommand(String catalogId, String gameId, Double price) {
        this.catalogId = catalogId;
        this.gameId = gameId;
        this.price = price;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public String getGameId() {
        return gameId;
    }

    public Double getPrice() {
        return price;
    }

}
