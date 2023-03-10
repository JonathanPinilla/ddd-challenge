package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class ClientId extends Identity {

    public ClientId(String uuid) {
        super(uuid);
    }

    public ClientId() {
    }

    public static ClientId of(String uuid) {
        return new ClientId(uuid);
    }

}
