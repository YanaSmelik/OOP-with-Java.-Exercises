package clicker.applicationlogic;

public class PersonalCalculator implements Calculator {

    private int value;

    public PersonalCalculator() {
        value = 0;
    }

    public int giveValue() {
        return value;
    }

    public void increase() {
        value++;
    }
}
