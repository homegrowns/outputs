package person.Item;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

 public class Musics extends JFrame implements ActionListener {


     private Clip clip;


     public void playsound(String pathName, boolean isLoop) {
         try {
             clip = AudioSystem.getClip();
             File audioFile = new File(pathName);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
             clip.open(audioStream);
             clip.start();
             if (isLoop)
                 clip.loop(Clip.LOOP_CONTINUOUSLY);
         } catch (LineUnavailableException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (UnsupportedAudioFileException e) {
             e.printStackTrace();
         }
     }

     @Override
     public void actionPerformed(ActionEvent e) {

     }
 }
