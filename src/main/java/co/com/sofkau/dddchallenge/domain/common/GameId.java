package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class GameId extends Identity {

    public GameId(String uuid) {
        super(uuid);
    }

    public GameId() {
    }

    public static GameId of(String uuid) {
        return new GameId(uuid);
    }

}
