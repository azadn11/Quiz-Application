package quiz.application;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.io.File;


//Python quiz
public class Quiz2 extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];  //10 questions rows, 4 options column plus a question column
    String ans[][] = new String[10][2];    
    String userans[][] = new String[10][1];
    JLabel qno, question,img2;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup bg;
    JPanel panel;
    JButton next, submit, lifeline;
    
    public static int timer = 10;
    public static int ans_given = 0;
    public static int count = 0;   // keeping track of qno
    public static int score = 0;
    private Clip clip4;

    String name;
    
    Quiz2(String name) 
    {
        this.name = name;
        
        try {
            // Load and play the audio file in a loop
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/neha_admin/Desktop/pics/clock.wav"));
            clip4 = AudioSystem.getClip(); // Remove the re-declaration of clip3
            clip4.open(audioInputStream);
            clip4.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        img2=new JLabel();
        img2.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/quiz2.png"));
        img2.setBounds(160,0, 1068,414);
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
        
        questions[0][0] = "Who developed Python?";
        questions[0][1] = "James Gosling";
        questions[0][2] = "Dennis Ritchie ";
        questions[0][3] = "Guido van Rossum";
        questions[0][4] = "Ryan Gosling";

        questions[1][0] = "The type of loop not supported in Python?";
        questions[1][1] = "for";
        questions[1][2] = "while";
        questions[1][3] = "do while";
        questions[1][4] = "None of the above";

        questions[2][0] = "Which function converts date to corresponding time?";
        questions[2][1] = "strptime()";
        questions[2][2] = "strftime()";
        questions[2][3] = "Both of them";
        questions[2][4] = "None of the above";

        questions[3][0] = "As what datatype are the *kwargs stored when passed into a function?";
        questions[3][1] = "List";
        questions[3][2] = "Tuple";
        questions[3][3] = "Dictionary";
        questions[3][4] = "None of the above";

        questions[4][0] = "Which of the following are valid escape sequences?";
        questions[4][1] = "\\n";
        questions[4][2] = "\\t";
        questions[4][3] = "\\";
        questions[4][4] = "All of the above";

        questions[5][0] = "Which of the following modules handles date time computations?";
        questions[5][1] = "date";
        questions[5][2] = "datetime";
        questions[5][3] = "timedate";
        questions[5][4] = "time";

        questions[6][0] = "In which language is Python written?";
        questions[6][1] = "C";
        questions[6][2] = "C++";
        questions[6][3] = "Assmebly";
        questions[6][4] = "Java";

        questions[7][0] = "Which type of Programming does Python support?";
        questions[7][1] = "object oriented programming";
        questions[7][2] = "structured programming";
        questions[7][3] = "functional programming";
        questions[7][4] = "All of the above";

        questions[8][0] = "Is Python code compiled or interpreted?";
        questions[8][1] = "Python code is both compiled and interpreted";
        questions[8][2] = "Python code is neither compiled nor interpreted";
        questions[8][3] = "Python code is only compiled";
        questions[8][4] = "Python code is only interpreted";

        questions[9][0] = " What does pip stand for?";
        questions[9][1] = "Pip Installs Python";
        questions[9][2] = "Pip Installs Packages";
        questions[9][3] = "Package Installs Program";
        questions[9][4] = "Preferred Installer Program";
        
        //[i][1]
        ans[0][1] = "Guido van Rossum";
        ans[1][1] = "do while";
        ans[2][1] = "strptime()";
        ans[3][1] = "Dictionary";
        ans[4][1] = "All of the above";
        ans[5][1] = "datetime";
        ans[6][1] = "C";
        ans[7][1] = "All of the above";
        ans[8][1] = "Python code is both compiled and interpreted";
        ans[9][1] = "Preferref Installer Program";
        
        // options ka radiobutton
        
        r1= new JRadioButton("");
        r1.setBounds(60, 450, 800, 30);
        r1.setFont(new Font("Times New Roman", Font.BOLD, 27));
        r1.setBackground(new Color(167,199,231));
        add(r1);
    
        r2= new JRadioButton("");
        r2.setBounds(60, 500, 800, 30);
        r2.setFont(new Font("Times New Roman", Font.BOLD, 27));
        r2.setBackground(new Color(167,199,231));
        add(r2);
    
        r3= new JRadioButton("");
        r3.setBounds(60, 550, 800, 30);
        r3.setFont(new Font("Times New Roman", Font.BOLD, 27));
        r3.setBackground(new Color(167,199,231));
        add(r3);
    
        r4= new JRadioButton("");
        r4.setBounds(60, 600, 800, 30);
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
        next.setBounds(950, 450, 160, 50);
        next.setFont(new Font("Times New Roman", Font.BOLD, 22));
        next.setForeground(Color.black);
        next.setBackground(new Color(167,199,231));
        next.setBorder(BorderFactory.createBevelBorder(0));
        next.addActionListener(this);
        add(next);
        
        lifeline= new JButton("50-50 Lifeline");
        lifeline.setBounds(950, 518, 160, 50);
        lifeline.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lifeline.setForeground(Color.black);
        lifeline.setBackground(new Color(167,199,231));
        lifeline.setBorder(BorderFactory.createBevelBorder(0));
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit= new JButton("Submit");
        submit.setBounds(950, 585, 160, 50);
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
            
            ans_given = 1;
                            
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
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9 || count == 7) //if qno2,4,6,8,9,7 then option 2,3 disable
            {
                r2.setEnabled(false);
                r3.setEnabled(false);
            } 
            else 
            {
                r1.setEnabled(false);               //if qno0,1,3,5 then option 1,4 disable
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
        
        String time = "Time left: " + timer + " secs"; // 10
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 25));          
        
        if (timer > 0) 
        { 
            g.drawString(time, 950, 450);
        } 
        else 
        {
            g.drawString("Times up!!", 950, 450);
        }
        
        timer--; // 9
        
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
                        score += 0;
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
        if (clip4 != null) {
            clip4.stop();
            clip4.close();
        }
        super.dispose();
    }   

    public static void main(String[] args) 
    {
        new Quiz2("User");
    }
}