package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    public static int length;
    public static int height;

    private int moves;
    private boolean vampireIsMovable;
    private Player player;
    private Scanner reader;
    private ArrayList<Vampire> vampires;


    public Dungeon(int length, int height, int vampires, int moves, boolean vampireIsMovable) {
        this.length = length;  // length and height - represent the dimension of the dungeon (always a rectangle);
        this.height = height;
        this.moves = moves;  // moves - determines the initial number of moves
        this.vampireIsMovable = vampireIsMovable; //if vampiresMoves is false --> the vampires do not move
        this.player = new Player();  // game has only one player
        this.reader = new Scanner(System.in); //create one scanner object that will be used multiple times throughout the program
        this.vampires = new ArrayList<Vampire>(vampires);
        for (int i = 0; i < vampires; i++) {     //add  vampires to the List
            this.vampires.add(new Vampire());
        }
    }

    public static int getLength() {
        return length;
    }

    public static int getHeight() {
        return height;
    }

    //starts the game
    public void run() {
        checkInitialPositions();  //check that there's no vampire at 0,0. And all vampires have different coordinates.
        while (moves >= 0) {          //loop while user has moves
            printInformation();       //print field
            System.out.print("Moves left: " + moves + "\nYour step(s): ");  //how many moves left //ask user for input (command(s))
            String command = reader.nextLine();
            playerMove(command);  //move player
            destroyVampire();     //destroy vampires if player run into them
            if (vampireIsMovable && vampires.size() != 0) {   //move vampires if it's allowed
                vampiresMove(command.length());  //move each vampire as many times as Player has moved
            }
            if (vampires.size() == 0) {          //if vampires are all destroyed  - player won
                printCurrentMap();
                System.out.println("\nYOU WON!");
                break;
            }
            if (moves == 0) {                    //if player run out of moves, but there are still vampires - he lost
                System.out.println("\nYOU LOST!\n" +
                        "GAME OVER.");
            }
            moves--;
        }
    }


    //vampires are shuffled until no one of them is at 0,0 or takes the same place with other vampire
    private void checkInitialPositions() {
        for (Vampire vampire : vampires) {
            while ((vampire.getX() == 0 && vampire.getX() == 0) ||
                    !vampire.isFreeSpot(vampires)) {
                vampire.move(vampires);
            }
        }
    }


    //prints field information: Player's and Vampires' coordinates and current map
    public void printInformation() {
        printPlayersCoordinates();
        printVampiresCoordinates();
        printCurrentMap();
    }

    //prints player's coordinates
    public void printPlayersCoordinates() {
        System.out.println(player.coordinatesToString());
    }

    //prints coordinates of all vampires
    public void printVampiresCoordinates() {
        for (Vampire vampire : vampires) {
            System.out.println(vampire.coordinatesToString());
        }
    }

    //prints player's position on the field
    public void printCurrentMap() {
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= length; j++) {
                if (i == player.getY() && j == player.getX()) {
                    System.out.print("P");
                } else if (doCoordinatesMatch(j, i)) {
                    System.out.print("V");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    //helper method for printing vampires on Map
    public boolean doCoordinatesMatch(int x, int y) {
        for (Vampire vampire : vampires) {
            if (vampire.getX() == x && vampire.getY() == y) {
                return true;
            }
        }
        return false;
    }


    public void playerMove(String command) {
        char[] moves = command.toCharArray(); //convert user's command(s) to array of chars (keys);
        for (int i = 0; i < moves.length; i++) { // change Player's coordinates accordingly
            player.move(moves[i]);
        }
    }


    //if player and vampire run into each other  - the vampire is destroyed
    public void destroyVampire() {
        ArrayList<Vampire> vampireToRemove = new ArrayList<>();
        for (Vampire vampire : vampires) {
            if (player.getX() == vampire.getX() && player.getY() == vampire.getY()) {
                vampireToRemove.add(vampire);
            }
        }
        vampires.removeAll(vampireToRemove);
    }


    //move all vampires
    public void vampiresMove(int numberOfPlayerMoves) {
        while (numberOfPlayerMoves >= 0) {
            for (Vampire vampire : vampires) {
                vampire.move(vampires);
                numberOfPlayerMoves--;
            }
        }
    }
}


