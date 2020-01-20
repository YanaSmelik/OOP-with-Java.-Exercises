public class Person implements Comparable<Person> {

    private int salary;
    private String name;

    public Person(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Person person) {
        return person.getSalary() - this.getSalary();
    }
}
