package co.com.sofkau.dddchallenge.domain.gameSession.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class GameSessionCreated extends DomainEvent {

    private final String gameSessionId;

    public GameSessionCreated(String gameSessionId) {
        super("dddchallenge.domain.gameSession.gameSessionCreated");
        this.gameSessionId = gameSessionId;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

}
