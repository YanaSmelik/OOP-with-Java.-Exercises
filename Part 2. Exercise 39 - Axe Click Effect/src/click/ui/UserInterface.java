package click.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = new PersonalCalculator();
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);

        JLabel textLabel = new JLabel("0");
        JButton clickButton = new JButton("Click!");

        ClickListener clickListener = new ClickListener(calculator, textLabel);
        clickButton.addActionListener(clickListener);

        container.add(textLabel, BorderLayout.SOUTH);
        container.add(clickButton, BorderLayout.NORTH);
    }
}
