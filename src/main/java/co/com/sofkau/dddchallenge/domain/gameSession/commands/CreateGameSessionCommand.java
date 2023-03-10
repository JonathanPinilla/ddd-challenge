package co.com.sofkau.dddchallenge.domain.gameSession.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class CreateGameSessionCommand extends Command {

    private final String gameSessionId;
    private final Integer score;
    private final Integer timeLeft;
    private final String winnerId;
    private final String socialId;

    public CreateGameSessionCommand(String gameSessionId, Integer score, Integer timeLeft, String winnerId, String socialId) {
        this.gameSessionId = gameSessionId;
        this.score = score;
        this.timeLeft = timeLeft;
        this.winnerId = winnerId;
        this.socialId = socialId;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getTimeLeft() {
        return timeLeft;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public String getSocialId() {
        return socialId;
    }

}
