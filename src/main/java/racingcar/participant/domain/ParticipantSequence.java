package racingcar.participant.domain;

import java.util.concurrent.atomic.AtomicLong;

public enum ParticipantSequence {

    INSTANCE;

    private AtomicLong counter = new AtomicLong(1);

    public long getNext() {
        return counter.getAndIncrement();
    }
}

