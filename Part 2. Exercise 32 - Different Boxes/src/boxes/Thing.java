package boxes;

public class Thing {

    private double weight;
    private String name;

    //thing's weight is never negative (weight 0 is accepted)
    //if weight is negative, the constructor has to throw IllegalArgumentException
    public Thing(String name, double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("The weight cannot be negative");
        }
        this.weight = weight;
        this.name = name;
    }


    public Thing(String name) {
        this.name = name;
    }


    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Thing)) {
            return false;
        }

        Thing thing = (Thing) obj;

        return thing.getName() == this.getName();
    }


    //

    @Override
    public int hashCode() {
        int result = 17;
        result = (int) (31 * result + weight);
        return result;
    }


}
