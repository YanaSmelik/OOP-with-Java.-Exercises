package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> measurements;

    public AverageSensor() {
        sensors = new ArrayList<Sensor>();
        measurements = new ArrayList<Integer>();
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        if (isOn()) {
            for (Sensor sensor : sensors) {
                sensor.on();
            }
        }
    }

    @Override
    public void off() {
        if (isOn()) {
            for (Sensor sensor : sensors) {
                sensor.off();
            }
        }
    }

    @Override
    public int measure() {
        int sum = 0;
        int count = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.measure();
            count++;
        }
        int average = sum / count;
        measurements.add(average);
        return average;
    }

    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }

    public List<Integer> reading() {
        ArrayList<Integer> measuresRecorded = new ArrayList<Integer>();
        for (Integer measure : measurements) {
            measuresRecorded.add(measure);
        }
        return measuresRecorded;
    }
}

