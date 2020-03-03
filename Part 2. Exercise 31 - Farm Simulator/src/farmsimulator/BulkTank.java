package farmsimulator;

public class BulkTank {

    private double capacity;
    private double takenSpace;


    /*
    Bulk tanks are produced both with a standard capacity of 2000 liters,
    and with customer specific capacity.
     */

    public BulkTank() {
        this.capacity = 2000;
    }


    public BulkTank(double capacity) {
        this.capacity = capacity;
    }


    public double getCapacity() {
        return capacity;
    }


    public double getTakenSpace() {
        return takenSpace;
    }


    public double getFreeSpace() {
        return capacity - takenSpace;
    }


    //adds to the tank only as much milk as it fits;
    //the additional milk will not be added
    public void addToTank(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be a negative number");
        } else {
            if (amount < getFreeSpace()) {
                takenSpace += amount;
            } else {
                takenSpace = capacity;
            }
        }
    }


    // takes the required amount from the tank
    //or as much as there is left
    public double takeFromTank(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be a negative number");
        } else {
            if (takenSpace - amount > 0) {
                return takenSpace -= amount;
            } else {
                return 0;
            }
        }
    }


    //describes the tank situation by rounding down the liters.
    @Override
    public String toString() {
        return Math.ceil(takenSpace) + "/" + capacity;
    }
}
