package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class CloseServerSessionCommand extends Command {

    private final String gameSessionId;
    private final String serverId;
    private final Boolean isOpen;

    public CloseServerSessionCommand(String gameSessionId,  String serverId, Boolean isOpen) {
        this.gameSessionId = gameSessionId;
        this.serverId = serverId;
        this.isOpen = isOpen;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public String getServerId() {
        return serverId;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

}
