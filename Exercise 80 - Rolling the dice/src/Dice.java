import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int numberOfSides;

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int roll() {
        return ThreadLocalRandom.current().nextInt(1, numberOfSides + 1);
    }
}
