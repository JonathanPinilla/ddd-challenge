package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class SocialCreated extends DomainEvent {

    private final String socialId;

    public SocialCreated(String socialId) {
        super("dddchallenge.social.socialcreated");
        this.socialId = socialId;
    }

    public String getSocialId() {
        return socialId;
    }

}
