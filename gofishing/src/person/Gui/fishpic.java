package person.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fishpic extends JFrame {

    private Image backgroundImage = new ImageIcon("src/Image/거대돌돔.png").getImage();

    public fishpic(){
        setTitle("거대돌돔");

        setSize(700, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 700, 780);
        getContentPane().setLayout(null);

        JButton btnExit = new JButton("훌륭해!");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(490, 600, 120, 33);
        getContentPane().add(btnExit);

        setVisible(true);
    }


    public void paint(Graphics g) {
        g.drawImage(backgroundImage,0 , 0,null);
    }

    public static void main(String[] args) {
        new fishpic();

    }
}
