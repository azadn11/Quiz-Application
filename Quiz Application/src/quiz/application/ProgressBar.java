package quiz.application;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import java.io.File;                                    //music file
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class CustomProgressBarUI extends BasicProgressBarUI {
    private final int desiredHeight;

    public CustomProgressBarUI(int desiredHeight) {
        this.desiredHeight = desiredHeight;
    }

    @Override
    protected Dimension getPreferredInnerVertical() {
        Dimension dim = super.getPreferredInnerVertical();
        dim.height = desiredHeight;
        return dim;
    }
}

public class ProgressBar {
    private final int desiredHeight;
    static Timer t;
    JLabel logoLabel;
    Clip clip1;

    public ProgressBar(int desiredHeight) 
    {
        this.desiredHeight = desiredHeight;

        try {
            // Load and play the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/neha_admin/Desktop/pics/intro.wav"));
            clip1 = AudioSystem.getClip();
            clip1.open(audioInputStream);
            clip1.start(); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ImageIcon logoIcon = new ImageIcon("/Users/neha_admin/Desktop/pics/logo1.png");  // Provide the path to your image
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(392, 100, 436, 388);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            
            JFrame frame = new JFrame("Custom ProgressBar Height with Image");
             
            ProgressBar bar = new ProgressBar(10);  // Desired height for progress bar
            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setUI(new CustomProgressBarUI(10));  // Use CustomProgressBarUI
            progressBar.setStringPainted(true);
            progressBar.setForeground(Color.white);
            progressBar.setBounds(350, 500, 500, 50);  // Adjust the bounds as needed

            frame.add(progressBar);
            frame.add(bar.logoLabel);
            
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(1220, 750);  
            frame.setLocationRelativeTo(null);  
            frame.getContentPane().setBackground(new Color(76, 150, 172));
            frame.setVisible(true);

            t = new Timer();
            int duration = 10000;  // 10 seconds in milliseconds
            int interval = duration / 100;  // Each step interval

            t.scheduleAtFixedRate(new TimerTask() 
            {
                int value = 0;

                @Override
                public void run() 
                {
                    progressBar.setValue(value);
                    value++;
                    if (value > 100) 
                    {
                        t.cancel();
                        frame.setVisible(false);
                        new Display1();
                    }
                }
            }, 0, interval);  // Use the calculated interval
        });
    }
}
