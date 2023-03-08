package co.com.sofkau.dddchallenge.domain.gameSession;

import co.com.sofkau.dddchallenge.common.ClientId;
import co.com.sofkau.dddchallenge.domain.gameSession.Server;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Ip;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Location;
import co.com.sofkau.dddchallenge.generic.Entity;

public class Client extends Entity<ClientId> {

    protected ClientId clientId;
    protected Ip ip;
    protected Location location;
    protected Server server;

    public Client(ClientId id, Ip ip, Location location) {
        super(id);
        this.ip = ip;
        this.location = location;
    }

    public Ip ip() {
        return ip;
    }

    public Location location() {
        return location;
    }

    public Server server() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
