package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddPlayerToSocialCommand extends Command {

    private final String socialId;
    private final String playerId;
    private final String name;
    private final String nickName;

    public AddPlayerToSocialCommand(String socialId, String playerId, String name, String nickName) {
        this.socialId = socialId;
        this.playerId = playerId;
        this.name = name;
        this.nickName = nickName;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

}
