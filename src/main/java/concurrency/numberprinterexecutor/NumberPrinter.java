package concurrency.numberprinterexecutor;

public class NumberPrinter implements Runnable {

    private int numberToPrint;

    NumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        // below code is just to slow down the printing
        /*
           try {
                Thread.sleep(500L);
            } catch (Exception e) {
                System.out.println("Exception occurred");
            }
        } else {
            try {
                Thread.sleep(500L);
            } catch (Exception e) {
                System.out.println("Exception occurred");
            }
        */
        System.out.println("Number is " + numberToPrint + " " + Thread.currentThread().getName());
    }
}
