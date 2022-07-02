package concurrency.numberprinterexecutor;

public class HelloPrinter implements  Runnable {

    @Override
    public void run() {
        System.out.println("Hello");
    }
}
