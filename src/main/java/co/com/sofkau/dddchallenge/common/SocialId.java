package co.com.sofkau.dddchallenge.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class SocialId extends Identity {

    public SocialId(String uuid) {
        super(uuid);
    }

    public SocialId() {
    }

    public static SocialId of(String uuid) {
        return new SocialId(uuid);
    }

}
