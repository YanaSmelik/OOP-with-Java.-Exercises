import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> gradesList = new ArrayList<Integer>();

        System.out.println("Type exam score, -1 completes");
        while (true) {
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade >= 0 && grade <= 60) {
                gradesList.add(grade);
            }
            if (grade == -1) {
                break;
            }
        }

        ArrayList<Integer> sortedGradeList = Grade.sortGrades(gradesList);

        System.out.println("Grade distribution: ");
        Grade.printStart(sortedGradeList);

        System.out.println("Acceptance percentage: " + Grade.percentage(sortedGradeList));

    }
}
