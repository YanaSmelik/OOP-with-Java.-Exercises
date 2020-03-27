import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorZ implements ActionListener {

    private JTextField inputTextValue;
    private JTextField outputTextValue;
    private JButton zButton;

    public CalculatorZ(JTextField inputTextValue, JTextField outputTextValue, JButton zButton) {
        this.inputTextValue = inputTextValue;
        this.outputTextValue = outputTextValue;
        this.zButton = zButton;
    }


    /**
     * the output field value is reset to zero
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        outputTextValue.setText("0");
        inputTextValue.setText("");
        zButton.setEnabled(false);

    }
}
