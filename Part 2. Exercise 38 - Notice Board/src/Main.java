import noticeboard.NoticeBoard;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        NoticeBoard ui = new NoticeBoard();
        SwingUtilities.invokeLater(ui);
    }
}
