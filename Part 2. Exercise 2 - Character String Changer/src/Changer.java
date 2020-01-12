import java.util.ArrayList;

public class Changer {

    private ArrayList<Change> changeList;

    public Changer() {
        this.changeList = new ArrayList<Change>();
    }

    public void addChange(Change change) {
        this.changeList.add(change);
    }

    public String change(String characterString) {
        for (Change change : this.changeList) {
            change.change(characterString);
        }
        return characterString;
    }
}
