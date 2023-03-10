package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.common.SocialId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.CreateGameSessionCommand;
import co.com.sofkau.dddchallenge.domain.gameSession.values.GameState;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateGameSessionUseCase implements UseCaseCommand<CreateGameSessionCommand> {

    EventsRepository eventsRepository;

    public CreateGameSessionUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateGameSessionCommand command) {
        var gameSession = new GameSession(
                GameSessionId.of(command.getGameSessionId()),
                new GameState(
                        command.getScore(),
                        command.getTimeLeft(),
                        command.getWinnerId()
                ),
                SocialId.of(command.getSocialId())
        );
        return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }

}
