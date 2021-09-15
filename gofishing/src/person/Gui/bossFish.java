package person.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bossFish  extends JFrame {

    private Image backgroundImage = new ImageIcon("src/Image/엔딩.png").getImage();

    public bossFish(){
        setTitle("거대돌돔 드디어!");

        setSize(700, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 580);
        getContentPane().setLayout(null);

        JButton btnExit = new JButton("1억!!!");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(490, 500, 120, 33);
        getContentPane().add(btnExit);

        setVisible(true);
    }


    public void paint(Graphics g) {
        g.drawImage(backgroundImage,0 , 0,null);
    }

    public static void main(String[] args) {
        new bossFish();

    }
}

