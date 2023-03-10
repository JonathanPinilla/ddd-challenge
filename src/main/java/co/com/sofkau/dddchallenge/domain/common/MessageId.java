package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class MessageId extends Identity {

    public MessageId(String uuid) {
        super(uuid);
    }

    public MessageId() {
    }

    public static MessageId of(String uuid) {
        return new MessageId(uuid);
    }

}
