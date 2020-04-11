package game;

import gameoflife.GameOfLifeBoard;

import java.util.concurrent.ThreadLocalRandom;

public class PersonalBoard extends GameOfLifeBoard {


    public PersonalBoard(int width, int height) {
        super(width, height);
    }


    //animates the cell whose coordinates are x,y. It assigns the value true to it.
    //if the coordinates are outside the board, do nothing.
    @Override
    public void turnToLiving(int x, int y) {
        if (x >= 0 && x <= getLength() && y >= 0 && y <= getHeight()) {
            getBoard()[x][y] = true;
        }
    }


    //kills the cell whose coordinates are x, y. It assigns the value false to it.
    //if the coordinates are outside the board, nothing happens.
    @Override
    public void turnToDead(int x, int y) {
        if (x >= 0 && x <= getLength() && y >= 0 && y <= getHeight()) {
            getBoard()[x][y] = false;
        }
    }


    //tells whether the cell at x,y is alive.
    //if the coordinates are outside the board, the method returns false.
    @Override
    public boolean isAlive(int x, int y) {
        return getBoard()[x][y];
    }


    //initiates all the cells of the board
    //every cell is alive with a probability of probabilityForEachCell.
    //the probability is a double value between[0,1]
    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                double probability = ThreadLocalRandom.current().nextDouble(1.0);
                if (probability > probabilityForEachCell) {
                    getBoard()[i][j] = false;
                } else {
                    getBoard()[i][j] = true;
                }
            }
        }
    }

    private static final int[][] NEIGHBOURS = {
            {-1, -1}, {-1, 0}, {-1, +1},
            {0, -1}, {0, +1},
            {+1, -1}, {+1, 0}, {+1, +1}
    };

    //calculates the number of neighbour cells which are alive
    //central cells have 8 neighbours, the ones on the side have 5, and the ones in the corner have 3
    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int count = 0;
        for (int[] offset : NEIGHBOURS) {
            if ((x + offset[1] > -1 && y + offset[0] > -1)
                    && (x + offset[1] <= getLength() && y + offset[0] <= getHeight())) {
                if (getBoard()[x + offset[1]][y + offset[0]]) {
                    count++;
                }
            }
        }
        return count;
    }

    //Rules:
    //1. Every living cell dies if they have less than 2 living neighbours
    //2. Every living cell keeps on living during the following iteration (turn) if they have 2 or 3 living neighbours.
    //3. Every living cell dies if they have more than 3 living neighbours
    //4. Every dead cell is turned back to live if they have exactly 3 living neighbours
    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        //Every living cell dies if they have less than 2 living neighbours
        if (getBoard()[x][y] && livingNeighbours < 2) {
            getBoard()[x][y] = false;
        }
        //Every living cell keeps on living during the following iteration (turn) if they have 2 or 3 living neighbours.
        if (getBoard()[x][y] && (livingNeighbours == 2 || livingNeighbours == 3)) {
        }

        //Every living cell dies if they have more than 3 living neighbours
        if (getBoard()[x][y] && livingNeighbours > 3) {
            getBoard()[x][y] = false;
        }

        //Every dead cell is turned back to live if they have exactly 3 living neighbours
        if (!getBoard()[x][y] && livingNeighbours == 3) {
            getBoard()[x][y] = true;
        }

    }
}

