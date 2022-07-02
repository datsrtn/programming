package concurrency.addersubtractor;

public class Value {
    private int value = 0;
    public synchronized  void add(int val) {
        value+=val;
    }
    public synchronized void subtract(int val) {
        value-=val;
    }

    public int getValue() {
        return value;
    }

}
