package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class GameSessionId extends Identity {

    public GameSessionId(String uuid) {
        super(uuid);
    }

    public GameSessionId() {
    }

    public static GameSessionId of(String uuid) {
        return new GameSessionId(uuid);
    }

}