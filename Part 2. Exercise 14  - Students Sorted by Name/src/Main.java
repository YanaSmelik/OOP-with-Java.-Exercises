import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mikael"));
        students.add(new Student("Joel"));
        students.add(new Student("Thom"));
        students.add(new Student("Markus"));
        students.add(new Student("Brian"));

        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
    }
}
