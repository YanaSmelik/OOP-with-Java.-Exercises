import java.util.ArrayList;

public class Container {

    private int maxWeightLimit;
    private ArrayList<Suitcase> suitcases;
    private int totalWeight;

    public Container(int maxWeightLimit) {
        this.maxWeightLimit = maxWeightLimit;
        this.suitcases = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (totalWeight + suitcase.totalWeight() <= maxWeightLimit) {
            suitcases.add(suitcase);
            totalWeight += suitcase.totalWeight();
        }
    }

    @Override
    public String toString() {
        return suitcases.size() + " suitcases (" + totalWeight + " kg)";
    }

    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }

}
