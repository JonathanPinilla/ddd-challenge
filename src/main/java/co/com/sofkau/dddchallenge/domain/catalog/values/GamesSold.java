package co.com.sofkau.dddchallenge.domain.catalog.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class GamesSold implements ValueObject<Integer> {

    private final Integer value;

    public GamesSold(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
