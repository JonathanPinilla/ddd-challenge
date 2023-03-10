package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class DisconnectClientFromServerCommand extends Command {

    private final String gameSessionId;
    private final String clientId;
    private final String serverId;

    public DisconnectClientFromServerCommand(String gameSessionId, String clientId, String serverId) {
        this.gameSessionId = gameSessionId;
        this.clientId = clientId;
        this.serverId = serverId;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getServerId() {
        return serverId;
    }

}
