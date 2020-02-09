import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {

    private List<Movable> movableObjects;

    public Group() {
        this.movableObjects = new ArrayList<Movable>();
    }

    public String toString() {
        String objectsPositions = "";
        for (Object object : movableObjects) {
            objectsPositions = objectsPositions + object.toString() + "\n";
        }
        return objectsPositions;
    }


    public void addToGroup(Movable movable) {
        movableObjects.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable movable : movableObjects) {
            movable.move(dx, dy);
        }
    }
}
