package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddPlayersToFriendListCommand extends Command {

    private final String playerId;
    private final String friendId;

    public AddPlayersToFriendListCommand(String playerId, String friendId) {
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
