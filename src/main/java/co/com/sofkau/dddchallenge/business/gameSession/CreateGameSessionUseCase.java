package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.CreateGameSessionCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;

import java.util.List;

public class CreateGameSessionUseCase implements UseCaseCommand<CreateGameSessionCommand> {

    EventsRepository eventsRepository;

    public CreateGameSessionUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateGameSessionCommand command) {
        var gameSession = new GameSession(
                GameSessionId.of(command.getGameSessionId())
        );
        return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }

}
