package co.com.sofkau.dddchallenge.business.social;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.social.Social;
import co.com.sofkau.dddchallenge.domain.social.commands.CreateSocialCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public class CreateSocialUseCase implements UseCaseCommand<CreateSocialCommand> {

    EventsRepository eventsRepository;

    public CreateSocialUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateSocialCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getSocialId());

        var social = new Social(
                SocialId.of(command.getSocialId())
        );

        return social.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }

}
