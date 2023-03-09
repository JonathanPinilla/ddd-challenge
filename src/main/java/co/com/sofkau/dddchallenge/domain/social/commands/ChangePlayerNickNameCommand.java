package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class ChangePlayerNickNameCommand extends Command {

    private final String playerId;
    private final String nickName;

    public ChangePlayerNickNameCommand(String playerId, String nickName) {
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
