package co.com.sofkau.dddchallenge.business.commons;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public interface UseCaseEvent<T extends DomainEvent>{

    List<DomainEvent> apply(T event);

}
