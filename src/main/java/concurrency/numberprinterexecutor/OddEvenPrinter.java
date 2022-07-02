package concurrency.numberprinterexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrinter {
    public static void main(String[] args) {
        ExecutorService evenExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService oddExecutorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                evenExecutorService.execute(new NumberPrinter(i));
            } else {
                oddExecutorService.execute(new NumberPrinter(i));
            }
        }
    }
}

