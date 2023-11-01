package racingcar.racingGame.gameFlow.domain;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public RangedNumber of(int value) {
        if (isInRange(value))
            return new RangedNumber(this, value);
        throw new IllegalStateException(String.format("요청한 숫자가 범위 내에 있지 않습니다. 요청한 숫자 : %d, 범위 : %d ~%d", value, min, max));
    }

    private boolean isInRange(int value) {
        return value >= min && value <= max;
    }
}
