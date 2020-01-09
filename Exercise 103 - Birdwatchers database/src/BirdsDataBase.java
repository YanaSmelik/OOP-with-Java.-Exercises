import java.util.ArrayList;

public class BirdsDataBase {

    private ArrayList<Bird> birdsDataBase;

    public BirdsDataBase() {
        this.birdsDataBase = new ArrayList<Bird>();
    }


    public void add(Bird bird) {
        birdsDataBase.add(bird);
    }

    public Bird containsBird(String name) {
        for (Bird bird : birdsDataBase) {
            if (bird.getName().contains(name)) {
                return bird;
            }
        }
        return null;
    }

    public void observation(Bird bird) {
        bird.setCounter(bird.getCounter() + 1);
    }


    public void statistics() {
        for (Bird bird : birdsDataBase) {
            System.out.println(bird);
        }
    }

    public void show(String name) {
        for (Bird bird : birdsDataBase) {
            if (bird.getName().equals(name)) {
                System.out.println(bird);
            }
        }
    }


}
