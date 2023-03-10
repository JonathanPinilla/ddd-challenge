package co.com.sofkau.dddchallenge.domain.social;

import co.com.sofkau.dddchallenge.domain.common.GameId;
import co.com.sofkau.dddchallenge.domain.common.Name;
import co.com.sofkau.dddchallenge.domain.common.PlayerId;
import co.com.sofkau.dddchallenge.domain.social.values.MatchesWon;
import co.com.sofkau.dddchallenge.domain.social.values.NickName;
import co.com.sofkau.dddchallenge.generic.Entity;

import java.util.List;

public class Player extends Entity<PlayerId> {

    protected PlayerId playerId;
    protected Name name;
    protected NickName nickName;
    protected List<GameId> games;
    protected List<PlayerId> friends;
    protected MatchesWon matchesWon;

    public Player(PlayerId playerId, Name name, NickName nickName, List<GameId> games, List<PlayerId> friends, MatchesWon matchesWon) {
        super(playerId);
        this.playerId = playerId;
        this.name = name;
        this.nickName = nickName;
        this.games = games;
        this.friends = friends;
        this.matchesWon = matchesWon;
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

    public MatchesWon matchesWon() {
        return matchesWon;
    }

    public void addMatchesWonPlayer() {
        this.matchesWon = new MatchesWon(this.matchesWon.value() + 1);
    }

    public void addGameToPlayer(String gameId) {
        this.games.add(new GameId(gameId));
    }
}
