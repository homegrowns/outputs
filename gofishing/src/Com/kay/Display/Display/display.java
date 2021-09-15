package Com.kay.Display.Display;
import javax.swing.*;


public class display {
    private JFrame frame;

    private String title;
    private int width, height;

    public display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

