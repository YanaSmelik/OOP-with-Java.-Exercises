package noticeboard;

import javax.swing.*;
import java.awt.*;

public class NoticeBoard implements Runnable {


    private JFrame frame;

    public NoticeBoard() {

    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JTextField topTextField = new JTextField("I was copied here from the JTextArea");
        JButton copyButton = new JButton("Copy!");
        JTextField bottomTextField = new JTextField();

        ActionEventListener listener = new ActionEventListener(topTextField, bottomTextField);
        copyButton.addActionListener(listener);

        container.add(topTextField);
        container.add(copyButton);
        container.add(bottomTextField);
    }


}
