package co.com.sofkau.dddchallenge.domain.gameSession.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class ClientToGameSessionAdded extends DomainEvent {

    private final String gameSessionId;
    private final String clientId;
    private final String ip;
    private final String location;
    private final String serverId;

    public ClientToGameSessionAdded(String gameSessionId, String clientId, String ip, String location, String serverId) {
        super("dddchallenge.domain.gameSession.clientToGameSessionAdded");
        this.gameSessionId = gameSessionId;
        this.clientId = clientId;
        this.ip = ip;
        this.location = location;
        this.serverId = serverId;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getIp() {
        return ip;
    }

    public String getLocation() {
        return location;
    }

    public String getServerId() {
        return serverId;
    }

}
