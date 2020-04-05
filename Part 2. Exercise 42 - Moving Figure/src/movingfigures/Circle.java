package movingfigures;

import java.awt.*;

public class Circle extends Figure {

    private int diameter;


    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }


    //draws a circle of the right size, in place defined by coordinates
    //first two parameters are taken for the position of the circle
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillOval(getX(), getY(), getDiameter(), getDiameter());
    }

    public int getDiameter() {
        return diameter;
    }
}
