package co.com.sofkau.dddchallenge.domain.gameSession.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class ServerToGameSessionAdded extends DomainEvent {

    private final String gameSessionId;
    private final String serverId;
    private final String name;
    private final String location;
    private final String ip;
    private final boolean isOpen;

    public ServerToGameSessionAdded(String gameSessionId, String serverId, String name, String location, String ip, boolean isOpen) {
        super("dddchallenge.domain.gameSession.serverToGameSessionAdded");
        this.gameSessionId = gameSessionId;
        this.serverId = serverId;
        this.name = name;
        this.location = location;
        this.ip = ip;
        this.isOpen = isOpen;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public String getServerId() {
        return serverId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getIp() {
        return ip;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

}
