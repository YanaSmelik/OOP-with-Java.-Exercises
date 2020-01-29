package application;

import java.util.concurrent.ThreadLocalRandom;

public class Thermometer implements Sensor {

    private boolean isOnline;


    public Thermometer() {
        isOnline = true;

    }

    @Override
    public boolean isOn() {
        return isOnline;
    }

    @Override
    public int measure() {
        if (isOn()) {
            int num = ThreadLocalRandom.current().nextInt(-30, 31);
            return num;
        } else {
            throw new IllegalStateException("The thermometer is off");
        }
    }

    @Override
    public void on() {
        isOnline = true;
    }

    @Override
    public void off() {
        isOnline = false;
    }


}
