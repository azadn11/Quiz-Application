package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Point2D;


public class Display1 extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton credit,Login;
    JPanel panel;         
    
    Display1()
{
    l1=new JLabel();
    l1.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/logo2.png"));
    l1.setBounds(330, 50, 524, 213);
    add(l1);  

    l3=new JLabel();
    l3.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/puzzle.png"));
    l3.setBounds(10, 70, 244 ,148);
    add(l3);

    l6=new JLabel();
    l6.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/js.png"));
    l6.setBounds(900, 70, 91 ,83);
    add(l6);

    l7=new JLabel();
    l7.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/java1.png"));
    l7.setBounds(1070, 70, 64 ,114);
    add(l7);

    l8=new JLabel();
    l8.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/python1.png"));
    l8.setBounds(950, 160, 96 ,99);
    add(l8);
    
    l2= new JLabel("An app which tests your clarity on programming languages");
    l2.setBounds(255, 180, 800, 236);
    l2.setFont(new Font("Times New Roman", Font.BOLD, 27));
    add(l2);

    l4=new JLabel();                //for login button
    l4.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/register.png"));
    l4.setBounds(250, 500, 139, 89);
    add(l4);

    l5=new JLabel();                //for credits button
    l5.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/team.png"));
    l5.setBounds(850, 470, 125, 95);
    add(l5);
    
    credit= new JButton("Credits");
    credit.setBounds(690, 500, 130, 50);
    credit.setFont(new Font("Times New Roman", Font.BOLD, 30));
    credit.setForeground(Color.BLACK);
    credit.setBackground(Color.BLACK);
    credit.setBorder(BorderFactory.createBevelBorder(0));
    credit.addActionListener(this);
    credit.setToolTipText("CREDITS");
    add(credit);
    
    Login= new JButton("Login");
    Login.setBounds(400, 500, 130, 50);
    Login.setFont(new Font("Times New Roman", Font.BOLD, 30));
    Login.setForeground(Color.BLACK);
    Login.setBackground(Color.BLACK);
    Login.setBorder(BorderFactory.createBevelBorder(0));
    Login.setToolTipText("LOGIN");
    Login.addActionListener(this);
    add(Login);
    
    
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
        
                    Point2D start = new Point2D.Float(0, 0);        // start and end points for the gradient
                    Point2D end = new Point2D.Float(getWidth(), getHeight());
            
                    Color startColor = new Color(8,80,120);
                    Color endColor = new Color(133,216,206);         
                   
                    GradientPaint gradient = new GradientPaint(start, startColor, end, endColor);   //gradient paint object
           
                    Graphics2D g2d = (Graphics2D) g;    // Set the paint to the graphics object and paint the background
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());           
                }
     };       
           panel.setBounds(0, 0, 1220, 750);
           add(panel);
  }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
       if(ae.getSource()== credit)
       {   
           //setVisible(false);
           new Credits();
       }
       
       else if(ae.getSource()==Login)
       {
           setVisible(false);
           new Login();
       }    
    }            



   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           new Display1(); // Create a single instance of Display1
        });
    }  
}    