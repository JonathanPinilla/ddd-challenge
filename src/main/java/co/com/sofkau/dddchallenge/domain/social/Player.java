package co.com.sofkau.dddchallenge.domain.social;

import co.com.sofkau.dddchallenge.common.GameId;
import co.com.sofkau.dddchallenge.common.Name;
import co.com.sofkau.dddchallenge.common.PlayerId;
import co.com.sofkau.dddchallenge.domain.social.values.NickName;
import co.com.sofkau.dddchallenge.generic.Entity;

import java.util.List;

public class Player extends Entity<PlayerId> {

    protected PlayerId playerId;
    protected Name name;
    protected NickName nickName;
    protected List<GameId> games;
    protected List<PlayerId> friends;

    public Player(PlayerId playerId, Name name, NickName nickName, List<GameId> games, List<PlayerId> friends) {
        super(playerId);
        this.playerId = playerId;
        this.name = name;
        this.nickName = nickName;
        this.games = games;
        this.friends = friends;
    }

    public PlayerId playerId() {
        return playerId;
    }

    public Name name() {
        return name;
    }

    public NickName nickName() {
        return nickName;
    }

    public List<GameId> games() {
        return games;
    }

    public List<PlayerId> friends() {
        return friends;
    }

}
