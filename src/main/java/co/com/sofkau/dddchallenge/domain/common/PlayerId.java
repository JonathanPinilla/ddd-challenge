package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class PlayerId extends Identity {

    public PlayerId(String uuid) {
        super(uuid);
    }

    public PlayerId() {
    }

    public static PlayerId of(String uuid) {
        return new PlayerId(uuid);
    }

}
