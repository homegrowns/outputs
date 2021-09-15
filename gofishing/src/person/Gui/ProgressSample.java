package person.Gui;


    import java.awt.BorderLayout;
import java.awt.Container;
    import java.awt.image.BufferedImage;
    import java.io.File;

    import javax.imageio.ImageIO;
    import javax.swing.*;
    import javax.swing.border.Border;

    public class ProgressSample extends JFrame {


        public static void main(String args[]) {
            int num = 0;
            boolean start = true;
            JFrame f = new JFrame("JProgressBar Sample");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container content = f.getContentPane();
            JProgressBar progressBar = new JProgressBar();
            progressBar.setValue(num);
            progressBar.setStringPainted(true);

            JButton btn1 = new JButton("Click to fish!");


            // 버튼 위치와 크기 설정
            btn1.setBounds(230, 170, 122, 30);


            // 프레임에다가 버튼 추가
            f.getContentPane().add(btn1);


            JLabel lbl = new JLabel();
            lbl.setBounds(155, 200, 270, 50);
            lbl.setText("게임을 시작합니다");
            lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
            f.getContentPane().add(lbl);

            // ★ 버튼이 눌렸을때
            btn1.addActionListener(event ->
            { progressBar.setValue(num + 20);});


            JLabel imgLbl = new JLabel();


            File file = new File("c:\\낚시ed.png");  //이미지 파일 경로
            BufferedImage m;

            try {
                m = ImageIO.read(file); //이미지 파일을 읽어와서 BufferedImage 에 넣음
                imgLbl.setIcon(new ImageIcon(m)); //레이블에 이미지 표시
            } catch (
                    Exception e) {
            }


            // ★ 기타 설정
            imgLbl.setBounds(10, 50, 30, 40);
            imgLbl.setHorizontalAlignment(JLabel.CENTER);
            f.getContentPane().add(imgLbl);

            f.setLocationRelativeTo(null);

            // 프레임을 닫았을 때 메모리에서 제거되도록 설정

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            Border border = BorderFactory.createTitledBorder("Fishing!");
            progressBar.setBorder(border);
            content.add(progressBar,BorderLayout.SOUTH);
            f.setSize(600, 300);
            f.setVisible(true);


        }
    }

