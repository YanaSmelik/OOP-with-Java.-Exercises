package movingfigures;

import java.awt.*;

public abstract class Figure {

    //object variables: x and y tell the figure position on the board
    private int x;
    private int y;


    //constructor parameters define the original position of a figure
    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Figure() {

    }


    //method moves the figures according to the parameter coordinate movements.
    //E.g. if the position is (100, 100) at the beginning, after move(10, -50) -> the x=110, y = 50;
    public void move(int movingX, int movingY) {
        x += movingX;
        y += movingY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //draw the figure on the drawing board.
    public abstract void draw(Graphics graphics);
}
