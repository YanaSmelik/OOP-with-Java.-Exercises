package movingfigures;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompoundFigure extends Figure{


    private List<Figure> figures;


    public CompoundFigure(){
        super();
        this.figures = new ArrayList<Figure>();
    }


    public void add(Figure figure){
        this.figures.add(figure);
    }

    @Override
    public void move(int movingX, int movingY) {
        for (Figure f:figures) {
            f.move(movingX, movingY);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure f:figures) {
            f.draw(graphics);
        }
    }
}
