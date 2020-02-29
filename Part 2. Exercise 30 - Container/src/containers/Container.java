package containers;

public class Container {

    private double originalCapacity;
    private double productVolume;


    //creates empty container, whose capacity is given as argument. if capacity is (<=0) then useless container
    //is created with capacity 0;
    public Container(double originalCapacity) {
        if (originalCapacity <= 0) {
            this.originalCapacity = 0;
        } else {
            this.originalCapacity = originalCapacity;
        }
    }


    //returns the volume of product in the container
    public double getProductVolume() {
        return productVolume;
    }


    // returns the original capacity of the container, when it was given to the constructor
    public double getOriginalCapacity() {
        return originalCapacity;
    }

    public void setProductVolume(double productVolume) {
        this.productVolume = productVolume;
    }

    //returns actual capacity of the container
    public double getCurrentCapacity() {
        return originalCapacity - productVolume;
    }


    // adds specified amount of things to the container
    public void addToTheContainer(double amount) {
        if (amount < 0) {     //if amount is negative - nothing changes;
            throw new IllegalArgumentException("Can not add a negative amount");
        } else {              //if part of amount fits, the container is filled up and the leftover is thrown away
            if (getCurrentCapacity() < amount) {
                productVolume = originalCapacity;
            } else {
                productVolume += amount;
            }
        }
    }


    //take the specified amount from the container, method returns what we receive
    public double takeFromTheContainer(double amount) {
        if (amount < 0) {                 // if amount is negative nothing happens. 0 is returned.
            return 0;
        } else {
            if (getProductVolume() < amount) {  //if we ask more than is in a container -> returns all contents
                return getProductVolume();
            } else {
                productVolume = getProductVolume() - amount;
                return productVolume;
            }
        }
    }


    public String toString() {
        return "volume = " + productVolume + ", free space " + getCurrentCapacity();

    }
}
