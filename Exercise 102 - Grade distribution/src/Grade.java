import java.util.ArrayList;

public class Grade {

    public static ArrayList<Integer> sortGrades(ArrayList<Integer> grades) {

        int failed = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) >= 0 && grades.get(i) <= 29) {
                failed++;
            }
            if (grades.get(i) >= 30 && grades.get(i) <= 34) {
                one++;
            }
            if (grades.get(i) >= 35 && grades.get(i) <= 39) {
                two++;
            }
            if (grades.get(i) >= 40 && grades.get(i) <= 44) {
                three++;
            }
            if (grades.get(i) >= 45 && grades.get(i) <= 49) {
                four++;
            }
            if (grades.get(i) >= 50 && grades.get(i) <= 60) {
                five++;
            }
        }

        ArrayList<Integer> sorted = new ArrayList<Integer>();  //index of each element = grade
        sorted.add(failed);                                    // value of each element = number of scores
        sorted.add(one);
        sorted.add(two);
        sorted.add(three);
        sorted.add(four);
        sorted.add(five);
        return sorted;
    }


    public static void printStart(ArrayList<Integer> grades) {
        int count = 1;
        for (int i = grades.size(); i > 0; i--) {      //reverse array 5 -> 0
            System.out.print((grades.size() - count) + ": ");
            for (int j = 0; j < grades.get(i - 1); j++) {   // number of * equals value of the element
                System.out.print("*");
            }
            count++;
            System.out.println();
        }
    }

    //count percentage (100 * accepted / allScore)
    public static double percentage(ArrayList<Integer> gradesList) {
        int allScore = 0;
        for (int i = 0; i < gradesList.size(); i++) {
            allScore += gradesList.get(i);
        }
        double percentage = 100 * (((double) allScore - gradesList.get(0)) / allScore);
        return percentage;
    }
}