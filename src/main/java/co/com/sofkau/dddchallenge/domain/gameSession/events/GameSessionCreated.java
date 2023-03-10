package co.com.sofkau.dddchallenge.domain.gameSession.events;

import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.gameSession.values.GameState;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class GameSessionCreated extends DomainEvent {

    private final String gameSessionId;
    private final Integer score;
    private final Integer timeLeft;
    private final String winnerId;
    private final String socialId;

    public GameSessionCreated(String gameSessionId, GameState gameState, String socialId) {
        super("dddchallenge.domain.gameSession.gameSessionCreated");
        this.gameSessionId = gameSessionId;
        this.score = gameState.value().score();
        this.timeLeft = gameState.value().timeLeft();
        this.winnerId = gameState.value().winnerId();
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
