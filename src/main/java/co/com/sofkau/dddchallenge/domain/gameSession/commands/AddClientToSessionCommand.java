package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddClientToSessionCommand extends Command {

    private final String gameSessionId;
    private final String clientId;
    private final String ip;
    private final String location;

    public AddClientToSessionCommand(String gameSessionId, String clientId, String ip, String location) {
        this.gameSessionId = gameSessionId;
        this.clientId = clientId;
        this.ip = ip;
        this.location = location;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getIp() {
        return ip;
    }

    public String getLocation() {
        return location;
    }

}
