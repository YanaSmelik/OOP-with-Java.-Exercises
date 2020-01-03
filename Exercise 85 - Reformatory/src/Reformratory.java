public class Reformratory {

    private int counter = 0;

    public int weight(Person person) {
        counter++;
        return person.getWeight();
    }

    public void feed(Person person) {
        person.setWeight(weight(person) + 1);
    }

    public int totalWeightsMeasured() {
        return counter;
    }
}
