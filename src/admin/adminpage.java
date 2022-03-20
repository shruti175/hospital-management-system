/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import homepage.homepage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class adminpage extends JFrame {

    JButton register,doctor,patient,room,back;
    ImageIcon iregister,idoctor,ipatient,irooms,ilogo,iback,iph,imail;
    Container co;
    JLabel hos,logo,founder,ph,mail,tph,tmail,title; 
    JPanel p1,p2;
    JSplitPane jsp;
    adminpage(){
        
        title=new JLabel("Admin Controls");
        title.setForeground(Color.decode("#29aae1"));
        title.setFont(new Font("Arial Black",Font.BOLD,30));
        title.setBounds(300,10,800,50);
        
        co=getContentPane();
        p1=new JPanel(null);
        p2=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(400);
        
        ilogo=new ImageIcon("img\\admin\\logo.png");
        iregister=new ImageIcon("img\\admin\\docregis.jpg");
        idoctor=new ImageIcon("img\\admin\\doctor.jpg");
        ipatient=new ImageIcon("img\\admin\\patient.jpg");
        irooms=new ImageIcon("img\\admin\\rooms.png");
        
        iback=new ImageIcon("img\\diagnosis\\back.png");
        back=new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds( 10,10, 50, 50);
        back.setBackground(Color.decode("#ffffff"));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        p2.add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new homepage();
                setVisible(false);
            }
        });
        
        iph=new ImageIcon("img\\option\\ph.png");
        imail=new ImageIcon("img\\option\\mail.png");
        
        hos=new JLabel("SKCET Memorial Hospital");
        founder=new JLabel("Coimbatore, Tamil Nadu");
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
        p2.add(title);
       
        logo=new JLabel(ilogo);
        logo.setBounds(0,10,400,152);
        p1.add(logo);
        
         register = new JButton(iregister);
        iregister.setImageObserver(register);
        register.setBounds(100,90,300, 300);
        register.setBackground(Color.gray);
        register.setFocusPainted(false);
        p2.add(register);
        
        doctor = new JButton(idoctor);
        idoctor.setImageObserver(doctor);
        doctor.setBounds(450,90, 300, 300);
        doctor.setFocusPainted(false);
        p2.add(doctor);
        
        patient = new JButton(ipatient);
        ipatient.setImageObserver(patient);
        patient.setBounds( 100,400, 300, 300);
        patient.setBackground(Color.gray);
        patient.setFocusPainted(false);
        p2.add(patient);
       
          room = new JButton(irooms);
        irooms.setImageObserver(room);
        room.setBounds( 450,400, 300, 300);
        room.setBackground(Color.gray);
        room.setFocusPainted(false);
        p2.add(room);
      
        p1.setBackground(Color.decode("#29aae1"));
        p2.setBackground(Color.decode("#ffffff"));
        
        jsp.setLeftComponent(p1);
        jsp.setRightComponent(p2);
        
        setBounds(100, 100, 1250, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          register.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new regd();
                        setVisible(false);
                       
                }
                });
            doctor.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new docpage();
                        setVisible(false);
                       
                }
                });
            patient.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new patpage();
                        setVisible(false);
                       
                }
                });
            
            room.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new Rooms();
                        setVisible(false);
                       
                }
                });
    }   
        
    
    public static void main(String[] args) {
        new adminpage();
    }
    
}   

