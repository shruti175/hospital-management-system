package Patient;

import homepage.homepage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PatientOption extends JFrame{
    JButton register,diagnosis,view,back;
    ImageIcon iregister,idiagnosis,iview,ilogo,iph,imail,iback;
    Container co;
    JLabel hos,founder,logo,ph,mail,tmail,tph; 
    JPanel p1,p2;
    JSplitPane jsp;
    public PatientOption(){
        
        co=getContentPane();
        p1=new JPanel(null);
        p2=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(400);
        
        iback = new ImageIcon("img\\diagnosis\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#29aae1"));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        p1.add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                new homepage();
                setVisible(false);
            }
        });
        
        iregister=new ImageIcon("img\\option\\register.png");
        ilogo=new ImageIcon("img\\option\\logo.png");
        idiagnosis=new ImageIcon("img\\option\\diagnosis.png");
        iview=new ImageIcon("img\\option\\view.png");
        iph=new ImageIcon("img\\option\\ph.png");
        imail=new ImageIcon("img\\option\\mail.png");
        
        logo=new JLabel(ilogo);
        logo.setBounds(0,10,400,152);
        p1.add(logo);
        
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
        
        register = new JButton(iregister);
        iregister.setImageObserver(register);
        register.setBounds(20,30, 350, 350);
        register.setBackground(Color.white);
        register.setFocusPainted(false);
        p2.add(register);
        
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientReg();
                setVisible(false);
            }
        });
        
        diagnosis = new JButton(idiagnosis);
        idiagnosis.setImageObserver(diagnosis);
        diagnosis.setBounds(400,30, 350, 350);
        diagnosis.setBackground(Color.white);
        diagnosis.setFocusPainted(false);
        p2.add(diagnosis);
        
        diagnosis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientDiagnosis();
                setVisible(false);
            }
        });
        
        view = new JButton(iview);
        iview.setImageObserver(view);
        view.setBounds(210,390,350, 350);
        view.setBackground(Color.white);
        view.setFocusPainted(false);
        p2.add(view);
        
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientView();
                setVisible(false);
            }
        });
        
        p1.setBackground(Color.decode("#29aae1"));
        p2.setBackground(Color.white);
        
        jsp.setLeftComponent(p1);
        jsp.setRightComponent(p2);
        
        setBounds(100, 100, 1250, 800);
        setVisible(true);
        setTitle("Patient Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        new PatientOption();
    }
    
}