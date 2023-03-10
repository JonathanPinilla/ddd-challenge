package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class MessageToSocialAdded extends DomainEvent {

    private final String messageId;
    private final String socialId;
    private final String content;
    private final String emitterId;
    private final String receiverId;

    public MessageToSocialAdded(String messageId, String socialId, String content, String emitterId, String receiverId) {
        super("dddchallenge.social.messageToSocialAdded");
        this.messageId = messageId;
        this.socialId = socialId;
        this.content = content;
        this.emitterId = emitterId;
        this.receiverId = receiverId;
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

    public String getEmitterId() {
        return emitterId;
    }

    public String getReceiverId() {
        return receiverId;
    }

}
