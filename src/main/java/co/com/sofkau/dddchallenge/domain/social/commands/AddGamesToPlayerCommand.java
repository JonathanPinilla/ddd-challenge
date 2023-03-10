package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddGamesToPlayerCommand extends Command {

    private final String socialId;
    private final String playerId;
    private final String gameId;
    private final String catalogId;

    public AddGamesToPlayerCommand(String socialId, String playerId, String gameId, String catalogId) {
        this.socialId = socialId;
        this.playerId = playerId;
        this.gameId = gameId;
        this.catalogId = catalogId;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getGameId() {
        return gameId;
    }

    public String getSocialId() {
        return socialId;
    }

}
