package farmsimulator;

import java.util.ArrayList;

public class Farm implements Alive {

    private String owner;
    private ArrayList<Cow> cowsHerd;
    private Barn barn;
    /*
    farms have got an owner, a barn and a herd of cows
     */

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        cowsHerd = new ArrayList<Cow>();
        this.barn = barn;
    }


    //makes all he cows of the farm live for an hour
    @Override
    public void liveHour() {
        for (Cow cow : cowsHerd) {
            cow.liveHour();
        }
    }


    //calls Barn's method takeCareOf() so that all cows are milked
    public void manageCows() {
        for (Cow cow : cowsHerd) {
            barn.takeCareOf(cow);
        }
    }


    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        String firstPart = "Farm owner: " + getOwner() + "\n" +
                "Barn bulk tank: " + barn + "\n";
        String secondPart = "";
        if (cowsHerd.size() == 0) {
            secondPart = "No cows.";
        } else {
            secondPart = "Animals:\n";  //lists all cows in the herd
            for (Cow cow : cowsHerd) {
                secondPart += "        " + cow.toString() + "\n";
            }
        }
        return firstPart + secondPart;
    }


    public void addCow(Cow cow) {
        cowsHerd.add(cow);
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        barn.installMilkingRobot(milkingRobot);
    }
}
