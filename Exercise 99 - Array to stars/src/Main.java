public class Main {
    public static void main(String[] args) {


    }

    public static void printArrayAsStars(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
