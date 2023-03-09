package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class PlayerToFriendListAdded extends DomainEvent {

    private final String playerId;
    private final String friendId;

    public PlayerToFriendListAdded(String playerId, String friendId) {
        super("dddchallenge.social.playertofriendlistadded");
        this.playerId = playerId;
        this.friendId = friendId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getFriendId() {
        return friendId;
    }

}
