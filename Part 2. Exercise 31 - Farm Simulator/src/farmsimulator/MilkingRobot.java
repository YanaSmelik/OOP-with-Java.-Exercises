package farmsimulator;

public class MilkingRobot {

    private BulkTank bulkTank;

    /*
    milking robots handle the milking.
    Milking robot has to be connected to the bulk tank.
     */

    public MilkingRobot() {

    }


    // returns the connected bulk tank, or a null reference, if the tank hasn't been installed
    public BulkTank getBulkTank() {
        return bulkTank;
    }


    //installs the parameter bulk tank to the milking robot.
    public void setBulkTank(BulkTank tank) {
        bulkTank = tank;
    }


    //milks the cow and fills the connected bulk tank;
    //the method returns an IllegalException if no tank has been fixed
    public void milk(Milkable milkable) {
        if (bulkTank.equals(null)) {
            throw new IllegalStateException("The MilkRobot has not been installed");
        }
        bulkTank.addToTank(milkable.milk());
    }
}
