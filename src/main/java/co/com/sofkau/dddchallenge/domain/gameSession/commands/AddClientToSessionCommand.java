package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddClientToSessionCommand extends Command {

    private final String gameSessionId;
    private final String clientId;
    private final String ip;
    private final String location;
    private final String playerId;

    public AddClientToSessionCommand(String gameSessionId, String clientId, String ip, String location, String playerId) {
        this.gameSessionId = gameSessionId;
        this.clientId = clientId;
        this.ip = ip;
        this.location = location;
        this.playerId = playerId;
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

    public String getPlayerId() {
        return playerId;
    }

}
