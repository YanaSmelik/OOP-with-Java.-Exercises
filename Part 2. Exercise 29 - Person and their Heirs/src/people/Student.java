package people;

public class Student extends Person {

    private int credits;

    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   credits " + credits;
    }

    public void study() {
        credits += 1;
    }

    public int credits() {
        return credits;
    }


}
