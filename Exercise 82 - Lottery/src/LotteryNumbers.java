import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryNumbers {

    private ArrayList<Integer> numbers;

    public LotteryNumbers() {
        this.numbers = new ArrayList<Integer>();
        this.drawNumbers();

    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void drawNumbers() {
        int i = 0;
        while (i < 7) {
            int number = ThreadLocalRandom.current().nextInt(1, 40);
            if (!containsNumbers(number)) {
                numbers.add(number);
                i++;
            }
        }
    }

    public boolean containsNumbers(int number) {
        if (numbers.contains(number)) {
            return true;
        } else {
            return false;
        }
    }
}
