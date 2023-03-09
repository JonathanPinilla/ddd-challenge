package co.com.sofkau.dddchallenge.domain.catalog.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class TotalGames implements ValueObject<Integer> {

    private final Integer value;

    public TotalGames(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
