import javax.swing.*;
import java.awt.*;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private JTextField textOutputField;
    private JTextField textInputField;

    public GraphicCalculator() {
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }


    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        textOutputField = new JTextField("0");
        textInputField = new JTextField("");
        textOutputField.setEnabled(false);

        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton zButton = new JButton("Z");
        plusButton.addActionListener(new CalculatorPlus(textInputField, textOutputField, zButton));
        minusButton.addActionListener(new CalculatorMinus(textInputField, textOutputField, zButton));
        zButton.addActionListener(new CalculatorZ(textInputField, textOutputField, zButton));

        panel.add(plusButton);
        panel.add(minusButton);
        panel.add(zButton);
        container.add(textOutputField);
        container.add(textInputField);
        container.add(panel, BorderLayout.SOUTH);
    }

    private JFrame getFrame() {
        return frame;
    }

}
