package co.com.sofkau.dddchallenge.domain.gameSession;

import co.com.sofkau.dddchallenge.domain.common.*;
import co.com.sofkau.dddchallenge.domain.gameSession.events.*;
import co.com.sofkau.dddchallenge.domain.gameSession.values.GameState;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Ip;
import co.com.sofkau.dddchallenge.domain.gameSession.values.IsOpen;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Location;
import co.com.sofkau.dddchallenge.generic.EventChange;

import java.util.ArrayList;

public class GameSessionEventChange extends EventChange {

    public GameSessionEventChange(GameSession gameSession) {
        apply((GameSessionCreated event) -> {
            gameSession.clients = new ArrayList<>();
            gameSession.gameState = new GameState(
                    event.getScore(),
                    event.getTimeLeft(),
                    event.getWinnerId()
            );
        });
        apply((ServerToGameSessionAdded event) -> {
            gameSession.server = new Server(
                    ServerId.of(event.getServerId()),
                    new Name(event.getName()),
                    new Location(event.getLocation()),
                    new Ip(event.getIp()),
                    new IsOpen(event.getIsOpen())
            );
        });
        apply((ClientToGameSessionAdded event) -> {
            gameSession.clients.add(new Client(
                    ClientId.of(event.getClientId()),
                    new Ip(event.getIp()),
                    new Location(event.getLocation()),
                    new PlayerId(event.getPlayerId())
            ));
        });
        apply((ServerSessionClosed event) -> {
            gameSession.server.closeServer(new IsOpen(event.getIsOpen()));
        });
        apply((GameStateUpdated event) -> {
            gameSession.updateGameState(
                    event.getGameSessionId(),
                    event.getScore(),
                    event.getTimeLeft(),
                    event.getWinnerId(),
                    event.getWinnerId()
            );
        });
        apply((ClientToServerConnected event) -> {
            gameSession.clients.stream()
                    .filter(client -> client.identity().value().equals(event.getClientId()))
                    .forEach(client -> client.connectToServer(new ServerId(event.getServerId())));
        });
        apply((ClientFromServerDisconnected event) -> {
            gameSession.clients.stream()
                    .filter(client -> client.identity().value().equals(event.getClientId()))
                    .forEach(client -> client.disconnectFromServer(new ServerId(event.getServerId())));
        });
    }

}
