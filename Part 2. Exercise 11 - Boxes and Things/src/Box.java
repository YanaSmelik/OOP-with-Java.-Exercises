import java.util.ArrayList;

public class Box implements ToBeStored {

    private ArrayList<ToBeStored> storedThings;
    private double maxWeight;

    public Box(double maxWeight) {
        this.storedThings = new ArrayList<ToBeStored>();
        this.maxWeight = maxWeight;
    }

    public void addToBox(ToBeStored thing) {
        if ((thing.weight() + weight()) <= maxWeight) {
            storedThings.add(thing);
        }
    }

    @Override
    public String toString() {
        return "Box: " + storedThings.size() + " things, total weight " + weight() + " kg";
    }

    public double weight() {
        double weight = 0;
        for (ToBeStored thing : storedThings) {
            weight += thing.weight();
        }
        return weight;
    }
}
