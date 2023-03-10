package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class SocialCreated extends DomainEvent {

    private final String socialId;
    private final String state;
    private final String catalogId;

    public SocialCreated(String socialId, String state, String catalogId) {
        super("dddchallenge.social.socialcreated");
        this.socialId = socialId;
        this.state = state;
        this.catalogId = catalogId;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getState() {
        return state;
    }

    public String getCatalogId() {
        return catalogId;
    }

}
