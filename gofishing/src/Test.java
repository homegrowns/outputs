import javax.swing.*;

public class Test {
    private JPanel JPanel;
    private JScrollBar scrollBar1;

    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Test().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
