package click.ui;

import clicker.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {

    private Calculator calculator;
    private JLabel text;

    public ClickListener(Calculator calculator, JLabel text) {
        this.calculator = calculator;
        this.text = text;
    }


    //Calculator object increases by one at first
    //after it Calculator value is set as text of the JLabel object
    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.increase();
        text.setText(Integer.toString(calculator.giveValue()));
    }
}
