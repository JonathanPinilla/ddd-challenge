package co.com.sofkau.dddchallenge.business.gameSession;

import co.com.sofkau.dddchallenge.business.commons.EventsRepository;
import co.com.sofkau.dddchallenge.business.commons.UseCaseCommand;
import co.com.sofkau.dddchallenge.domain.common.GameSessionId;
import co.com.sofkau.dddchallenge.domain.gameSession.GameSession;
import co.com.sofkau.dddchallenge.domain.gameSession.commands.UpdateGameStateCommand;
import co.com.sofkau.dddchallenge.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateGameStateUseCase implements UseCaseCommand<UpdateGameStateCommand> {

    EventsRepository eventsRepository;

    public UpdateGameStateUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(UpdateGameStateCommand command) {

        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getGameSessionId());
        var gameSession = GameSession.from(GameSessionId.of(command.getGameSessionId()), events);

        gameSession.updateGameState(gameSession.getGameSessionId().value(),command.getScore(), command.getTimeLeft(), command.getWinnerId(), command.getSocialId());

        return gameSession.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }

}
