package co.com.sofkau.dddchallenge.domain.gameSession.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class ClientToServerConnected extends DomainEvent {

    private final String gameSessionId;
    private final String clientId;
    private final String serverId;

    public ClientToServerConnected(String gameSessionId, String clientId, String serverId) {
        super("dddchallenge.domain.gameSession.clientToServerConnected");
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
