package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class PublisherId extends Identity {

    public PublisherId(String uuid) {
        super(uuid);
    }

    public PublisherId() {
    }

    public static PublisherId of(String uuid) {
        return new PublisherId(uuid);
    }

}
