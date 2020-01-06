import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
    }


    public static int[] copy(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static int[] reverseCopy(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[length - i - 1] = array[i];
        }
        return newArray;
    }
}
