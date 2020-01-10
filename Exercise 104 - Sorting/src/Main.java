import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);


    }

    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (smallest > array[i]) {
                smallest = array[i];
            }
        }
        return smallest;
    }


    public static int indexOfTheSmallest(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (smallest(array) == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfTheSmallestStraightFrom(int[] array, int index) {
        int smallest = array[index];
        int indexOfSmallest = 0;
        for (int i = index; i < array.length; i++) {
            if (smallest >= array[i]) {
                smallest = array[i];
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }

    public static void sort(int[] array) {
        int i = 0;
        while (i < array.length) {
            System.out.println(Arrays.toString(array));
            swap(array, indexOfTheSmallestStraightFrom(array, i), i);
            i++;
        }

    }
}
