package boxes;

import java.util.ArrayList;

public class MaxWeight extends Box {


    private int maxWeight;
    private ArrayList<Thing> thingsList;
    private int currentWeight;


    //determines box max weight
    public MaxWeight(int maxWeight) {
        super();
        this.maxWeight = maxWeight;
        thingsList = new ArrayList<Thing>();
    }


    @Override
    public void add(Thing thing) {
        int currentWeightWithTheThing = currentWeight += thing.getWeight();
        if (currentWeightWithTheThing <= maxWeight) {
            thingsList.add(thing);
            currentWeight = currentWeightWithTheThing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing thingy : thingsList) {
            if (thing.equals(thingy)) {
                return true;
            }
        }
        return false;
    }
}
