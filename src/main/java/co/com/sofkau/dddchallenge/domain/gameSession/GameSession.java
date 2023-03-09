package co.com.sofkau.dddchallenge.domain.gameSession;

import co.com.sofkau.dddchallenge.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameSessionCreated;
import co.com.sofkau.dddchallenge.generic.AggregateRoot;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public class GameSession extends AggregateRoot<GameSessionId> {

    protected GameSessionId gameSessionId;
    protected Server server;
    protected List<Client> clients;

    public GameSession(GameSessionId gameSessionId) {
        super(gameSessionId);
        subscribe(new GameSessionEventChange(this));
        appendChange(new GameSessionCreated(gameSessionId.value())).apply();
    }

    public static GameSession from(GameSessionId gameSessionId, List<DomainEvent> events) {
        var gameSession = new GameSession(gameSessionId);
        events.forEach(gameSession::applyEvent);
        return gameSession;
    }

}
