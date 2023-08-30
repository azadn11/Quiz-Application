package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class Score extends JFrame implements ActionListener 
{
    //globally declaring variables
    
    JLabel img1,img2,img3,img4,img5,img6,heading,labelscore,repeat;
    JButton submit1,submit2;
    JPanel panel;
    
    Score(String name, int score)      //parameterized constructor
       {   

        img6=new JLabel();
        img6.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/score.png"));
        img6.setBounds(25, 200, 360, 360);
        add(img6);
        
        heading = new JLabel("Thank You " +name + " for playing SyntaxSprint with us!! Hope you enjoyed it.");
        heading.setBounds(10, 100, 1500, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        heading.setBackground(new Color(167,199,231));
        add(heading);

        String selectedChoice = Login.getSelectedChoice(); //to access a variable from login class
        
        if (score==100)
        {
            labelscore = new JLabel("Your score in " + selectedChoice + " is " + score);
            labelscore.setBounds(400, 270, 450, 30);
            labelscore.setFont(new Font("Arial", Font.BOLD, 27));
            labelscore.setBackground(new Color(167,199,231));
            add(labelscore); 
            
            img1=new JLabel();
            img1.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/bestscore.jpeg"));
            img1.setBounds(750, 270, 227, 222);
            add(img1);
        }
        
        else if (score >= 80 && score<100)
        {
            labelscore = new JLabel("Your score in " + selectedChoice + " is " + score);
            labelscore.setBounds(400, 270, 450, 30);
            labelscore.setFont(new Font("Arial", Font.BOLD, 27));
            labelscore.setBackground(new Color(167,199,231));
            add(labelscore); 
            
            img2=new JLabel();
            img2.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/highscore.jpeg"));
            img2.setBounds(750, 270, 436, 388);
            add(img2);
        }
        
        else if (score >= 60 && score<80  )
        {
            labelscore = new JLabel("Your score in " + selectedChoice + " is " + score);
            labelscore.setBounds(400, 270, 450, 30);
            labelscore.setFont(new Font("Arial", Font.BOLD, 27));
            labelscore.setBackground(new Color(167,199,231));
            add(labelscore); 
            
            img3=new JLabel();
            img3.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/mediumscore.jpeg"));
            img3.setBounds(750, 270, 225, 225);
            add(img3);
        }
        
        else if( score>=30 && score <60)
        {
            labelscore = new JLabel("Your score in " + selectedChoice + " is " + score);
            labelscore.setBounds(400, 270, 450, 30);
            labelscore.setFont(new Font("Arial", Font.BOLD, 27));
            labelscore.setBackground(new Color(167,199,231));
            add(labelscore); 
            
            img4=new JLabel();
            img4.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/passscore.jpeg"));
            img4.setBounds(750, 270, 275, 183);
            add(img4);
        } 
        
        else if( score >=0 && score < 30)
        {
            labelscore = new JLabel("Your score in " + selectedChoice + " is " + score + "/100");
            labelscore.setBounds(400, 270, 450, 30);
            labelscore.setFont(new Font("Arial", Font.BOLD, 27));
            labelscore.setBackground(new Color(167,199,231));
            add(labelscore); 
            
            img5=new JLabel();
            img5.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/badscore.jpeg"));
            img5.setBounds(800, 270, 225, 224);
            add(img5);
        }
         
        repeat= new JLabel("Do you want to play again? ");
        repeat.setBounds(400, 520, 700, 35);
        repeat.setFont(new Font("Arial", Font.BOLD, 30));
        repeat.setBackground(new Color(167,199,231));
        add(repeat);
        
        submit1 = new JButton("YES!");
        submit1.setBounds(800, 520, 90, 40);
        submit1.setFont(new Font("Times New Roman", Font.BOLD, 27));
        submit1.setForeground(Color.WHITE);
        submit1.setBackground(new Color(167,199,231));
        submit1.setBorder(BorderFactory.createBevelBorder(0));
        submit1.addActionListener(this);
        add(submit1);
        
        submit2 = new JButton("Quit");
        submit2.setBounds(930, 520, 90, 40);
        submit2.setFont(new Font("Times New Roman", Font.BOLD, 27));
        submit2.setForeground(Color.WHITE);
        submit2.setBackground(new Color(167,199,231));
        submit2.setBorder(BorderFactory.createBevelBorder(0));
        submit2.addActionListener(this);
        add(submit2);
        
        
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
    
    public void actionPerformed(ActionEvent ae)  //for submit1 and submit2 button
    {
        if(ae.getSource()== submit1)
       {
           setVisible(false);
           new Login();
       }
       
       else if(ae.getSource()== submit2)
       {
           setVisible(false);
       }
        
    } 

    public static void main(String[] args) 
    {
        new Score("User", 0);
    }
}
