package co.com.sofkau.dddchallenge.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class ServerId extends Identity {
    public ServerId(String uuid) {
        super(uuid);
    }

    public ServerId() {
    }

    public static ServerId of(String uuid) {
        return new ServerId(uuid);
    }
}
