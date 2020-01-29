package application;

public class ConstantSensor implements Sensor {

    private int number;
    private boolean isOnline;

    public ConstantSensor(int number) {
        this.number = number;
        this.isOnline = true;

    }


    @Override
    public boolean isOn() {
        return isOnline;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() {
        return number;
    }
}
