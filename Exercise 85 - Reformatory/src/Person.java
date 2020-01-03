public class Person {

    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void becomeOlder() {
        this.age++;
    }

    public boolean adult() {
        if (this.age < 18) {
            return false;
        }
        return true;
    }

    public double weightIndex() {
        double heightInMeters = this.height / 100.0;
        return this.weight / (heightInMeters * heightInMeters);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + " I am " + this.age + " years old, " +
                "my weight index is " + this.weightIndex();
    }
}

