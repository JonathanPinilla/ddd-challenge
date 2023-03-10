package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseEvent;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.events.GameStateUpdated;
import co.com.sofkau.dddchallenge.domain.social.Social;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddMatchesWonToPlayerEventUseCase implements UseCaseEvent<GameStateUpdated> {

    EventsRepository eventsRepository;

    public AddMatchesWonToPlayerEventUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(GameStateUpdated event) {

        List<DomainEvent> events = eventsRepository.findByAggregateRootId(event.getSocialId());
        var social = Social.from(SocialId.of(event.getSocialId()), events);

        if (social.getPlayers().stream().noneMatch(player -> player.playerId().value().equals(event.getWinnerId()))) {
            throw new IllegalArgumentException("The player is not in the social");
        }

        social.addMatchesWon(event.getSocialId(), event.getWinnerId());

        return social.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
