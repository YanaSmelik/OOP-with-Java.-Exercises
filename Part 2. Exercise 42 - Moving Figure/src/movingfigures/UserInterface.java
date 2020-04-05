package movingfigures;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Figure figure;

    public UserInterface(Figure figure){
        this.figure = figure;
    }

    @Override
    public void run() {
        frame = new JFrame("Moving Figures");
        frame.setPreferredSize(new Dimension(700, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        DrawingBoard drawingBoard = new DrawingBoard(figure);
        container.add(drawingBoard);
        frame.addKeyListener(new KeyboardListener(drawingBoard, figure));
    }
}
