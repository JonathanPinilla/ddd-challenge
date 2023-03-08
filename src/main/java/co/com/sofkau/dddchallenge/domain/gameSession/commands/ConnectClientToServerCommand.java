package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class ConnectClientToServerCommand extends Command {

    private final String clientId;
    private final String serverId;

    public ConnectClientToServerCommand(String clientId, String serverId) {
        this.clientId = clientId;
        this.serverId = serverId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getServerId() {
        return serverId;
    }

}
