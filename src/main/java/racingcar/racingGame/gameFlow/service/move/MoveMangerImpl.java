package racingcar.racingGame.gameFlow.service.move;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MoveMangerImpl implements MoveManager {

    Set<Long> moveParticipantSet = Set.of(1L, 2L, 3L); // todo : participant controller에서 조회
    private final MoveAmountSelector moveAmountSelector;

    public MoveMangerImpl(MoveAmountSelector moveAmountSelector) {
        this.moveAmountSelector = moveAmountSelector;
    }

    @Override
    public Map<Long, Integer> move() {
        Map<Long, Integer> result = new HashMap<>();
        moveParticipantSet.forEach(id -> result.put(id, moveAmountSelector.select(id)));
        return result;
    }

    public void setMoveParticipantSet(Set<Long> moveParticipantSet) {
        this.moveParticipantSet = moveParticipantSet;
    }
}
