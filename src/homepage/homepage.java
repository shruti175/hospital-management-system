/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepage;

import admin.Admin;
import Doctor.LoginForm;
import Pharmacy.Pharmacy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import Patient.PatientOption;

public class homepage extends JFrame {
    JButton jbtn_log,ad,doc,pat,phar;
    ImageIcon ilogo,iadmin,idoctor,ipatient,iphar,iph,imail;
    Container co;
    JLabel hos,logo,ph,mail,tmail,tph,founder; 
    JPanel p1,p2,p3;
    JSplitPane jsp;
    public homepage(){
        
       
         co=getContentPane();
        
        p1=new JPanel(null);
        p2=new JPanel(null);
        p3=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(400);
        
           
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
        
        
        iadmin=new ImageIcon("img\\admin\\admin.jpg");
         ad = new JButton(iadmin);
        iadmin.setImageObserver(ad);
        ad.setBounds(0,05,400, 370);
        ad.setFocusPainted(false);
        p2.add(ad);
        
        idoctor=new ImageIcon("img\\admin\\doctor.png");
        doc = new JButton(idoctor);;
        doc.setBounds(400,05, 400, 370);
        doc.setBackground(Color.red);
        doc.setFocusPainted(false);
        p2.add(doc);
        
        ipatient=new ImageIcon("img\\admin\\patient1.jpg");
        pat = new JButton(ipatient);
        pat.setBounds( 0,375, 400,370);
        pat.setBackground(Color.red);
        pat.setFocusPainted(false);
        p2.add(pat);
       
        iphar=new ImageIcon("img\\admin\\pharmacy.png");
          phar = new JButton(iphar);
        iphar.setImageObserver(phar);
        phar.setBounds( 400,375, 400, 370);
        phar.setBackground(Color.red);
        phar.setFocusPainted(false);
        p2.add(phar);
        

   
   ad.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new Admin();
                        setVisible(false);
                       
                }
                });
   
   doc.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new LoginForm();
                        setVisible(false);
                       
                }
                });
   pat.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new PatientOption();
                        setVisible(false);
                       
                }
                });
  phar.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new Pharmacy();
                        setVisible(false);
                       
                }
                });
       
         about.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new aboutpage();
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
        p2.setBackground(Color.decode("#ffffff"));
        
       jsp.setTopComponent(p1);
        jsp.setBottomComponent(p2);
        
        setBounds(100, 100, 1250, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        new homepage();
    }
    
}
