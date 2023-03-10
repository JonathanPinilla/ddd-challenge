package co.com.sofkau.dddchallenge.domain.gameSession;

import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.gameSession.events.*;
import co.com.sofkau.dddchallenge.domain.gameSession.values.GameState;
import co.com.sofkau.dddchallenge.domain.gameSession.values.IsOpen;
import co.com.sofkau.dddchallenge.generic.AggregateRoot;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class GameSession extends AggregateRoot<GameSessionId> {

    protected GameSessionId gameSessionId;
    protected Server server;
    protected List<Client> clients;
    protected GameState gameState;
    protected SocialId socialId;

    public GameSession(GameSessionId gameSessionId, GameState gameState, SocialId socialId) {
        super(gameSessionId);
        subscribe(new GameSessionEventChange(this));
        appendChange(new GameSessionCreated(gameSessionId.value(), gameState, socialId.value())).apply();
    }

    private GameSession(GameSessionId gameSessionId) {
        super(gameSessionId);
        subscribe(new GameSessionEventChange(this));
    }

    public static GameSession from(GameSessionId gameSessionId, List<DomainEvent> events) {
        GameSession gameSession = new GameSession(gameSessionId);
        events.forEach(gameSession::applyEvent);
        return gameSession;
    }

    public void addServer(String gameSessionId, String serverId, String name, String location, String ip, Boolean isOpen) {
        Objects.requireNonNull(gameSessionId);
        Objects.requireNonNull(serverId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(location);
        Objects.requireNonNull(ip);
        Objects.requireNonNull(isOpen);
        appendChange(new ServerToGameSessionAdded(gameSessionId, serverId, name, location, ip, isOpen)).apply();
    }

    public void addClient(String gameSessionId, String clientId, String ip, String location, String playerId) {
        Objects.requireNonNull(gameSessionId);
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(ip);
        Objects.requireNonNull(location);
        appendChange(new ClientToGameSessionAdded(gameSessionId, clientId, ip, location, playerId)).apply();
    }

    public void closeServerSession(String gameSessionId, String serverId, Boolean isOpen) {
        Objects.requireNonNull(gameSessionId);
        Objects.requireNonNull(serverId);
        Objects.requireNonNull(isOpen);
        appendChange(new ServerSessionClosed(gameSessionId, serverId, isOpen)).apply();
    }

    public void connectClientToServer(String gameSessionId, String clientId, String serverId) {
        Objects.requireNonNull(gameSessionId);
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(serverId);
        appendChange(new ClientToServerConnected(gameSessionId, clientId, serverId)).apply();
    }

    public void disconnectClientFromServer(String gameSessionId, String clientId, String serverId) {
        Objects.requireNonNull(gameSessionId);
        Objects.requireNonNull(clientId);
        appendChange(new ClientFromServerDisconnected(gameSessionId, clientId)).apply();
    }

    public void updateGameState(String gameSessionId, Integer score, Integer timeLeft, String winnerId, String socialId) {
        Objects.requireNonNull(gameSessionId);
        Objects.requireNonNull(score);
        Objects.requireNonNull(timeLeft);
        Objects.requireNonNull(winnerId);
        appendChange(new GameStateUpdated(gameSessionId, score, timeLeft, winnerId, socialId)).apply();
    }

    public GameSessionId getGameSessionId() {
        return gameSessionId;
    }

    public Server getServer() {
        return server;
    }

    public List<Client> getClients() {
        return clients;
    }

}
