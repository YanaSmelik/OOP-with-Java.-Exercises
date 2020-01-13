import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Thing> things;
    private int maxWeightLimit;

    public Suitcase(int maxWeightLimit) {
        this.maxWeightLimit = maxWeightLimit;
        this.things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if (totalWeight() + thing.getWeight() <= maxWeightLimit) {
            this.things.add(thing);
        }

    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Thing thing : things) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        if (things.size() == 0) {
            return "empty (" + totalWeight() + " kg)";
        } else if (things.size() == 1) {
            return things.size() + " thing (" + totalWeight() + " kg)";
        } else {
            return things.size() + " things (" + totalWeight() + " kg)";
        }

    }


    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public Thing heaviestThing() {
        int heaviestWeight = 0;
        Thing heaviestThing = null;
        for (Thing thing : things) {
            if (thing.getWeight() > heaviestWeight) {
                heaviestThing = thing;
                heaviestWeight = heaviestThing.getWeight();
            }
        }
        return heaviestThing;
    }


}
