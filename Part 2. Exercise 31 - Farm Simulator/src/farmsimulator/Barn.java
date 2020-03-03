package farmsimulator;

import java.util.Collection;

public class Barn {

    private BulkTank bulkTank;
    private MilkingRobot milkingRobot;

    /*
    when milking robots are installed, they are connected to a specific barn's bulk tank
    if a barn doesn't have a milking robot, it can't be used to handle the cow
     */


    public Barn(BulkTank bulkTank) {
        this.bulkTank = bulkTank;

    }


    public BulkTank getBulkTank() {
        return bulkTank;
    }


    //installs a milking robot and connects it to the barn bulk tank
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        milkingRobot.setBulkTank(bulkTank);
    }


    //milks the parameter cow with the help of milking robot
    //the method throws an IllegalStateException if the milking robot hasn't been installed
    public void takeCareOf(Cow cow) {
        if (milkingRobot.equals(null)) {
            throw new IllegalStateException("The milking robot is not installed");
        }
        milkingRobot.milk(cow);
    }


    // milks the parameter cows with the help of the milking robot
    // the method throws an IllegalStateException if the milking robot hasn't been installed
    public void takeCareOf(Collection<Cow> cows) {
        if (milkingRobot.equals(null)) {
            throw new IllegalStateException("The milking robot is not installed");
        }
        for (Cow cow : cows) {
            bulkTank.addToTank(cow.milk());
        }
    }


    //returns the state of the bulk tank contained by the barn
    public String toString() {
        return "Barn: " + bulkTank;
    }


}

