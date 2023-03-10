package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.social.Social;
import co.com.sofkau.dddchallenge.domain.social.commands.ChangeSocialStateCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangeSocialStateUseCase implements UseCaseCommand<ChangeSocialStateCommand> {

    EventsRepository eventsRepository;

    public ChangeSocialStateUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeSocialStateCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getSocialId());
        Social social = Social.from(SocialId.of(command.getSocialId()), events);

        if (social.getState().value().equals(command.getState())){
            throw new IllegalArgumentException("You can't change the state to the same state");
        }
        social.changeState(command.getSocialId(), command.getState());

        return social.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }

}
