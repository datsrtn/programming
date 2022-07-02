package concurrency.numberprinter;

public class NumberPrinter implements Runnable {

    private int numberToPrint;

    NumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500L);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        System.out.println("Number is " + numberToPrint);
    }
}
