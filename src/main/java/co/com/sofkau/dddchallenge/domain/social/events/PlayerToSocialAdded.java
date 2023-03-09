package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class PlayerToSocialAdded extends DomainEvent {

    private final String playerId;
    private final String socialId;

    public PlayerToSocialAdded(String playerId, String socialId) {
        super("dddchallenge.social.playertosocialadded");
        this.playerId = playerId;
        this.socialId = socialId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getSocialId() {
        return socialId;
    }

}
