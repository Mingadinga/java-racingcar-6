package racingcar.racingGame.gameFlow.service.move;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPickerByRandoms implements RandomPicker {
    @Override
    public int pick() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
