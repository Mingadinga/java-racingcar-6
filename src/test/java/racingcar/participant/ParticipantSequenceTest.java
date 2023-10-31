package racingcar.participant;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class ParticipantSequenceTest {

    @Test
    public void testConcurrentSequenceGeneration() throws InterruptedException {
        int numThreads = 10;
        int numIterations = 1000;
        Thread[] threads = new Thread[numThreads];
        TestRunnable[] runnables = new TestRunnable[numThreads];

        for (int i = 0; i < numThreads; i++) {
            runnables[i] = new TestRunnable(numIterations);
            threads[i] = new Thread(runnables[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (TestRunnable runnable : runnables) {
            assert runnable.isCorrect() : "Test failed, concurrent access issue detected.";
        }
    }

    private static class TestRunnable implements Runnable {
        private final int numIterations;
        private final Set<Long> generatedNumbers = new HashSet<>();
        private boolean correct = true;

        public TestRunnable(int numIterations) {
            this.numIterations = numIterations;
        }

        @Override
        public void run() {
            for (int i = 0; i < numIterations; i++) {
                long number = ParticipantSequence.INSTANCE.getNext();
                if (!generatedNumbers.add(number)) {
                    correct = false;
                    return;
                }
            }
        }

        public boolean isCorrect() {
            return correct;
        }
    }
}
