package co.com.sofkau.dddchallenge.domain.social;

import co.com.sofkau.dddchallenge.common.SocialId;
import co.com.sofkau.dddchallenge.generic.AggregateRoot;

import java.util.List;

public class Social extends AggregateRoot<SocialId> {

    protected SocialId socialId;
    protected List<Player> players;
    protected List<Message> messages;

    public Social(SocialId socialId, List<Player> players, List<Message> messages) {
        super(socialId);
        this.socialId = socialId;
        this.players = players;
        this.messages = messages;
    }

}
