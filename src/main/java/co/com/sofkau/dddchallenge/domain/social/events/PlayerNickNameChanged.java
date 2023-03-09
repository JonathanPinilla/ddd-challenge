package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class PlayerNickNameChanged extends DomainEvent {

    private final String playerId;
    private final String nickName;

    public PlayerNickNameChanged(String playerId, String nickName) {
        super("dddchallenge.social.playernicknamechanged");
        this.playerId = playerId;
        this.nickName = nickName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getNickName() {
        return nickName;
    }

}
