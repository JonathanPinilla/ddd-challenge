package co.com.sofkau.dddchallenge.domain.social;

import co.com.sofkau.dddchallenge.domain.common.MessageId;
import co.com.sofkau.dddchallenge.domain.common.Name;
import co.com.sofkau.dddchallenge.domain.common.PlayerId;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.social.events.*;
import co.com.sofkau.dddchallenge.domain.social.values.Content;
import co.com.sofkau.dddchallenge.domain.social.values.MatchesWon;
import co.com.sofkau.dddchallenge.domain.social.values.NickName;
import co.com.sofkau.dddchallenge.domain.social.values.State;
import co.com.sofkau.dddchallenge.generic.EventChange;

import java.util.ArrayList;

public class SocialEventChange extends EventChange {

    public SocialEventChange(Social social) {
        apply((SocialCreated event) -> {
            social.socialId = SocialId.of(event.getSocialId());
            social.players = new ArrayList<>();
            social.messages = new ArrayList<>();
        });
        apply((PlayerToSocialAdded event) -> {
            social.players.add(new Player(
                    PlayerId.of(event.getPlayerId()),
                    new Name(event.getName()),
                    new NickName(event.getNickName()),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new MatchesWon(0)
            ));
        });
        apply((MessageToSocialAdded event) -> {
            social.messages.add(new Message(
                    MessageId.of(event.getMessageId()),
                    new Content(event.getContent()),
                    PlayerId.of(event.getEmitterId()),
                    PlayerId.of(event.getReceiverId())
            ));
        });
        apply((SocialStateChanged event) -> social.state = new State(event.getState()));
        apply((MatchesWonToPlayerAdded event) -> social.players.stream()
                .filter(player -> player.playerId().value().equals(event.getPlayerId()))
                .findFirst()
                .ifPresent(Player::addMatchesWonPlayer));
        apply((GameToPlayerAdded event) -> social.players.stream()
                .filter(player -> player.playerId().value().equals(event.getPlayerId()))
                .findFirst()
                .ifPresent(player -> player.addGameToPlayer(event.getGameId())));
    }

}
