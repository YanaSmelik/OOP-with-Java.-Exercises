import java.util.Scanner;

public class GuessingGame {


    private Scanner reader;

    public GuessingGame() {
        this.reader = new Scanner(System.in);
    }

    public void play(int lowerLimit, int upperLimit) {
        instructions(lowerLimit, upperLimit);
        while (true) {
            if (isGreaterThan(average(lowerLimit, upperLimit))) {
                lowerLimit = average(lowerLimit, upperLimit);
                if (average(lowerLimit, upperLimit) == lowerLimit) {
                    System.out.println("The number you're thinking of is " + upperLimit + ".");
                    break;
                }
            } else {
                upperLimit = average(lowerLimit, upperLimit);
                if (upperLimit == average(lowerLimit, upperLimit)) {
                    System.out.println("The number you're thinking of is " + upperLimit + ".");
                    break;
                }
            }
        }
    }

    public boolean isGreaterThan(int value) {
        System.out.println("Is your number greater than " + value + "? (y/n)");
        if (reader.nextLine().equals("y")) {
            return true;
        }
        return false;
    }

    public int average(int firstNumber, int secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }

    public void instructions(int lowerLimit, int upperLimit) {
        int maxQuestions = howManyTimesHalvable(upperLimit - lowerLimit);

        System.out.println("Think of number between " + lowerLimit + "..." + upperLimit + ".");
        System.out.println("I promise you that I can guess the number you are thinking of with " + maxQuestions + " questions.");
        System.out.println();
        System.out.println("Next I'll present you with a series of questions. Answer them honestly.");
        System.out.println();
    }

    public static int howManyTimesHalvable(int number) {
        return (int) (Math.log(number) / Math.log(2)) + 1;
    }
}
