package co.com.sofkau.dddchallenge.domain.social.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class MatchesWon implements ValueObject<Integer> {

    private final Integer value;

    public MatchesWon(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
