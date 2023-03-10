package co.com.sofkau.dddchallenge.domain.social;

import co.com.sofkau.dddchallenge.domain.common.CatalogId;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.social.events.*;
import co.com.sofkau.dddchallenge.domain.social.values.State;
import co.com.sofkau.dddchallenge.generic.AggregateRoot;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public class Social extends AggregateRoot<SocialId> {

    protected SocialId socialId;
    protected List<Player> players;
    protected List<Message> messages;
    protected State state;
    protected CatalogId catalogId;

    public Social(SocialId socialId, State state, CatalogId catalogId) {
        super(socialId);
        subscribe(new SocialEventChange(this));
        appendChange(new SocialCreated(socialId.value(), state.value(), catalogId.value())).apply();
    }

    private Social(SocialId socialId) {
        super(socialId);
        subscribe(new SocialEventChange(this));
    }

    public static Social from(SocialId socialId, List<DomainEvent> events) {
        Social social = new Social(socialId);
        events.forEach(social::applyEvent);
        return social;
    }

    public SocialId getSocialId() {
        return socialId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public State getState() {
        return state;
    }

    public void addMessage(String socialId, String messageId,String emitterId, String receiverId, String content) {
        appendChange(new MessageToSocialAdded(socialId, messageId, emitterId, receiverId, content)).apply();
    }

    public void addPlayer(String socialId, String playerId, String name, String nickName) {
        appendChange(new PlayerToSocialAdded(socialId, playerId, name, nickName)).apply();
    }

    public void addGameToPlayer(String socialId, String playerId, String gameId, String catalogId) {
        appendChange(new GameToPlayerAdded(socialId, playerId, gameId, catalogId)).apply();
    }

    public void addMatchesWon(String socialId, String playerId) {
        appendChange(new MatchesWonToPlayerAdded(socialId, playerId)).apply();
    }

    public void changeState(String socialId, String state) {
        appendChange(new SocialStateChanged(socialId,state)).apply();
    }
}
