package co.com.sofkau.dddchallenge.domain.gameSession;

import co.com.sofkau.dddchallenge.common.ClientId;
import co.com.sofkau.dddchallenge.common.Name;
import co.com.sofkau.dddchallenge.common.ServerId;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ClientToGameSessionAdded;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameSessionCreated;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ServerSessionClosed;
import co.com.sofkau.dddchallenge.domain.gameSession.events.ServerToGameSessionAdded;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Ip;
import co.com.sofkau.dddchallenge.domain.gameSession.values.IsOpen;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Location;
import co.com.sofkau.dddchallenge.generic.EventChange;

import java.util.ArrayList;

public class GameSessionEventChange extends EventChange {

    public GameSessionEventChange(GameSession gameSession) {
        apply((GameSessionCreated event) -> {
            gameSession.clients = new ArrayList<>();
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
                    new Location(event.getLocation())
            ));
        });
        apply((ServerSessionClosed event) -> gameSession.server.closeServer(new IsOpen(event.getIsOpen())));
    }

}
