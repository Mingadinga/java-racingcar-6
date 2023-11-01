package racingcar.racingGame.result;

import java.util.List;
import java.util.Map;

public class MoveResultManagerImpl implements MoveResultManager {
    private final MoveResultRepository repository;

    public MoveResultManagerImpl(MoveResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Map<Long, Integer> result) {
        repository.add(result);
    }

    @Override
    public List<Map<Long, Integer>> getTotalResult() {
        return repository.getTotalResult();
    }
}
