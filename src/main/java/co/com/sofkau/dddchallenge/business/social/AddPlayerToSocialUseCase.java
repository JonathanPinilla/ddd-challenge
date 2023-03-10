package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.social.Social;
import co.com.sofkau.dddchallenge.domain.social.commands.AddPlayerToSocialCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddPlayerToSocialUseCase implements UseCaseCommand<AddPlayerToSocialCommand> {

    EventsRepository eventsRepository;

    public AddPlayerToSocialUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddPlayerToSocialCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getSocialId());
        var social = Social.from(SocialId.of(command.getSocialId()), events);

        if (command.getSocialId() == null) {
            throw new IllegalArgumentException("The social id is required");
        } else if (social.getSocialId().value().equals(command.getSocialId())) {

            if (social.getPlayers().stream().anyMatch(player -> player.playerId().value().equals(command.getPlayerId()))) {
                throw new IllegalArgumentException("The player is already in the social");
            } else {
                social.addPlayer(
                        command.getSocialId(),
                        command.getPlayerId(),
                        command.getName(),
                        command.getNickName()
                );

                return social.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
            }

        } else {
            throw new IllegalArgumentException("The social id is not correct");
        }
    }

}
