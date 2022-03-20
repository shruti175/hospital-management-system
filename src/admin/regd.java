/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import Patient.PatientOption;
import com.toedter.calendar.JDateChooser;
import database.DatabaseOperation;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
public class regd extends Frame {
    Label doc_id,doc_name,l_mail,doc_mail,doc_phnno,doc_gender,doc_address,doc_qualification,doc_bloodgroup,doc_dateofjoin,npass,cpass,title;
    TextField tdoc_id,tdoc_name,tdoc_mail,tdoc_phno,tdoc_address,tdoc_dateofjoin,tdoc_qualification,tdoc_npass,tdoc_cpass;
    Checkbox male,female;
    CheckboxGroup gender; 
    Choice bloodgroup;
    JLabel ldoc;
    JDateChooser apt_date;
    ImageIcon iback;
    JButton back,submit,exit;
    String str_gen;
   regd(){
          
       iback = new ImageIcon("img\\diagnosis\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(20, 50, 75, 75);
        back.setBackground(Color.decode("#29aae1"));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new adminpage();
                setVisible(false);
            }
        });
        title = new Label("Doctor Registration Form");
        doc_id = new Label("ID");
        doc_name = new Label("Name");
        doc_gender = new Label("Gender");
        doc_qualification=new Label("Qualification");
         doc_dateofjoin=new Label("Date of joining");
        doc_mail = new Label("E-mail");
        doc_phnno=new Label("Mobile number");
        doc_bloodgroup=new Label("Blood Group");
        doc_address=new Label("Address");
        npass=new Label("Set new pasword");
        cpass=new Label("Confirm password");
        
        tdoc_id = new TextField();
        tdoc_name = new TextField();
        tdoc_qualification = new TextField();
        tdoc_mail = new TextField();
        tdoc_dateofjoin=new TextField();
        tdoc_mail=new TextField();
        tdoc_phno=new TextField();
        tdoc_address=new TextField();
        tdoc_npass=new TextField();
        tdoc_cpass=new TextField();
        
        gender = new CheckboxGroup();
        male = new Checkbox("Male",gender,false);
        female = new Checkbox("Female",gender,false);
        
        bloodgroup = new Choice();
        bloodgroup.add("---Select---");
        bloodgroup.add("O+");
        bloodgroup.add("O-");
        bloodgroup.add("A+");
        bloodgroup.add("A-");
        bloodgroup.add("B+");
        bloodgroup.add("B-");
        bloodgroup.add("AB+");
        bloodgroup.add("AB-");
        
        
        submit = new JButton("Register");
        exit = new JButton("Cancel");
        
        title.setFont(new Font( Font.SERIF,Font.BOLD, 23));
        doc_id.setFont(new Font( Font.DIALOG,Font.BOLD, 15));
        doc_name.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        doc_qualification.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        doc_mail.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        doc_gender.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        doc_phnno.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        doc_address.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        doc_bloodgroup.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        doc_dateofjoin.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        npass.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        cpass.setFont(new Font( Font.DIALOG, Font.BOLD, 15));
        
        title.setForeground(Color.white);
        doc_id.setForeground(Color.white);
        doc_name.setForeground(Color.white);
        doc_qualification.setForeground(Color.white);
        doc_mail.setForeground(Color.white);
        doc_gender.setForeground(Color.white);
       doc_phnno.setForeground(Color.white);
       doc_address.setForeground(Color.white);
         doc_bloodgroup.setForeground(Color.white);
         doc_dateofjoin.setForeground(Color.white);
           npass.setForeground(Color.white);
            cpass.setForeground(Color.white);
         
       
       title.setBounds(480,50,360,70);
        doc_id.setBounds(450,130,100,50);
        doc_name.setBounds(450,180,100,50);
        doc_gender.setBounds(450,230,100,50);
        doc_mail.setBounds(450,280,100,50);
        doc_phnno.setBounds(450,320,120,50);
        doc_bloodgroup.setBounds(450,360,100,50);
        doc_qualification.setBounds(450,400,100,50);
        doc_address.setBounds(450,440,100,50);
        doc_dateofjoin.setBounds(450,480,120,50);
        npass.setBounds(450,520,140,50);
        cpass.setBounds(450,560,140,50);
        
        
        
        tdoc_id.setFont(new Font( Font.DIALOG, Font.CENTER_BASELINE, 15));
        tdoc_name.setFont(new Font( Font.SERIF, Font.CENTER_BASELINE, 15));
        tdoc_qualification.setFont(new Font( Font.SERIF, Font.BOLD, 15));
        tdoc_phno.setFont(new Font( Font.SERIF, Font.BOLD, 15));
        bloodgroup.setFont(new Font( Font.SERIF, Font.BOLD, 15));
        
         tdoc_mail.setFont(new Font( Font.SERIF, Font.BOLD, 15));
         tdoc_address.setFont(new Font( Font.SERIF, Font.BOLD, 15));
         tdoc_npass.setFont(new Font( Font.SERIF, Font.BOLD, 15));
         tdoc_cpass.setFont(new Font( Font.SERIF, Font.BOLD, 15));
        
         tdoc_id.setBounds(650,140,225,25);
         tdoc_name.setBounds(650,190,225,25);
        
        
        male.setFont(new Font( Font.DIALOG, Font.CENTER_BASELINE, 15));
        female.setFont(new Font( Font.DIALOG, Font.CENTER_BASELINE, 15));
        male.setForeground(Color.white);
        female.setForeground(Color.white);
        male.setBounds(650, 235, 80, 30);
        female.setBounds(750, 235, 80, 30);
        
        tdoc_mail.setBounds(650,290,225,25);
        tdoc_phno.setBounds(650,330,225,30);
        bloodgroup.setBounds(650,370,225,25);
        tdoc_qualification.setBounds(650,410,225,25);
        tdoc_address.setBounds(650,450,225,25);
        tdoc_dateofjoin.setBounds(650,490,225,25);
         tdoc_npass.setBounds(650,535,225,25);
          tdoc_cpass.setBounds(650,575,225,25);
      
      
        
        submit.setForeground(Color.white);
        submit.setBackground(Color.GRAY);
        submit.setFont(new Font( Font.DIALOG, Font.ITALIC, 15));
        
        exit.setForeground(Color.white);
        exit.setBackground(Color.GRAY);
        exit.setFont(new Font( Font.DIALOG, Font.ITALIC, 15));
        
        submit.setBounds(500,630,100,25);
        exit.setBounds(690,630,80,25);
        
        
     
      apt_date=new JDateChooser();
     apt_date.setLocale(Locale.UK);
     apt_date.setDateFormatString("dd/MM/yyyy");
      apt_date.setBounds(650,490,225,25);
     
     
      
        add(title);
        add(doc_id);
        add(doc_name);
        add(doc_gender);
        add(doc_mail);
        add(doc_phnno);
        add(doc_bloodgroup);
        add(doc_qualification);
        add(doc_address);    
        add(doc_dateofjoin);  
        add(npass);
        add(cpass);
        add(apt_date);
        add(tdoc_id);
        add(tdoc_name);
        add(male);
        add(female);
        add(tdoc_mail);
        add(tdoc_phno);
        add(bloodgroup);
        add(tdoc_qualification);
        add(tdoc_address);    
      
        add(tdoc_npass);
        add(tdoc_cpass);
        add(submit);
        add(exit);
        
     
        
        setLayout(null);
        setBounds(100,100,1250,800);
        setTitle("Doctor  Registration");
        setBackground(Color.decode("#29aae1"));
        setVisible(true);
        
        male.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                    str_gen="Male";
            }
        });
        
        female.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                    str_gen="Female";
            }
        });
        
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String id=tdoc_id.getText();
                    String name=tdoc_name.getText();
                    String email=tdoc_mail.getText();
                    String phnno = tdoc_phno.getText();
                    String bgroup = bloodgroup.getSelectedItem();
                    String quali = tdoc_qualification.getText();
                    String address = tdoc_address.getText();
                    Date aptDate= apt_date.getDate();
                    String newpass= tdoc_npass.getText();
                    String cpass= tdoc_cpass.getText();
                    
                    
                   if(!Pattern.matches("[A-zA-z\\s]*", name)){
                        JOptionPane.showMessageDialog(submit,"Invalid Name");
                    }
                    else if(!Pattern.matches("^(.+)@(.+)$", email)){
                        JOptionPane.showMessageDialog(submit,"Invalid Email");
                    }
                     else if(!Pattern.matches("[789]{1}[0-9]{9}", phnno)){
                        JOptionPane.showMessageDialog(submit,"Invalid Mobile Number");
                    }
                    else if(str_gen==null){
                        JOptionPane.showMessageDialog(submit,"Please select your Gender");
                    }
                    else if(Pattern.matches("---Select---", bgroup)){
                        JOptionPane.showMessageDialog(submit,"Please select your Booldgroup");
                    }
                    else if(!Pattern.matches("[a-zA-z\\s,]*", quali)){
                        JOptionPane.showMessageDialog(submit,"Invalid Qualification");
                    }
                    else if(!Pattern.matches("^[#.0-9a-zA-Z\\s,-]+$", address)){
                        JOptionPane.showMessageDialog(submit,"Enter valid address");
                    }
             else if(!Pattern.matches("^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$",newpass))
             {
                   JOptionPane.showMessageDialog(submit,newpass);           
                           }
                     else if(!newpass.equals(cpass)){
                        JOptionPane.showMessageDialog(submit,"Please enter the same characters");
                    }
                    else{
                        Connection con=DatabaseOperation.getConnection();
                        String query="insert into doctor_details values(?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pdmt=con.prepareStatement(query);
                        pdmt.setString(1,id);
                        pdmt.setString(2,name);
                        pdmt.setString(3, email);
                        pdmt.setString(4,newpass);
                        pdmt.setString(5, phnno);
                        pdmt.setString(6,address);
                        pdmt.setString(7,quali);
                        pdmt.setString(8,str_gen);
                        pdmt.setString(9,bgroup);
                        pdmt.setString(10,new java.sql.Date(aptDate.getTime()).toString());
                        pdmt.executeUpdate();
                        JOptionPane.showMessageDialog(submit,"Registration Success!");
                        con.setAutoCommit(true);
                        System.exit(0);
                    }
                }
                catch(SQLIntegrityConstraintViolationException sq){
                    JOptionPane.showMessageDialog(submit, "You have already registered");
                }
                catch(Exception ex){
                        JOptionPane.showMessageDialog(submit, ex.toString());
                }
            }
        });
        
       exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               adminpage rgf= new adminpage();
                setVisible(false);
            }
        });
    

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
  // public void paint(Graphics g){
      
        //Toolkit t=Toolkit.getDefaultToolkit();  
       //doctor=t.getImage("C:\\Users\\Admin\\OneDrive\\Documents\\project\\doc1.jpg");
       //g.drawImage(doctor, 30,55,this);  
  // }
    public static void main(String[] args) {
        new regd();
    }

    
}
