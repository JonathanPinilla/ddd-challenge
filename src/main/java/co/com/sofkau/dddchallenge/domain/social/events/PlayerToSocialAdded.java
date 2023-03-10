package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class PlayerToSocialAdded extends DomainEvent {

    private final String playerId;
    private final String socialId;
    private final String name;
    private final String nickName;

    public PlayerToSocialAdded(String socialId, String playerId, String name, String nickName) {
        super("dddchallenge.social.playertosocialadded");
        this.playerId = playerId;
        this.socialId = socialId;
        this.name = name;
        this.nickName = nickName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

}
