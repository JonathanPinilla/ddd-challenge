package co.com.sofkau.dddchallenge.domain.catalog.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

import java.time.LocalDate;

public class ReleaseDate implements ValueObject<LocalDate> {

    private final LocalDate value;

    public ReleaseDate(LocalDate value) {
        this.value = value;
    }

    @Override
    public LocalDate value() {
        return value;
    }

}
