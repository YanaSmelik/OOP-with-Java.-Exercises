package game;

import gameoflife.GameOfLifeBoard;

import java.util.Scanner;

public class GameOfLifeTester {

    private GameOfLifeBoard board;
    private Scanner reader;

    public GameOfLifeTester(GameOfLifeBoard board) {
        this.board = board;
        reader = new Scanner(System.in);
    }


    public void play() {
        System.out.print("Press enter to continue, otherwise quit: ");
        String input = reader.nextLine();
        if (!input.equals("stop")) {
            printBoard();
        }
    }


    public void printBoard() {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getLength(); j++) {
                if (board.isAlive(j, i)) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
