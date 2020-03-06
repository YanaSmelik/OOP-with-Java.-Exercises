package boxes;


import java.util.Collection;

public abstract class Box {

    public Box() {

    }

    //responsible for adding one thing
    //any box that inherits class boxes.Box has to implement the method add()
    public abstract void add(Thing thing);


    public void add(Collection<Thing> things) {
        for (Thing thing : things) {
            add(thing);
        }
    }


    public abstract boolean isInTheBox(Thing thing);
}


