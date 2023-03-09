package co.com.sofkau.dddchallenge.domain.catalog.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

import java.time.LocalDate;

public class FoundationDate implements ValueObject<LocalDate> {

    private final LocalDate value;

    public FoundationDate(LocalDate value) {
        this.value = value;
    }

    @Override
    public LocalDate value() {
        return value;
    }

}
