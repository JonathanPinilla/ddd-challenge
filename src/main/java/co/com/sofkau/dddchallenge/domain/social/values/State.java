package co.com.sofkau.dddchallenge.domain.social.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class State implements ValueObject<String> {

    private final String value;

    public State(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
