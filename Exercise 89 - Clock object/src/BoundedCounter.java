public class BoundedCounter {
    private int value;
    private int upperLimit;

    public BoundedCounter(int value, int upperLimit) {
        this.value = value;
        this.upperLimit = upperLimit;
    }

    public void next() {
        if (value < upperLimit) {
            value++;
        } else {
            value = 0;
        }

    }

    public String toString() {
        if (value < 10) {
            return "0" + value;
        }
        return "" + value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value > 0 && value <= upperLimit) {
            this.value = value;
        }
    }
}
