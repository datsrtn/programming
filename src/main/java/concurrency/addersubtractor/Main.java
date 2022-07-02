package concurrency.addersubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Value value = new Value();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Adder(value));
        executorService.execute(new Subtractor(value));
        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.MINUTES);

        System.out.println(value.getValue());
    }
}
