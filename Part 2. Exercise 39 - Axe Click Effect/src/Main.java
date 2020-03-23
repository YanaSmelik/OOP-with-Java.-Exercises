import clicker.applicationlogic.PersonalCalculator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        click.ui.UserInterface ui = new click.ui.UserInterface(new PersonalCalculator());
        SwingUtilities.invokeLater(ui);


    }
}
