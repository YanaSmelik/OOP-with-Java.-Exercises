package movingfigures;

import java.awt.*;

public class Box extends Figure {

    private int width;
    private int height;

    public Box(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(getX(), getY(),getWidth(), getHeight());
    }
}
