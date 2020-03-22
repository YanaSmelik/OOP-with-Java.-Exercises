import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    public UserInterface() {

    }

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(220, 220));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }


    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Are you?"));

        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");

        ButtonGroup checkBoxesGroup = new ButtonGroup();
        checkBoxesGroup.add(yes);
        checkBoxesGroup.add(no);

        container.add(yes);
        container.add(no);

        container.add(new JLabel("Why?"));

        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton becauseFun = new JRadioButton("Because it is fun!");

        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(noReason);
        radioButtonsGroup.add(becauseFun);

        container.add(noReason);
        container.add(becauseFun);

        JButton done = new JButton("Done!");
        container.add(done);
    }

}
