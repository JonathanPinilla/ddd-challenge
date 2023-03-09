package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class AddMessageToSocialCommand extends Command {

    private final String socialId;
    private final String messageId;
    private final String content;

    public AddMessageToSocialCommand(String socialId, String messageId, String content) {
        this.socialId = socialId;
        this.messageId = messageId;
        this.content = content;
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

}
