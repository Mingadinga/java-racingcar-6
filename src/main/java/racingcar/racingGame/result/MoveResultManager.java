package racingcar.racingGame.result;

import java.util.List;
import java.util.Map;

public interface MoveResultManager {
    void add(Map<Long, Integer> result);

    List<Map<Long, Integer>> getTotalResult();
}
