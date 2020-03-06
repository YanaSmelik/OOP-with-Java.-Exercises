package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box {

    private List<Thing> things;


    public OneThingBox() {
        this.things = new ArrayList<Thing>();
    }


    //only one thing can fit here
    //If box already contains one thing, this should not be changed.
    //The weight of the added thing is not important
    @Override
    public void add(Thing thing) {
        if (things.size() == 0) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing thingy : things) {
            if (thingy.equals(thing)) {
                return true;
            }
        }
        return false;
    }
}
