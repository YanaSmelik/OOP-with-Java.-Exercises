import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorMinus implements ActionListener {

    private JTextField inputTextValue;
    private JTextField outputTextValue;
    private JButton zButton;

    public CalculatorMinus(JTextField inputTextValue, JTextField outputTextValue, JButton zButton) {
        this.inputTextValue = inputTextValue;
        this.outputTextValue = outputTextValue;
        this.zButton = zButton;
    }

    /**
     *  The value from the input field is subtracted from the value in the output field
     *   and the output field is updated with a new value.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int input = getIntFromTextField(inputTextValue);
            int output = getIntFromTextField(outputTextValue);
            output -= input;
            if (output == 0) {
                zButton.setEnabled(false);
            } else {
                zButton.setEnabled(true);
            }
            outputTextValue.setText(Integer.toString(output));
            inputTextValue.setText("");
        } catch (NumberFormatException ex) {
            System.out.println(ex.toString());
        }
    }


    private int getIntFromTextField(JTextField textField) {
        String tempText = textField.getText();
        return Integer.parseInt(tempText);
    }
}
