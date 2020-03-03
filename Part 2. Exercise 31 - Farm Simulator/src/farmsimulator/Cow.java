package farmsimulator;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Cow implements Milkable, Alive {

    private String name;
    private double udderCapacity;
    private double milk;    //for milk() method
    private double producedMilk;


    /*
    Udder capacity is a random value between 15 and 40;
     */


    //creates a new cow with a random name
    public Cow() {
        name = randomNameFromArray();
        udderCapacity = ThreadLocalRandom.current().nextDouble(15, 41);
    }

    private String randomNameFromArray() {
        String[] names = new String[]{"Mary", "Florence", "Diana", "Betty", "Sarah", "Eleanor", "Audrey",
                "Emma", "Anna", "Lillie", "Margaret", "Ethel", "Lucy", "Norma", "Alice", "Johanna",
                "Carie", "Nellie", "Julia", "Minnie", "Barbara", "Deborah", "Pauline", "Ida", "Edna", "Laura",
                "Janet", "Eva", "Linda", "Carolyn", "Glenda"};
        return names[ThreadLocalRandom.current().nextInt(0, names.length)];
    }


    public Cow(String name) {
        this.name = name;
        udderCapacity = ThreadLocalRandom.current().nextInt(15, 41);
    }


    public String getName() {
        return name;
    }


    public double getUdderCapacity() {
        return udderCapacity;
    }


    //returns the amount of milk available in the cow's udder
    public double getAmountOfMilkInCowsUdder() {
        return producedMilk;
    }

    @Override
    public String toString() {
        return name + " " + decimalFormat.format(getAmountOfMilkInCowsUdder()) + "/" + decimalFormat.format(udderCapacity);
    }

    DecimalFormat decimalFormat = new DecimalFormat("#.##");


    // on average cow produces 0.7 - 2 liters every hour
    @Override
    public double milk() {
        double availableMilk = producedMilk;
        producedMilk = 0;
        return availableMilk;

    }


    @Override
    public void liveHour() {
        double milk = ThreadLocalRandom.current().nextDouble(0.7, 3);
        producedMilk += milk;
    }


}
