package moving.domain;

import java.util.ArrayList;

public class Box implements Thing {

    private ArrayList<Thing> things;
    private int maximumCapacity;
    private int volume;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
        this.volume = volume;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    public boolean addThings(Thing thing) {
        if (thing.getVolume() + getVolume() <= maximumCapacity) {
            things.add(thing);
            volume += thing.getVolume();
            return true;
        }
        return false;
    }
}
