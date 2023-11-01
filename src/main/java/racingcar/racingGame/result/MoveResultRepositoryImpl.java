package racingcar.racingGame.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoveResultRepositoryImpl implements MoveResultRepository {
    private List<Map<Long, Integer>> totalResult = new ArrayList<>();

    @Override
    public void add(Map<Long, Integer> result) {
        totalResult.add(result);
    }

    @Override
    public List<Map<Long, Integer>> getTotalResult() {
        return totalResult;
    }
}
