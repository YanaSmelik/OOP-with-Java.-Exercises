import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BoundedCounter seconds = new BoundedCounter(59);
        BoundedCounter minutes = new BoundedCounter(59);
        BoundedCounter hours = new BoundedCounter(23);

        seconds.setValue(50);
        minutes.setValue(59);
        hours.setValue(23);

        while (true) {
            System.out.println(hours + ":" + minutes + ":" + seconds);
            Thread.sleep(1000);
            if (seconds.getValue() == 59) {
                if (minutes.getValue() == 59) {
                    hours.next();
                }
                minutes.next();
            }
            seconds.next();
        }
    }
}


