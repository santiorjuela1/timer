package threads;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import gui.AMRAP;
import gui.GeneralWindow;
import sounds.Beep;

public class MyThread extends Thread {
    private  Integer wait = 7;
    public JFrame frame;
    AMRAP amrap = new AMRAP(frame);

    public MyThread(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        while (wait > 0) {
            String valuelbl = wait.toString();
            SwingUtilities.invokeLater(() -> {
              
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            wait--;

            if (wait < 3) {
                try {
                    Beep beep = new Beep();
                    beep.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setFeaturesLabel(JLabel label) {
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        label.setFocusable(false);
        label.setForeground(Color.white);
        // label.setBorder(new LineBorder(Color.black));
    }
}
