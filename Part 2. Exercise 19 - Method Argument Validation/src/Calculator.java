public class Calculator {


    public int multiplication(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("The number is negative");
        }
        int multiplication = 1;
        for (int i = 1; i <= num; i++) {
            multiplication *= i;
        }
        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if (setSize < 0 || subsetSize < 0 || subsetSize > setSize) {
            throw new IllegalArgumentException("The numbers are incorrect: Numbers should not be negative and set " +
                    "must be bigger than subset");
        }
        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);
        return numerator / denominator;
    }
}
