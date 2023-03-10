package co.com.sofkau.dddchallenge.domain.gameSession;

import co.com.sofkau.dddchallenge.domain.common.ClientId;
import co.com.sofkau.dddchallenge.domain.common.PlayerId;
import co.com.sofkau.dddchallenge.domain.common.ServerId;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Ip;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Location;
import co.com.sofkau.dddchallenge.generic.Entity;

import java.util.Objects;

public class Client extends Entity<ClientId> {

    protected ClientId clientId;
    protected Ip ip;
    protected Location location;
    protected ServerId serverId;
    protected PlayerId playerId;

    public Client(ClientId id, Ip ip, Location location, PlayerId playerId) {
        super(id);
        this.ip = ip;
        this.location = location;
    }

    public ClientId clientId() {
        return clientId;
    }

    public Ip ip() {
        return ip;
    }

    public Location location() {
        return location;
    }

    public ServerId server() {
        return serverId;
    }

    public void connectToServer(ServerId serverId) {
        Objects.requireNonNull(serverId);
        this.serverId = serverId;
    }

    public void disconnectFromServer(ServerId serverId) {
        this.serverId = null;
    }
}
