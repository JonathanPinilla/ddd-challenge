package co.com.sofkau.dddchallenge.domain.gameSession.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class IsOpen implements ValueObject<Boolean> {

    private final Boolean isOpen;

    public IsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public Boolean value() {
        return isOpen;
    }

}
