public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().toLowerCase().compareTo(student.getName().toLowerCase());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
