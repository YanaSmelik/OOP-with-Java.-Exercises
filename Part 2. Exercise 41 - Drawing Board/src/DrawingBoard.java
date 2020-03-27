import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {


    public DrawingBoard() {
        super.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Color.CYAN);
        graphics.fillRect(90, 70, 80, 80);
        graphics.setColor(Color.CYAN);
        graphics.fillRect(320, 70, 80, 80);

        graphics.setColor(Color.CYAN);
        graphics.fillRect(50, 270, 50, 50);
        graphics.setColor(Color.CYAN);
        graphics.fillRect(390, 270, 50, 50);

        graphics.setColor(Color.CYAN);
        graphics.fillRect(100, 320, 290, 50);
    }
}
