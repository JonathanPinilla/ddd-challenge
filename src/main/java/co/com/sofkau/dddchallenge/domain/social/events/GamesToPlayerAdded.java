package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class GamesToPlayerAdded extends DomainEvent {

    private final String playerId;
    private final String gameId;

    public GamesToPlayerAdded(String playerId, String gameId) {
        super("dddchallenge.social.gamestoplayeradded");
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getGameId() {
        return gameId;
    }

}
