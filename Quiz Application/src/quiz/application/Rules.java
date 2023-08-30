package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class Rules extends JFrame implements ActionListener
{
    JLabel welcome,rules,focus;
    String name;
    JButton start,back;
    JPanel panel;
    
    Rules(String name)
    {
    
      this.name= name;
    
    welcome= new JLabel("Welcome to SyntaxSprint, " +name+ ". Here are a few rules for you:");
    welcome.setFont(new Font("Arial", Font.BOLD, 33));
    welcome.setBounds(30, 10, 1500, 100);
    welcome.setForeground(new Color(0,0,0));
    welcome.setBackground(new Color(167,199,231));
    add(welcome);   
        
    focus=new JLabel();
    focus.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/rules.png"));
    focus.setBounds(600, 380, 572, 354);
    add(focus);
    
    rules= new JLabel();
    rules.setFont(new Font("Times New Roman", Font.PLAIN, 24));
    rules.setBounds(40, 75, 1100, 450);
    rules.setBackground(new Color(167,199,231));
    rules.setText(
            "<html>"+ 
                "1: Don't sweat it. All the questions are from sanfoundry :) "  + "<br><br>" +
                "2: You only get to use 50-50 lifeline once so don't take rash decisions like your life decisions T_T "  + "<br><br>" +   
                "3: No need of eye contact with the person next to you, they may also not know the answer" + "<br><br>" +
                "4: Do not get nervous if your friend is answering more questions, they're def doing Jai Mata Di" + "<br><br>" +
                "5: You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                //"6: If ans is correct, you get +10 or else -1 (JEE/NEET flashbacks)" + "<br><br>" +  
                "6: May you know more than what John Snow knows, Good Luck!! " + "<br><br>" +
            "<html>"
                 );
    add(rules);
        
    start= new JButton("Start");
    start.setBounds(300, 600, 150, 50);
    start.setFont(new Font("Times New Roman", Font.BOLD, 30));
    start.setForeground(new Color(0,0,0));
    start.setBackground(new Color(167,199,231));
    start.setBorder(BorderFactory.createBevelBorder(0));
    start.addActionListener(this);
    add(start);
    
    back= new JButton("Back");
    back.setBounds(550, 600, 150, 50);
    back.setFont(new Font("Times New Roman", Font.BOLD, 30));
    back.setForeground(Color.BLACK);
    back.setBackground(new Color(167,199,231));
    back.setBorder(BorderFactory.createBevelBorder(0));
    back.addActionListener(this);
    add(back);
    
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
        if(ae.getSource()== start)
        {
           setVisible(false);

           String selectedChoice = Login.getSelectedChoice(); 
            
           switch (selectedChoice) 
               
           {
            case "Java":
                new Quiz1(name);
                break;
                
            case "Python":
                new Quiz2(name);
                break;
                
            case "C":
                new Quiz3(name);
                break;
               
            default:
                new Login();
                break;
           }
        }   
  
        else if(ae.getSource()== back) 
             {
                setVisible(false);
                new Login();
             }
        
    }
    

    
    public static void main(String[] args)    
   
    {
     new Rules("User");
 }
 
}
