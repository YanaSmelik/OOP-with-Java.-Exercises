public class Clock {
    private BoundedCounter hours;
    private BoundedCounter minutes;
    private BoundedCounter seconds;

    public Clock(int hoursAtBeginning, int minutesAtBeginning, int secondsAtBeginning) {
        this.hours = new BoundedCounter(hoursAtBeginning, 23);
        this.minutes = new BoundedCounter(minutesAtBeginning, 59);
        this.seconds = new BoundedCounter(secondsAtBeginning, 59);
    }

    public void tick() {
        if (seconds.getValue() == 59) {
            if (minutes.getValue() == 59) {
                hours.next();
            }
            minutes.next();
        }
        seconds.next();
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
