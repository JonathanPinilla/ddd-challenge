package co.com.sofkau.dddchallenge.domain.gameSession;

import co.com.sofkau.dddchallenge.domain.common.Name;
import co.com.sofkau.dddchallenge.domain.common.ServerId;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Ip;
import co.com.sofkau.dddchallenge.domain.gameSession.values.IsOpen;
import co.com.sofkau.dddchallenge.domain.gameSession.values.Location;
import co.com.sofkau.dddchallenge.generic.Entity;

public class Server extends Entity<ServerId> {

    protected ServerId serverId;
    protected Name name;
    protected Location location;
    protected Ip ip;
    protected IsOpen isOpen;

    public Server(ServerId id, Name name, Location location, Ip ip, IsOpen isOpen) {
        super(id);
        this.name = name;
        this.location = location;
        this.ip = ip;
        this.isOpen = isOpen;
    }

    public ServerId serverId() {
        return serverId;
    }

    public Name name() {
        return name;
    }

    public Location location() {
        return location;
    }

    public Ip ip() {
        return ip;
    }

    public IsOpen isOpen() {
        return isOpen;
    }

    public void closeServer(IsOpen isOpen) {
        this.isOpen = isOpen;
    }
}
