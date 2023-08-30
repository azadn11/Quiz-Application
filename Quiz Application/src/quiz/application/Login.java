package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class Login extends JFrame implements ActionListener
{
   JLabel title,name,age,lang,gender,quali;
   private JLabel img1;
   JTextField tf1,tf2;
   JButton rules,exit,credit;
   static JRadioButton r1,r2,r3;        //declaring static because need to access it in another class
   private JRadioButton male,female;    
   ButtonGroup bg,bg2;
   JComboBox qualiBox;
   static JPanel panel;
   static JPanel panel2;
   public static String selectedChoice = ""; 
   
   Login() {     //non parameterized constructor
           
    title= new JLabel("Login Details");
    title.setFont(new Font("Times New Roman", Font.BOLD, 60));
    title.setBounds(500, 60, 400, 100);
    title.setForeground(Color.black);
    add(title);
    
    name= new JLabel("Name:");
    name.setFont(new Font("Times New Roman", Font.BOLD, 31));
    name.setBounds(255, 200, 500, 80);
    name.setForeground(Color.BLACK);
    add(name);
    
    tf1= new JTextField(40);
    tf1.setBounds(355, 210, 250, 60);
    tf1.setFont(new Font("Times New Roman", Font.BOLD, 31));
    tf1.setForeground(Color.BLACK);
    tf1.setBackground(new Color(220,220,220));
    add(tf1);
    
    age= new JLabel("Age:");
    age.setFont(new Font("Times New Roman", Font.BOLD, 31));
    age.setBounds(260, 300, 300, 100);
    age.setForeground(Color.BLACK);
    add(age);
    
    tf2= new JTextField(40);
    tf2.setBounds(335, 322, 250, 60);
    tf2.setFont(new Font("Times New Roman", Font.BOLD,31));
    tf2.setForeground(Color.BLACK);
    tf2.setBackground(new Color(220,220,220));
    add(tf2);
    
    //ComboBox
    
    quali = new JLabel("Qualification:");
    quali.setFont(new Font("Times New Roman", Font.BOLD, 31));
    quali.setBounds(670, 300, 250, 100);
    quali.setForeground(Color.BLACK);
    add(quali);

    String[] quali = {"High School", "Diploma", "Bachelor's", "Master's", "PhD"};
    qualiBox= new JComboBox<>(quali);
    qualiBox.setFont(new Font("Times New Roman", Font.PLAIN, 23));
    qualiBox.setBounds(880, 313, 200, 80);
    qualiBox.setForeground(Color.BLACK);
    qualiBox.setBackground(new Color(237, 223, 223));
    add(qualiBox);

    
    //radiobutton 2
    
    gender = new JLabel("Gender:");
    gender.setFont(new Font("Times New Roman", Font.BOLD, 31));
    gender.setBounds(670, 200, 150, 100);
    gender.setForeground(Color.BLACK);
    add(gender);

    male= new JRadioButton("Male");
    male.setFont(new Font("Times New Roman", Font.BOLD, 33));
    male.setBounds(0, 0, 170, 50);
    male.setForeground(Color.BLACK);

    female = new JRadioButton("Female");
    female.setFont(new Font("Times New Roman", Font.BOLD, 33));
    female.setBounds(180, 0, 150, 50);
    female.setForeground(Color.BLACK);

    bg2 = new ButtonGroup();
    bg2.add(male);
    bg2.add(female);

    panel2 = new JPanel();
    panel2.setLayout(null);
    panel2.add(male);
    panel2.add(female);
    //panel2.setBackground(new Color(158,143,178));
    panel2.setBounds(800, 225, 350, 50); // Adjust the size and position as needed
    add(panel2);

    img1=new JLabel();
    img1.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/login.png"));
    img1.setBounds(37, 75, 640, 480);
    add(img1);   
    
    male.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            img1.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/male.png"));
            img1.setBounds(50, 70, 640, 480);
        }
    });

    female.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
            {
        img1.setIcon(new ImageIcon("/Users/neha_admin/Desktop/pics/female5.png"));
         img1.setBounds(40, 70, 640, 480);
            }
    });
      
    //radiobutton 1
    
    lang= new JLabel("Which lang do you choose for the quiz:");
    lang.setFont(new Font("Times New Roman", Font.BOLD, 31));
    lang.setBounds(260, 400, 650, 100);
    lang.setForeground(Color.BLACK);
    add(lang);
    
    r1=new JRadioButton("Java");
    r1.setBounds(795,430,100,40);
    r1.setFont(new Font("Times New Roman", Font.BOLD, 31));
    r1.setForeground(Color.BLACK);
    add(r1);
    r1.addActionListener(this);
    
    r2=new JRadioButton("Python");
    r2.setBounds(920,430,160,40);
    r2.setFont(new Font("Times New Roman", Font.BOLD, 31));
    r2.setForeground(Color.BLACK);
    r2.addActionListener(this);
    add(r2);
   
    r3=new JRadioButton("C");
    r3.setBounds(1080,430,80,40);
    r3.setFont(new Font("Times New Roman", Font.BOLD, 31));
    r3.setForeground(Color.BLACK);
    r3.addActionListener(this);
    add(r3);
    
    bg= new ButtonGroup();
    bg.add(r1);
    bg.add(r2);
    bg.add(r3);
    
    
    rules= new JButton("Rules");
    rules.setBounds(440, 590, 150, 50);
    rules.setFont(new Font("Times New Roman", Font.BOLD, 30));
    rules.setForeground(Color.BLACK);       //foreground is button text
    rules.setBackground(Color.BLACK);       //gets overshadowed by bg colour but get outline
    rules.setToolTipText("RULES");
    rules.addActionListener(this);
    rules.setBorder(BorderFactory.createBevelBorder(0));
    add(rules);
    
    exit= new JButton("Exit");
    exit.setBounds(700, 590, 150, 50);
    exit.setFont(new Font("Cambria", Font.BOLD, 30));
    exit.setForeground(Color.BLACK);
    exit.setBackground(Color.BLACK);
    exit.setBorder(BorderFactory.createBevelBorder(0));
    exit.setToolTipText("EXIT");
    exit.addActionListener(this);
    add(exit);
    
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
   setLayout(null); 
   setVisible(true);
   setSize(1220,750);
   setLocation(110,50);
    
    panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
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
   
   public static String getSelectedChoice()    //to get java quiz when press java radiob
   {
        if (r1.isSelected()) 
        {
            return "Java";
        } 
        else if (r2.isSelected())
        {
            return "Python";
        } 
        else if (r3.isSelected()) 
        {
            return "C";
        }
        else
        {
            return "";
        }
   }   
  
   //on buttons
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()== rules)
       {
           setVisible(false);
           String name= tf1.getText();
           new Rules(name);
           
           //String selectedChoice = getSelectedChoice();
           //Rules.main(new String[] { selectedChoice });
           //dispose();      //dispose off login frame
       }
       
       else if(ae.getSource()== exit)
       {
           setVisible(false);
       }
   } 
  public static void main(String[] args) 
  {  
      SwingUtilities.invokeLater(new Runnable()
      
      {
         public void run() 
         { new Login(); }
         
      });  
    }               
 }     
                
            
   

