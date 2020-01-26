package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer implements Thing {

    private int boxesVolume;

    public Packer(int boxesVolume) {

        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        Box box = new Box(boxesVolume);
        for (Thing thing : things) {
            if (box.addThings(thing)) {

            } else {
                boxes.add(box);
                box = new Box(boxesVolume);
                box.addThings(thing);
            }
        }
        boxes.add(box);
        return boxes;
    }

    @Override
    public int getVolume() {

        return boxesVolume;
    }
}
