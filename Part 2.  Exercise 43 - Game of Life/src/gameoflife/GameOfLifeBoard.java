package gameoflife;

public abstract class GameOfLifeBoard {

    private int length;
    private int height;
    private boolean[][] board;


    //creates a game board of the defined dimensions
    public GameOfLifeBoard(int length, int height) {
        this.length = length;
        this.height = height;
        board = new boolean[getLength()][getHeight()];
    }


    //provides access to the game board, which is a bidimensional table containing boolean values.
    public boolean[][] getBoard() {
         return board;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }


    //simulates a turn of the game
    public void playTurn() {

    }


    //animates the cell whose coordinates are x, y. That is it assigns the value true to it.
    //if the coordinates are outside the board nothing happens
    public abstract void turnToLiving(int x, int y);


    //kills the cell whose coordinates are x,y. It assigns the value false to it.
    //if the coordinates are outside the board, nothing happens
    public abstract void turnToDead(int x, int y);


    //tells whether the cell at x,y is alive.
    //if the coordinates are outside the board, the method returns false.
    public abstract boolean isAlive(int x, int y);


    //initiates all the cells of the board.
    //every cell is alive with a probability of probabilityForEachCell.
    //the probability is double value between [0, 1].
    //if a method is called with 1, all the cells have to be alive.
    //if the probability is 0, all the cells have to be dead.
    public abstract void initiateRandomCells(double probabilityForEachCell);


    //tells the number of living neighbours fo the cell at x, y.
    public abstract int getNumberOfLivingNeighbours(int x, int y);


    //manages the cell x,y according to the rules of the Game of Life.
    public abstract void manageCell(int x, int y, int livingNeighbours);
}
