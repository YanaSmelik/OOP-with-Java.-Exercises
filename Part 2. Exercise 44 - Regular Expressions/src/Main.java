import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean isAWeekDay(String string) {
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            System.out.println("The form is fine");
            return true;
        }
        System.out.println("The form is wrong");
        return false;
    }


    public static boolean allVowels(String string) {
        if (string.matches("[aeiouy]*")) {
            System.out.println("The form is fine");
            return true;
        }
        System.out.println("The form is wrong");
        return false;
    }


    public static boolean clockTime(String string) {
        if (string.matches("(0[0-9]|(1[0-9]|2[0-3])):(0[0-9]|)([1-5][0-9]):(0[0-9]|([1-5][0-9]))")) {
            System.out.println("The form is fine");
            return true;
        }
        System.out.println("The form is wrong");
        return false;
    }
}
