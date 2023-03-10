package co.com.sofkau.dddchallenge.domain.gameSession.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class GameState implements ValueObject<GameState.Props> {

    private final Integer score;
    private final Integer timeLeft;
    private final String winnerId;

    public GameState(Integer score, Integer timeLeft, String winnerId) {
        this.score = score;
        this.timeLeft = timeLeft;
        this.winnerId = winnerId;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer score() {
                return score;
            }

            @Override
            public Integer timeLeft() {
                return timeLeft;
            }

            @Override
            public String winnerId() {
                return winnerId;
            }
        };
    }

    public interface Props {
        Integer score();
        Integer timeLeft();
        String winnerId();
    }
}
