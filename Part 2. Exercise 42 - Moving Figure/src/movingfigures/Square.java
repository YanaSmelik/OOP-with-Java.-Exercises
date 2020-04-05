package movingfigures;

import java.awt.*;

public class Square extends Figure {

    private int sideLength;

    public Square (int x, int y, int sideLength){
        super(x, y);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(getX(), getY(), getSideLength(), getSideLength());
    }
}
