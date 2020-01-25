import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Jumper implements Comparable<Jumper> {

    private String name;
    private int jumpLenght;
    private int points;
    private int judgesPoints;
    private ArrayList<Integer> jumps;


    public Jumper(String name) {
        this.name = name;
        this.jumpLenght = 0;
        this.points = 0;
        this.judgesPoints = 0;
        this.jumps = new ArrayList<Integer>();
    }


    public String getName() {
        return name;
    }


    public int getPoints() {
        return points;
    }


    public int getJumpLenght() {
        return jumpLenght;
    }


    @Override
    public String toString() {
        return this.getName() + " (" + this.points + " points)";
    }


    @Override
    public int compareTo(Jumper jumper) {
        return this.getPoints() - jumper.getPoints();
    }


    public int makeJump() {
        jumpLenght = ThreadLocalRandom.current().nextInt(60, 121);
        return jumpLenght;
    }


    public ArrayList<Integer> judgesPointsList() {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            int point = ThreadLocalRandom.current().nextInt(10, 21);
            newList.add(point);
        }
        return newList;
    }


    public int totalJudgesPoints(ArrayList<Integer> points) {
        Collections.sort(points);
        points.remove(0); //Remove the smallest and the biggest points from the list
        points.remove(3);
        return sumPoints(points);
    }


    private int sumPoints(ArrayList<Integer> points) {
        int sum = 0;
        for (Integer point : points) {
            sum += point;
        }
        this.judgesPoints = sum; //add sum to judgesPoints variable to store it.
        return sum;
    }


    public void addJumpLenght() {
        jumps.add(getJumpLenght());
    }


    public void totalPointsForJump() {
        points = getPoints() + (jumpLenght + judgesPoints);
    }


    public void printJumpLengths() {
        System.out.print("            jump length:");
        for (int i = 0; i < jumps.size(); i++) {
            if (i == jumps.size() - 1) {
                System.out.print(" " + jumps.get(i) + " m");
            } else {
                System.out.print(" " + jumps.get(i) + " m,");
            }
        }
    }


}
