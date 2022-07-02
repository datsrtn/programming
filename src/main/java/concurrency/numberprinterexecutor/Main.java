package concurrency.numberprinterexecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new NumberPrinter(i));
            try {
                Thread.sleep(50L);
            } catch (Exception e ){
                System.out.println("exception caught");
            }

            if(i == 40 ) {
                System.out.println("debug purpose  "+ Thread.currentThread().getName());
            }
        }
        executorService.shutdown();
    }
}
