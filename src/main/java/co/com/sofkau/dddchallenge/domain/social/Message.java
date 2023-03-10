package co.com.sofkau.dddchallenge.domain.social;

import co.com.sofkau.dddchallenge.domain.common.MessageId;
import co.com.sofkau.dddchallenge.domain.common.PlayerId;
import co.com.sofkau.dddchallenge.domain.social.values.Content;
import co.com.sofkau.dddchallenge.generic.Entity;

public class Message extends Entity<MessageId> {

    protected MessageId messageId;
    protected Content content;
    protected PlayerId emitterId;
    protected PlayerId receiverId;

    public Message(MessageId messageId, Content content, PlayerId emitterId, PlayerId receiverId) {
        super(messageId);
        this.messageId = messageId;
        this.content = content;
        this.emitterId = emitterId;
        this.receiverId = receiverId;
    }

    public MessageId messageId() {
        return messageId;
    }

    public Content content() {
        return content;
    }

    public PlayerId emiterId() {
        return emitterId;
    }

    public PlayerId receiverId() {
        return receiverId;
    }

}
