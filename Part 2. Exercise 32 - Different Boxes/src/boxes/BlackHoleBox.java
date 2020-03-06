package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box {

    private List<Thing> things;

    /*
    any thing can be added to a black-hole box, but none will be found there
     */
    public BlackHoleBox() {
        this.things = new ArrayList<Thing>();
    }


    @Override
    public void add(Thing thing) {
        things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
