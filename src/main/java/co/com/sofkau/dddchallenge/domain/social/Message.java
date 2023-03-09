package co.com.sofkau.dddchallenge.domain.social;

import co.com.sofkau.dddchallenge.common.MessageId;
import co.com.sofkau.dddchallenge.common.PlayerId;
import co.com.sofkau.dddchallenge.domain.social.values.Content;
import co.com.sofkau.dddchallenge.generic.Entity;

public class Message extends Entity<MessageId> {

    protected MessageId messageId;
    protected Content content;
    protected PlayerId emiterId;
    protected PlayerId receiverId;

    public Message(MessageId messageId, Content content, PlayerId emiterId, PlayerId receiverId) {
        super(messageId);
        this.messageId = messageId;
        this.content = content;
        this.emiterId = emiterId;
        this.receiverId = receiverId;
    }

    public MessageId messageId() {
        return messageId;
    }

    public Content content() {
        return content;
    }

    public PlayerId emiterId() {
        return emiterId;
    }

    public PlayerId receiverId() {
        return receiverId;
    }

}
