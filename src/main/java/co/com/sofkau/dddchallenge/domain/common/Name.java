package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class Name implements ValueObject<String> {

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }

}
