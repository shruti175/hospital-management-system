/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class  docpage  extends JFrame{
    JButton view,update,delete,back;
    ImageIcon iview,iupdate,idelete,ilogo,iback,iph,imail;
    Container co;
    JLabel hos,logo,ph,mail,tph,tmail,founder,title; 
    JPanel p1,p2;
    JSplitPane jsp;
    docpage(){
        
        co=getContentPane();
        p1=new JPanel(null);
        p2=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(400);
        
        title=new JLabel("Doctor Details");
        title.setForeground(Color.decode("#29aae1"));
        title.setFont(new Font("Arial Black",Font.BOLD,30));
        title.setBounds(300,10,800,50);
        
        ilogo=new ImageIcon("img\\admin\\logo.png");
        iview=new ImageIcon("img\\admin\\view.png");
        iupdate=new ImageIcon("img\\admin\\dupdate.png");
        idelete=new ImageIcon("img\\admin\\ddelete.jpg");
        iback=new ImageIcon("img\\diagnosis\\back.png");
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
        
        logo=new JLabel(ilogo);
        logo.setBounds(0,10,400,152);
        p1.add(logo);
        p2.add(title);
        
         view = new JButton(iview);
        iview.setImageObserver(view);
        view.setBounds(30,100,300, 300);
        view.setBackground(Color.gray);
        view.setFocusPainted(false);
        p2.add(view);
        
        update = new JButton(iupdate);
        iupdate.setImageObserver(update);
        update.setBounds(450,100, 300, 300);
        update.setBackground(Color.gray);
        update.setFocusPainted(false);
        p2.add(update);
        
        delete = new JButton(idelete);
        idelete.setImageObserver(delete);
        delete.setBounds( 240,420, 300, 300);
        delete.setBackground(Color.gray);
        delete.setFocusPainted(false);
        p2.add(delete);
       
        back=new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds( 10,10, 50, 50);
        back.setBackground(Color.decode("#ffffff"));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        p2.add(back);
      
        p1.setBackground(Color.decode("#29aae1"));
        p2.setBackground(Color.decode("#ffffff"));
        
        jsp.setLeftComponent(p1);
        jsp.setRightComponent(p2);
        
        setBounds(100, 100, 1250, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        view.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new Viewdoc();
                        setVisible(false);
                       
                }
                });
        
        update.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new docupdate();
                        setVisible(false);
                       
                }
                });
     
    
                delete.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        new Docdelete();
                        setVisible(false);
                       
                }
                });
        
                back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               adminpage rgf= new adminpage();
                setVisible(false);
            }
        });
    }   
    
    public static void main(String[] args) {
        new docpage();
    }
    
}   

