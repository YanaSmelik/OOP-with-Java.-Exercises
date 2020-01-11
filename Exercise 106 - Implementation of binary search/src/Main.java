import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {};
        Scanner reader = new Scanner(System.in);

        System.out.print("Values of the array: " + Arrays.toString(array));
        System.out.println();

        System.out.print("Enter searched number: ");
        int searchValue = Integer.parseInt(reader.nextLine());

        boolean result = BinarySearch.search(array, searchValue);
        if (result) {
            System.out.println("Value " + searchValue + " is in the array");
        } else {
            System.out.println("Value " + searchValue + " is not in the array");
        }

    }
}
