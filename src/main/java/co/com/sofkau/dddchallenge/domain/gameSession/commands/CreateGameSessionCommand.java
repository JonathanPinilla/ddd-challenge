package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class CreateGameSessionCommand extends Command {

    private final String gameSessionId;

    public CreateGameSessionCommand(String gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

}
