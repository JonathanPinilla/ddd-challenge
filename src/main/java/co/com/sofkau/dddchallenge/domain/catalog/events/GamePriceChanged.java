package co.com.sofkau.dddchallenge.domain.catalog.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class GamePriceChanged extends DomainEvent {

    private final String gameId;
    private final String price;

    public GamePriceChanged(String gameId, String price) {
        super("dddchallenge.domain.catalog.events.gamePriceChanged");
        this.gameId = gameId;
        this.price = price;
    }

    public String getGameId() {
        return gameId;
    }

    public String getPrice() {
        return price;
    }

}
