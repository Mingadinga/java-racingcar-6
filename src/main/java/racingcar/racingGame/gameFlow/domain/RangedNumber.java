package racingcar.racingGame.gameFlow.domain;

public class RangedNumber {
    private final Range range;
    private int value;

    public RangedNumber(Range range, int value) {
        this.range = range;
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    public boolean isBiggerThan(int target) {
        return this.value > target;
    }


    public RangedNumber minus() {
        this.value--;
        return this;
    }
}
