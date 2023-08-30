package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

class Credits extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1;
    JPanel panel;

    Credits() {
        
        l1 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        l1.setBounds(0, 35, 1220, 5);
        add(l1);

        l2 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        l2.setBounds(0, 155, 1220, 5);
        add(l2);

        l3= new JLabel(" CREDITS ");
        l3.setBounds(450,80,500,50);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 65));
        l3.setBackground(new Color(167,199,231));
        l3.setForeground(Color.BLACK);
        add(l3);

        l4= new JLabel(" Developed By: Neha Azad, Nayan Chavare, Trupti Sarang, Wasim Ansari");
        l4.setBounds(20,200,1500,50);
        l4.setFont(new Font("Times New Roman", Font.BOLD, 36));
        l4.setBackground(new Color(167,199,231));
        l4.setForeground(Color.BLACK);
        add(l4);

        l9= new JLabel("                           Shravani Sontakke");
        l9.setBounds(20,250,1500,50);
        l9.setFont(new Font("Times New Roman", Font.BOLD, 36));
        l9.setBackground(new Color(167,199,231));
        l9.setForeground(Color.BLACK);
        add(l9);

        l5= new JLabel(" College Name: Ramnarain Ruia College ");
        l5.setBounds(20,330,1100,50);
        l5.setFont(new Font("Times New Roman", Font.BOLD, 36));
        l5.setBackground(new Color(167,199,231));
        l5.setForeground(Color.BLACK);
        add(l5);

        l6= new JLabel(" Department: Computer Science ");
        l6.setBounds(20,410,1100,50);
        l6.setFont(new Font("Times New Roman", Font.BOLD, 36));
        l6.setBackground(new Color(167,199,231));
        l6.setForeground(Color.BLACK);
        add(l6);

        l7= new JLabel(" 3rd Semester Project, JAVA ");
        l7.setBounds(20,490,1100,50);
        l7.setFont(new Font("Times New Roman", Font.BOLD, 36));
        l7.setBackground(new Color(167,199,231));
        l7.setForeground(Color.BLACK);
        add(l7);

        l8= new JLabel();
        l8.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/college.jpeg"));
        l8.setBounds(1000, 550, 181, 134);
        add(l8);

        b1 = new JButton("Back");
        b1.setBounds(550, 620, 70, 50); // Adjusted button size and position
        b1.setFont(new Font("Times New Roman", Font.BOLD, 25)); // Reduced font size
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE); // Changed background color
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createBevelBorder(0));
        add(b1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(1220, 750);
        setLocation(110, 50);

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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Display1();
    }

    public static void main(String[] args) {
        new Credits();
    }
}
