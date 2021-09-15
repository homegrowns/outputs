package person.Gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainProgress extends Thread  {
    JProgressBar current = new JProgressBar(0, 2000);
    int num = 0;

    public MainProgress() {
    //    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        current.setValue(0);
        current.setStringPainted(false);
        pane.add(current);
      //  setContentPane(pane);
    }

    public void run() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            num += 95;
        }
    }
    public static void main(String[] arguments) {
        MainProgress frame = new MainProgress();

    }


}