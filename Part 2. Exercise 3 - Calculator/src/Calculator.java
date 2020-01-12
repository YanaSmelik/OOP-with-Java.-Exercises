import java.util.Calendar;
import java.util.Scanner;

public class Calculator {
    private Reader reader;
    private int counter;


    public Calculator() {
        this.reader = new Reader();
        this.counter = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
            System.out.println();
        }
        statistics();
    }

    private void sum() {
        int[] values = inputValues();
        System.out.println("sum of the values " + (values[0] + values[1]));
        this.counter++;
    }

    private void difference() {
        int[] values = inputValues();
        System.out.println("difference of the values " + (values[0] - values[1]));
        this.counter++;
    }

    private void product() {
        int[] values = inputValues();
        System.out.println("product of the values " + (values[0] * values[1]));
        this.counter++;
    }

    private void statistics() {
        System.out.println("Calculations done " + this.counter);
    }

    private int[] inputValues() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        return new int[]{value1, value2};
    }

}
