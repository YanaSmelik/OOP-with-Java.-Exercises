import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RingingCenter {

    private HashMap<Bird, List<String>> birdDestinationObservation;
    private HashMap<Bird, Integer> timesBeenObserved;
    private int timesObserved;


    public RingingCenter() {
        this.birdDestinationObservation = new HashMap<Bird, List<String>>();
        this.timesBeenObserved = new HashMap<Bird, Integer>();

    }


    public void observe(Bird bird, String place) {

        if (!birdDestinationObservation.containsKey(bird)) {
            birdDestinationObservation.put(bird, new ArrayList<String>());
        }
        birdDestinationObservation.get(bird).add(place);
        if (timesBeenObserved.get(bird) == null) {
            timesBeenObserved.put(bird, 1);
        } else {
            timesBeenObserved.put(bird, timesBeenObserved.get(bird) + 1);
        }

    }


    public void observations(Bird bird) {
        boolean isInList = false;
        for (Bird aBird : birdDestinationObservation.keySet()) {
            if (bird.equals(aBird)) {
                System.out.println(bird.getLatinName() + " (" + bird.getRingingYear() + ") observations: " +
                        timesBeenObserved.get(bird));
                for (String aName : birdDestinationObservation.get(bird)) {
                    System.out.println(aName);
                    isInList = true;
                }

            }
        }
        if (isInList == false) {
            System.out.println(bird.getLatinName() + " (" + bird.getRingingYear() + ") observations: 0");
        }
    }

}
