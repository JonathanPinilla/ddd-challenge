package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddMessageToSocialCommand extends Command {

    private final String socialId;
    private final String messageId;
    private final String content;
    private final String emitterId;
    private final String receiverId;

    public AddMessageToSocialCommand(String socialId, String messageId, String content, String emitterId, String receiverId) {
        this.socialId = socialId;
        this.messageId = messageId;
        this.content = content;
        this.emitterId = emitterId;
        this.receiverId = receiverId;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getMessageId() {
        return messageId;
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
