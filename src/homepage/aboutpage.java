/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepage;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class aboutpage extends JFrame {
    JButton jbtn_log,ad,doc,pat,phar;
    ImageIcon ilogo,iadmin,idoctor,ipatient,iphar,iph,imail;
    Container co;
    JLabel hos,logo,admin,doctor,patient,pharmacy,head,founder,mail,ph,tmail,tph; 
    JPanel p1,p2;
    JPanel pl1,pl2;
    JSplitPane jsp;
    aboutpage(){
 
         co=getContentPane();
        p1=new JPanel(null);
        p2=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(400);
        
        pl1=new JPanel(null);
        pl1.setBounds(0,0,820,100);
        pl1.setBackground(Color.white);

        

       
//pl1.setBackground(new java.awt.Color(204, 204, 204));
           p2.add(pl1);
         
           
    JButton home = new JButton("Home");  
    home.setBackground(Color.decode("#29aae1")); 
    home.setForeground(Color.white);
     home.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    home.setBounds(0, 380, 400, 50);  
   
    JButton about = new JButton("About");  
    about.setBackground(Color.decode("#29aae1"));  
    about.setForeground(Color.white);
    about.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    about.setBounds(0, 430, 400, 50);  
    
    
    JButton contact = new JButton("Contact us");  
    contact.setBackground(Color.decode("#29aae1"));  
    contact.setForeground(Color.white);
    contact.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    contact.setBounds(0, 480, 400, 50);  
     JLayeredPane pane = getLayeredPane();  
    //creating buttons  
  
    //adding buttons on pane  
    pane.add(contact);  
    pane.add(home);  
    pane.add(about);  

          head=new JLabel("About Us");
     head.setFont(new java.awt.Font("Tahoma", 1, 40));
       
        head.setBounds(300,30, 200, 35);// NOI18N
         head.setForeground(Color.decode("#29aae1"));
        p2.add(head);
         
        String text="<html><p> SKCET memorial hospital has emerged as South India’s foremost integrated healthcare services provider and has a robust presence across the healthcare ecosystem, including Hospitals, Pharmacies, Primary Care & Diagnostic Clinics and several retail health models. The Group also has Telemedicine facilities across several states, Health Insurance Services, International Projects Consultancy, Medical Colleges, MEd varsity for E-Learning, Colleges of Nursing and Hospital Management and a Research Foundation.\n" +
"The cornerstones of SKCET memorial’s legacy are its unstinting focus on clinical excellence, affordable costs, modern technology and forward-looking research & academics. SKCET memorial was among the first few hospitals in the India to leverage technology to facilitate seamless healthcare delivery.   \n" +
"As a responsible corporate citizen, SKCET memorial Hospitals takes the spirit of leadership well beyond business and has embraced the responsibility of keeping India healthy. Recognizing that Non Communicable Diseases (NCDs) are the greatest threat to the nation, SKCET memorial Hospitals is continuously educating people about preventive healthcare as the key to wellness. Likewise, the “Billion Hearts Beating Foundation” endeavors to keep Indians heart-healthy.\n" +
"SKCET memorial Hospitals has championed numerous social initiatives – to cite a few which assist underprivileged children – SACHi (Save a Child’s Heart Initiative) which screens and provides pediatric cardiac care for congenital heart diseases, SAHI (Society to Aid the Hearing Impaired) and the CURE Foundation focused on cancer care. To introduce population health into the Indian narrative, It aims to provide “holistic healthcare” for the entire community starting from birth, through one’s journey into childhood, adolescence, adulthood and old age.</p></html>";
    
        JLabel para=new JLabel(text);
         para.setForeground(Color.black);
       para.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       para.setBounds(0,150,820,500);
         p2.add(para);
        
        ilogo=new ImageIcon("img\\admin\\logo.png");
        logo=new JLabel(ilogo);
        logo.setBackground(Color.decode("#91eae4"));
   logo.setBounds(0,10,400,152);
        p1.add(logo);
       
        hos=new JLabel("SKCET Memorial Hospital");
        hos.setForeground(Color.white);
        hos.setFont(new Font("Arial Black",Font.BOLD,22));
        hos.setBounds(24,163,350,50);
         p1.add(hos);
     
         admin=new JLabel("ADMIN");
         admin.setForeground(Color.black);
        admin.setFont(new Font(Font.SERIF,Font.BOLD,20));
         admin.setBounds(180,0,250,100);
        
         doctor=new JLabel("DOCTOR");
         doctor.setForeground(Color.black);
        doctor.setFont(new Font(Font.SERIF,Font.BOLD,20));
       doctor.setBounds(520,0,250,100);
        
         patient=new JLabel("PATIENT");
         patient.setForeground(Color.black);
        patient.setFont(new Font(Font.SERIF,Font.BOLD,20));
       patient.setBounds(170,360,200,100);
         
         pharmacy=new JLabel("PHARMACY");
         pharmacy.setForeground(Color.black);
        pharmacy.setFont(new Font(Font.SERIF,Font.BOLD,20));
        pharmacy.setBounds(510,360,130,100);
        
        founder=new JLabel("Coimbatore, Tamil Nadu");
        iph=new ImageIcon("img\\option\\ph.png");
        imail=new ImageIcon("img\\option\\mail.png");
        ph=new JLabel(iph);
        mail=new JLabel(imail);
        tph=new JLabel("+91 9123456780");
        tmail=new JLabel("skcethospital@gmail.com");
        
        hos.setForeground(Color.white);
        hos.setFont(new Font("Arial Black",Font.BOLD,22));
        
        founder.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        founder.setForeground(Color.white);
        
        tph.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        tph.setForeground(Color.white);
        
        tmail.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        tmail.setForeground(Color.white);
        
        hos.setBounds(28,163,350,50);
        founder.setBounds(110,195,350,50);
        ph.setBounds(80,275,20,20);
        tph.setBounds(120,275,180,20);
        mail.setBounds(80,310,20,20);
        tmail.setBounds(120,310,180,20);
        
        p1.add(hos);
        p1.add(founder);
        p1.add(ph);
        p1.add(tph);
        p1.add(mail);
        p1.add(tmail);
  
          home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
              new homepage();
                setVisible(false);
            }
        });   
    
         contact.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new contactpage();
                        setVisible(false);
                       
                }
                });
    
        
         p1.setBackground( Color.decode("#29aae1"));
        p2.setBackground(Color.decode("#ffdde1"));
      jsp.setTopComponent(p1);
        jsp.setBottomComponent(p2);
         p2.add(pl1);
        setBounds(100,100,1250, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args) {
        new aboutpage();
    }
    
}
