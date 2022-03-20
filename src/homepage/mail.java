/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message.RecipientType;
import javax.swing.*;

  

public class mail extends JFrame {
    JButton Submit,home,about,contact;
    ImageIcon ilogo;
    Container co;
    JTextField m_from,m_to,m_subject,m_message;
   
    JLabel hos,logo,From,To,Subject,Message,title; 
    JPanel p1,p2,p3,pa1,pa2,pa3;
    JSplitPane jsp;
    mail(){
        
       
        co=getContentPane();
        p1=new JPanel(null);
        p2=new JPanel(null);
        p3=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(400);
        
        p3.setBounds(0,400,400,400);
          p3.setBackground(Color.decode("#333333"));
           p1.add(p3);
           
    JButton home = new JButton("Home");  
    home.setBackground(Color.decode("#333333")); 
    home.setForeground(Color.white);
     home.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    home.setBounds(0, 280, 400, 50);  
   
    JButton about = new JButton("About");  
    about.setBackground(Color.decode("#333333"));  
    about.setForeground(Color.white);
    about.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    about.setBounds(0, 330, 400, 50);  
    
    
    JButton contact = new JButton("Contact us");  
    contact.setBackground(Color.decode("#333333"));  
    contact.setForeground(Color.white);
    contact.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    contact.setBounds(0, 380, 400, 50);  
     JLayeredPane pane = getLayeredPane();  
    //creating buttons  
  
    //adding buttons on pane  
    pane.add(contact);  
    pane.add(home);  
    pane.add(about);  

        ilogo=new ImageIcon("project\\logo.jpg");
        logo=new JLabel(ilogo);
        logo.setBackground(Color.decode("#DC050C"));
   logo.setBounds(0,10,400,152);
        p1.add(logo);
       
        hos=new JLabel("SKCET Memorial Hospital");
        hos.setForeground(Color.white);
        hos.setFont(new Font("Arial Black",Font.BOLD,22));
        hos.setBounds(24,163,350,50);
         p1.add(hos);
     
        From = new JLabel("From");
        To = new JLabel("To");
        Subject = new JLabel("Subject");
        Message = new JLabel("Message");
        Submit = new JButton("Submit");
        
        m_from = new JTextField();
        m_to = new JTextField();
        m_subject = new JTextField();
        m_message = new JTextField();
        
        m_to.setText("skcethospital@gmail.com");
        
        title=new JLabel("Send us your query");
        title.setFont(new Font( Font.DIALOG,Font.BOLD, 22));
         title.setForeground(Color.white);
         title.setBounds(190,60,250,50);
        m_from.setFont(new Font( Font.DIALOG,Font.BOLD, 15));
        m_to.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        m_subject.setFont(new Font ( Font.DIALOG, Font.BOLD, 15));
        m_message.setFont(new Font ( Font.DIALOG, Font.BOLD, 15));
      
        
        
        
        m_from.setForeground(Color.black);
        m_to.setForeground(Color.black);
        m_subject.setForeground(Color.black);
        m_message.setForeground(Color.black);
        
        From.setForeground(Color.white);
        To.setForeground(Color.white);
        Subject.setForeground(Color.white);
        Message.setForeground(Color.white);
        
        
        m_from.setBounds(200,130,300,30);
        m_to.setBounds(200,180,300,30);
        m_subject.setBounds(200,240,300,30);
        m_message.setBounds(200,290,300,100);
        
        
        From.setBounds(120,140,180,25);
        To.setBounds(120,190,180,25);
        Subject.setBounds(120,240,280,25);
        Message.setBounds(120,290,625,25);
        
        
        
        From.setFont(new Font( Font.SERIF, Font.CENTER_BASELINE, 15));
        To.setFont(new Font( Font.SERIF, Font.CENTER_BASELINE, 15));
        Subject.setFont(new Font( Font.SERIF, Font.CENTER_BASELINE, 15));
        Message.setFont(new Font( Font.SERIF, Font.CENTER_BASELINE, 15));
                        
       
        Submit.setForeground(Color.white);
        Submit.setBackground(Color.gray);
        Submit.setFont(new Font( Font.DIALOG, Font.ITALIC, 15));
        
        
        
        Submit.setBounds(150,490,90,25);
        
        
        
       p2.add(title);
        p2.add(From);
        p2.add(To);
        p2.add(Subject);
        p2.add(Message);
      
        p2.add(m_from);
        p2.add(m_to);
        p2.add(m_subject);
        p2.add(m_message);
        
        
        
       p2.add(Submit);
       p1.setBackground( Color.decode("#DC050C"));
        p2.setBackground(Color.decode("#333333"));
        
       jsp.setTopComponent(p1);
        jsp.setBottomComponent(p2);
        
        setBounds(100,100,1250, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
        
      private void submit(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String FromEmail = m_to.getText();
        String ToEmail = m_from.getText();
        String ToEmailPassword = "ABCD1234!"; //your email password
        String Subjects = m_subject.getText(); 
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session = Session.getDefaultInstance( properties, new javax.mail.Authenticator() {
            @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(ToEmail, ToEmailPassword);
           }
        });
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ToEmail));
            
            message.addRecipient(RecipientType.TO, new InternetAddress(FromEmail));
            message.setSubject(Subjects);
            message.setText(m_message.getText());
            
            Transport.send(message);
            
            
        } catch(Exception ex) {
            System.out.println(""+ex);
        }
     
        
    home.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new aboutpage();
                        setVisible(false);
                       
                }
                });
    
         about.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new aboutpage();
                        setVisible(false);
                       
                }
                });
    
        contact.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new aboutpage();
                        setVisible(false);
                       
                }
                });
}
            
        
        
    
    public static void main(String[] args) {
        new mail();
    }
  }
