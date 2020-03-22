package noticeboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventListener implements ActionListener {

    private JTextField topTextField;
    private JTextField bottomTextField;

    public ActionEventListener(JTextField topTextField, JTextField bottomTextField) {
        this.topTextField = topTextField;
        this.bottomTextField = bottomTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bottomTextField.setText(topTextField.getText());
        topTextField.setText("");
    }

}
