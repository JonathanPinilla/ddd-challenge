package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddPlayerToSocialCommand extends Command {

    private final String socialId;
    private final String playerId;

    public AddPlayerToSocialCommand(String socialId, String playerId) {
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
