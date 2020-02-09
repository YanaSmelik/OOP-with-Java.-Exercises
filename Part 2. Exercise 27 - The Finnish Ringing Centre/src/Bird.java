import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;
    private List<Bird> birdsList;


    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
        this.birdsList = new ArrayList<Bird>();
    }

    @Override
    public String toString() {
        return this.latinName + "(" + this.ringingYear + ")";
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Bird)) {
            return false;
        }

        Bird bird = (Bird) obj;
        return bird.getLatinName().equals(this.getLatinName()) &&
                bird.getRingingYear() == this.getRingingYear();
    }


    @Override
    public int hashCode() {
        return Objects.hash(latinName, ringingYear);
    }


    public String getLatinName() {
        return latinName;
    }

    public int getRingingYear() {
        return ringingYear;
    }


    public void addToBirdsList(Bird thisBird) {
        for (Bird bird : birdsList) {
            if (!thisBird.equals(bird)) {
                birdsList.add(thisBird);
            }
        }
    }


}
