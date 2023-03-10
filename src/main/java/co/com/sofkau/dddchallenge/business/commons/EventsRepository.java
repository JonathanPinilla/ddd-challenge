package co.com.sofkau.dddchallenge.business.commons;

import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository {

    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findByAggregateRootId(String aggregateRootId);

}
