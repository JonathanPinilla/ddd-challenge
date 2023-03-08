package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class CloseServerSessionCommand extends Command {

    private final String gameSessionId;
    private final Boolean isOpen;

    public CloseServerSessionCommand(String gameSessionId, Boolean isOpen) {
        this.gameSessionId = gameSessionId;
        this.isOpen = isOpen;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

}
