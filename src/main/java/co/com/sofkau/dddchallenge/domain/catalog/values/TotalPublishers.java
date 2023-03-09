package co.com.sofkau.dddchallenge.domain.catalog.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class TotalPublishers implements ValueObject<Integer> {

    private final Integer value;

    public TotalPublishers(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
