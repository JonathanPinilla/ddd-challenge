package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class MatchesWonToPlayerAdded extends DomainEvent {

    private final String socialId;
    private final String playerId;

    public MatchesWonToPlayerAdded(String socialId, String playerId) {
        super("dddchallenge.social.matchesWonToPlayerAdded");
        this.socialId = socialId;
        this.playerId = playerId;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getPlayerId() {
        return playerId;
    }

}
