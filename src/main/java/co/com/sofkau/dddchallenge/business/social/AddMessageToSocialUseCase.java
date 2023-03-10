package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.social.Social;
import co.com.sofkau.dddchallenge.domain.social.commands.AddMessageToSocialCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddMessageToSocialUseCase implements UseCaseCommand<AddMessageToSocialCommand> {

    EventsRepository eventsRepository;

    public AddMessageToSocialUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddMessageToSocialCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getSocialId());
        var social = Social.from(SocialId.of(command.getSocialId()), events);

        if (command.getSocialId() == null) {
            throw new IllegalArgumentException("The social id is required");
        } else if (social.getSocialId().value().equals(command.getSocialId())) {

            if(social.getPlayers().stream().anyMatch(player -> player.playerId().value().equals(command.getEmitterId()))){
                if (social.getPlayers().stream().anyMatch(player -> player.playerId().value().equals(command.getReceiverId()))) {

                    social.addMessage(
                            command.getSocialId(),
                            command.getMessageId(),
                            command.getContent(),
                            command.getEmitterId(),
                            command.getReceiverId()
                    );

                    return social.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
                } else {
                    throw new IllegalArgumentException("The receiver player is not in the social");
                }
            } else {
                throw new IllegalArgumentException("The emitter player is not in the social");
            }

        } else {
            throw new IllegalArgumentException("The social id is not correct");
        }
    }

}
