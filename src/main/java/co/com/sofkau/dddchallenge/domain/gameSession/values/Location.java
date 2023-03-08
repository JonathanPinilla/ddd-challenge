package co.com.sofkau.dddchallenge.domain.gameSession.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

import java.time.LocalDate;

public class Location implements ValueObject<String> {

    private final String location;

    public Location(String location) {
        this.location = location;
    }

    @Override
    public String value() {
        return location;
    }

}
