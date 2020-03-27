import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPlus implements ActionListener {

    private JTextField inputTextValue;
    private JTextField outputTextValue;
    private JButton zButton;

    public CalculatorPlus(JTextField inputTextValue, JTextField outputTextValue, JButton zButton) {
        this.inputTextValue = inputTextValue;
        this.outputTextValue = outputTextValue;
        this.zButton = zButton;
    }

    /**
     * The value of the output field is added a number from the input field
     * and the output field is updated with a new value.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int input = getIntFromTextField(inputTextValue);
            int output = getIntFromTextField(outputTextValue);
            output += input;
            if (output == 0) {
                zButton.setEnabled(false);
            } else {
                zButton.setEnabled(true);
            }
            inputTextValue.setText("");
            outputTextValue.setText(Integer.toString(output));
        } catch (NumberFormatException ex) {
            System.out.println(ex.toString());
        }

    }

    /**
     * @param textField -takes JTextField object instance
     * @return - and turns its value into the Integer
     */
    private int getIntFromTextField(JTextField textField) {
        String tempText = textField.getText();
        return Integer.parseInt(tempText);
    }
}
