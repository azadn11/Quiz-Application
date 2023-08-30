package quiz.application;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.io.File;

//Java Quiz
public class Quiz1 extends JFrame implements ActionListener 
{
    String questions[][] = new String[10][5];  //10 questions rows, 4 options column plus a question column
    String ans[][] = new String[10][2];    
    String userans[][] = new String[10][1];
    JLabel qno, question,img2;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup bg;
    JPanel panel;
    JButton next, submit, lifeline;
    String name;
    Clip clip5;

    public static int timer = 10;
    public static int ans_given = 0;
    public static int count = 0;   // keeping track of qno
    public static int score = 0;
    
    Quiz1(String name) 
    {
        this.name = name;

        try {
            // Load and play the audio file in a loop
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/neha_admin/Desktop/pics/clock.wav"));
            clip5 = AudioSystem.getClip(); // Remove the re-declaration of clip3
            clip5.open(audioInputStream);
            clip5.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        

        img2=new JLabel();
        img2.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/quiz1.jpg"));
        img2.setBounds(190, 0, 805, 330);
        add(img2);
        
        qno = new JLabel();
        qno.setBounds(60, 400, 50, 25);
        qno.setFont(new Font("Times New Roman", Font.BOLD, 27));
        qno.setBackground(new Color(167,199,231));
        qno.setForeground(Color.BLACK);
        add(qno);
        
        question= new JLabel("");
        question.setFont(new Font("Times New Roman", Font.BOLD, 27));
        question.setBounds(88, 398, 1000,30);
        question.setBackground(new Color(167,199,231));
        question.setForeground(Color.BLACK);
        add(question);

        // all the questions[count][0] and its options
        
        questions[0][0] = "Father of Java?";
        questions[0][1] = "Guido van Rossum";
        questions[0][2] = "Dennis Ritchie ";
        questions[0][3] = "James Gosling";
        questions[0][4] = "Ryan Gosling";

        questions[1][0] = "To which of the following does the class string belong to?";
        questions[1][1] = "java.awt ";
        questions[1][2] = "java.string";
        questions[1][3] = "java.lang";
        questions[1][4] = "java.util";

        questions[2][0] = "When is the object created with new keyword?";
        questions[2][1] = "At runtime";
        questions[2][2] = "At compile time";
        questions[2][3] = "Depends on the object";
        questions[2][4] = "None of the above";

        questions[3][0] = "What is the maximum and minimum value of byte data type?";
        questions[3][1] = "-2147483647 & 2147483647";
        questions[3][2] = "-138 & 129";
        questions[3][3] = "-128 & 127";
        questions[3][4] = "0 & infinity";

        questions[4][0] = "In which memory is String stored, when we create it using new?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Identify the modifier which cannot be used for constructor?";
        questions[5][1] = "private";
        questions[5][2] = "protected";
        questions[5][3] = "static";
        questions[5][4] = "public";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Application Resource";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Archive Runner";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Identify the infinite loop?";
        questions[8][1] = "for(;;)";
        questions[8][2] = "for(int i=0;i<1;i--)";
        questions[8][3] = "for(int i=0;;i++)";
        questions[8][4] = "All of the above";

        questions[9][0] = " What is Runnable?";
        questions[9][1] = "interface";
        questions[9][2] = "class";
        questions[9][3] = "abstract class";
        questions[9][4] = "method";
        
        //[i][1]
        ans[0][1] = "James Gosling";
        ans[1][1] = "java.lang";
        ans[2][1] = "At runtime";
        ans[3][1] = "-128 & 127";
        ans[4][1] = "Heap memory";
        ans[5][1] = "static";
        ans[6][1] = "import";
        ans[7][1] = "Java Archive";
        ans[8][1] = "All of the above";
        ans[9][1] = "interface";
        
        // options ka radiobutton
        
        r1= new JRadioButton("");
        r1.setBounds(60, 450, 500, 30);
        r1.setFont(new Font("Times New Roman", Font.BOLD, 27));
        r1.setBackground(new Color(167,199,231));
        add(r1);
    
        r2= new JRadioButton("");
        r2.setBounds(60, 500, 500, 30);
        r2.setFont(new Font("Times New Roman", Font.BOLD, 27));
        r2.setBackground(new Color(167,199,231));
        add(r2);
    
        r3= new JRadioButton("");
        r3.setBounds(60, 550, 500, 30);
        r3.setFont(new Font("Times New Roman", Font.BOLD, 27));
        r3.setBackground(new Color(167,199,231));
        add(r3);
    
        r4= new JRadioButton("");
        r4.setBounds(60, 600, 500, 30);
        r4.setFont(new Font("Times New Roman", Font.BOLD, 27));
        r4.setBackground(new Color(167,199,231));
        add(r4);
        
        bg= new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        
        // next,submit,lifeline buttons
     
        next= new JButton("Next Question");
        next.setBounds(900, 450, 160, 50);
        next.setFont(new Font("Times New Roman", Font.BOLD, 22));
        next.setForeground(Color.black);
        next.setBackground(new Color(167,199,231));
        next.setBorder(BorderFactory.createBevelBorder(0));
        next.addActionListener(this);
        add(next);
        
        lifeline= new JButton("50-50 Lifeline");
        lifeline.setBounds(900, 518, 160, 50);
        lifeline.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lifeline.setForeground(Color.black);
        lifeline.setBackground(new Color(167,199,231));
        lifeline.setBorder(BorderFactory.createBevelBorder(0));
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit= new JButton("Submit");
        submit.setBounds(900, 585, 160, 50);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 22));
        submit.setForeground(Color.black);
        submit.setBackground(new Color(167,199,231));
        submit.setBorder(BorderFactory.createBevelBorder(0));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);    
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLayout(null); 
        setVisible(true);
        setSize(1220,750);
        setLocation(110,50);
   
    panel = new JPanel() 
    {
                @Override
                protected void paintComponent(Graphics g) 
                {
                    super.paintComponent(g);
                    
                    // start and end points for the gradient
                    Point2D start = new Point2D.Float(0, 0);     
                    Point2D end = new Point2D.Float(getWidth(), getHeight());
                    
                    //hex code for colors of gradient
                    Color startColor = new Color(8,80,120);
                    Color endColor = new Color(133,216,206);
                    
                    //gradient paint object
                    GradientPaint gradient = new GradientPaint(start, startColor, end, endColor);
                    
                    // Set the paint to the graphics object and paint the background
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                
                }
     };
           
           panel.setBounds(0, 0, 1220, 750);
           add(panel);    
}
      public void actionPerformed(ActionEvent ae) 
    {      
        //for next button
        if (ae.getSource() == next) 
        {
            repaint();     //after pressing next, to enable all the options again
            r1.setEnabled(true);
            r2.setEnabled(true);
            r3.setEnabled(true);
            r4.setEnabled(true);
            
            ans_given = 1;      // 1 means ans given and 0 means no answer given
                            
            //user didnt select any option
            if (bg.getSelection() == null) 
            {
               userans[count][0] = "";
            } 
            else 
            {                           //taking what option user selected and storing in userans array
                userans[count][0] = bg.getSelection().getActionCommand();
            }
            
            if (count == 8)  //if qno8 then on last question9, next disable and submit enable
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } 
        
        //for lifeline, which 2 options to get disabled, doing that
        else if (ae.getSource() == lifeline) 
        {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) //if qno2,4,6,8,9 then option 2,3 disable
            {
                r2.setEnabled(false);
                r3.setEnabled(false);
            } 
            else 
            {
                r1.setEnabled(false);               //if qno0,1,3,5,7 then option 1,4 disable
                r4.setEnabled(false);
            }
            
            lifeline.setEnabled(false);
        } 
        
        //for submit button
        else if (ae.getSource() == submit) 
        {
            ans_given = 1;
            if (bg.getSelection() == null)
            {
                userans[count][0] = "";
            } else 
            {
                userans[count][0] = bg.getSelection().getActionCommand();
            }

            for (int i = 0; i < userans.length; i++) 
            {
                if (userans[i][0].equals(ans[i][1])) 
                {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    //timer ka setting
    public void paint(Graphics g) 
    {
        super.paint(g);
        
        String time = "Time left: " + timer + " secs"; // 15
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 25));          
        
        if (timer > 0) 
        { 
            g.drawString(time, 900, 450);
        } 
        else 
        {
            g.drawString("Times up!!", 900, 450);
        }
        
        timer--; // 14
        
        try 
        {
            Thread.sleep(1000);
            repaint();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        //ans given or not to check that, 0: not given
        if (ans_given == 1) 
        {
            ans_given = 0;
            timer = 10;
        } 
        
        else if (timer < 0) 
        {
            timer = 10;
            r1.setEnabled(true);
            r2.setEnabled(true);
            r3.setEnabled(true);
            r4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9)   //if dont press submit on the last q and time is up then get submitted automatically
            { 
                if (bg.getSelection() == null) 
                {
                   userans[count][0] = "";
                } 
                else 
                {
                    userans[count][0] = bg.getSelection().getActionCommand();
                }
                
                //checking ans with option selected
                for (int i = 0; i < userans.length; i++)   
                {
                    if (userans[i][0].equals(ans[i][1])) 
                    {
                        score += 10;
                    } 
                    else
                    {
                        score -= 1;
                    }
                }
                
                setVisible(false);
                new Score(name, score);
            } 
            else 
            { 
                if (bg.getSelection() == null) 
                {
                   userans[count][0] = "";
                } 
                else 
                {
                    userans[count][0] = bg.getSelection().getActionCommand();
                }
                count++; 
                start(count);
            }
        }
        
    }
    
    public void start(int count) 
    {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        r1.setText(questions[count][1]);
        r1.setActionCommand(questions[count][1]);
        
        r2.setText(questions[count][2]);
        r2.setActionCommand(questions[count][2]);
        
        r3.setText(questions[count][3]);
        r3.setActionCommand(questions[count][3]);
        
        r4.setText(questions[count][4]);
        r4.setActionCommand(questions[count][4]);
        
        bg.clearSelection();
    }  
    
    @Override
    public void dispose() {
       // Stop the audio and close the clip when the frame is disposed
       if (clip5 != null) {
           clip5.stop();
           clip5.close();
       }
       super.dispose();
   }   

    public static void main(String[] args) 
    {
        new Quiz1("User");
    }
}