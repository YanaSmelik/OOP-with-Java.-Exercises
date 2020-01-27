public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name.equals(null) || name.equals("") || name.length() > 40) {
            throw new IllegalArgumentException("The name is empty or too big");
        }
        this.name = name;

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("The age is either too small or to big");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age + " years old";
    }
}
