package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddGamesToPlayerCommand extends Command {

    private final String playerId;
    private final String gameId;

    public AddGamesToPlayerCommand(String playerId, String gameId) {
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getGameId() {
        return gameId;
    }

}
