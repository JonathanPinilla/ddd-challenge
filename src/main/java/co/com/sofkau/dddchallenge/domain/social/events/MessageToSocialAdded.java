package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class MessageToSocialAdded extends DomainEvent {

    private final String messageId;
    private final String socialId;
    private final String content;

    public MessageToSocialAdded(String messageId, String socialId, String content) {
        super("dddchallenge.social.messagetosocialadded");
        this.messageId = messageId;
        this.socialId = socialId;
        this.content = content;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getContent() {
        return content;
    }

}
