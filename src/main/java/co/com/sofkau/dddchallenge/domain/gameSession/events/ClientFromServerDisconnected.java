package co.com.sofkau.dddchallenge.domain.gameSession.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class ClientFromServerDisconnected extends DomainEvent {

    private final String gameSessionId;
    private final String clientId;
    private final String serverId;

    public ClientFromServerDisconnected(String gameSessionId, String clientId) {
        super("dddchallenge.domain.gameSession.clientFromServerDisconnected");
        this.gameSessionId = gameSessionId;
        this.clientId = clientId;
        this.serverId = null;
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
