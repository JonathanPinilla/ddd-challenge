package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class GameToPlayerAdded extends DomainEvent {

    private final String socialId;
    private final String playerId;
    private final String gameId;
    private final String catalogId;

    public GameToPlayerAdded(String socialId, String playerId, String gameId, String catalogId) {
        super("dddchallenge.social.gameToPlayerAdded");
        this.socialId = socialId;
        this.playerId = playerId;
        this.gameId = gameId;
        this.catalogId = catalogId;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getGameId() {
        return gameId;
    }

    public String getSocialId() {
        return socialId;
    }

}
