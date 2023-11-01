package racingcar.racingGame.move;

public class MoveAmountSelectorByRandom implements MoveAmountSelector {

    private final RandomPicker randomPicker;

    public MoveAmountSelectorByRandom(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
    }

    @Override
    public int select(Long id) {
        if (randomPicker.pick() >= 4) return 1;
        else return 0;
    }
}
