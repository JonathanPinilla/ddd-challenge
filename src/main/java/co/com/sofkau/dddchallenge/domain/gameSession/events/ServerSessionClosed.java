package co.com.sofkau.dddchallenge.domain.gameSession.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class ServerSessionClosed extends DomainEvent {

    private final String gameSessionId;
    private final String serverId;
    private final Boolean isOpen;

    public ServerSessionClosed(String gameSessionId, String serverId, Boolean isOpen) {
        super("dddchallenge.domain.gameSession.serverSessionClosed");
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
