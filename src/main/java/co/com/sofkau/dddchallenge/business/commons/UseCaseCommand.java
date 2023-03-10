package co.com.sofkau.dddchallenge.business.commons;

import co.com.sofkau.dddchallenge.generic.Command;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public interface UseCaseCommand<T extends Command>{

    List<DomainEvent> apply(T command);

}
