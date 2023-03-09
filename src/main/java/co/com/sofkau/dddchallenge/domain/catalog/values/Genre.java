package co.com.sofkau.dddchallenge.domain.catalog.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class Genre implements ValueObject<String> {

    private final String value;

    public Genre(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
