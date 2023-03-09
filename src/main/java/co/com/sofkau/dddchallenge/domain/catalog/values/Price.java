package co.com.sofkau.dddchallenge.domain.catalog.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class Price implements ValueObject<Double> {

    private final Double value;

    public Price(Double value) {
        this.value = value;
    }

    @Override
    public Double value() {
        return value;
    }

}
