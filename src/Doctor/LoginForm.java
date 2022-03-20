/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import Doctor.Page;
import database.DatabaseOperation;
import homepage.homepage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class LoginForm extends JFrame implements ActionListener,ItemListener{
    JLabel lbl_user,lbl_password,lbl_heading,lbl_background,lbl_text2,lbg;
    JTextField txt_user;
    JPasswordField jpf_password;
    JButton jbtn_submit,jbtn_clear,back;
    Container co;
    JPanel jp_panel1,jp_panel2;
    JCheckBox chb_showpassword;
    JSplitPane jsp;
    ImageIcon bg,submit,clear;
    String int_id;
    ImageIcon iback;
    public LoginForm(){
        setTitle("Login Form");
        co=getContentPane();
        //co.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg=new ImageIcon("img\\doctor\\Login.jpg");
        submit=new ImageIcon("img\\doctor\\submit.png");
        clear=new ImageIcon("img\\doctor\\clear2.png");
        
         iback = new ImageIcon("img\\doctor\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#D1EFFE"));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                new homepage();
                setVisible(false);
            }
        });
        
        lbg=new JLabel("",bg,JLabel.CENTER);
        lbg.setBounds(0,0,600,800);
        
       
        
        
        jp_panel1=new JPanel(null);
        jp_panel2=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(600);
        
      
        lbl_heading=new JLabel("Login Form");
        lbl_heading.setFont(new Font("Algerian", Font.BOLD, 25));
        lbl_heading.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_user=new JLabel("Username");
        lbl_user.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_password=new JLabel("Password");
        lbl_password.setFont(new Font("Bodoni MT",Font.BOLD,20));
        txt_user=new JTextField();
        jpf_password=new JPasswordField();
        jpf_password.setEchoChar('*');
        
  
        
        lbl_text2=new JLabel("To continue, Sign in to your account");
        lbl_text2.setFont(new Font("High Tower Text",Font.ITALIC,20));
        lbl_text2.setHorizontalAlignment(SwingConstants.CENTER);
        
         
        
        jbtn_submit=new JButton(submit);
        jbtn_clear=new JButton(clear);
        
        txt_user.setFont(new Font("Bodoni MT",Font.ITALIC,20));
        jpf_password.setFont(new Font("Bodoni MT",Font.ITALIC,20));
        
        chb_showpassword=new JCheckBox("Show Password");
        chb_showpassword.setFont(new Font("Bodoni MT",Font.BOLD,17));
        
        
        
        
        
        
        jp_panel2.setBackground(Color.decode("#D1EFFE"));
        jp_panel1.setBackground(Color.decode("#D1EFFE"));
        
        
         lbl_text2.setBounds(150,250,300,25);
        
        lbl_heading.setBounds(200,200,200,25);
        lbl_user.setBounds(100,300,200,25);
  	lbl_password.setBounds(100,350,100,25);
        
       

  	txt_user.setBounds(250,300,150,25);
        
  	jpf_password.setBounds(250,350,150,25);
        chb_showpassword.setBounds(250,390,150,25);

  	jbtn_submit.setBounds(200,450,80,40);
        jbtn_clear.setBounds(350,450,80,40);
        
        jbtn_submit.addActionListener(this);
        jbtn_clear.addActionListener(this);
        chb_showpassword.addItemListener(this);
        
        
     
        jp_panel2.add(lbl_text2);
        jp_panel1.add(lbg);

        
        jp_panel2.add(lbl_heading);
        jp_panel2.add(lbl_user);
        jp_panel2.add(lbl_password);
        jp_panel2.add(txt_user);
        jp_panel2.add(jpf_password);
        jp_panel2.add(chb_showpassword);
        jp_panel2.add(jbtn_submit);
        jp_panel2.add(jbtn_clear);
        
        
        jsp.setLeftComponent(jp_panel1);
        jsp.setRightComponent(jp_panel2);
        
        
        setBounds(100,100,1250,800);
        setVisible(true);
        


    }

    public static void main(String[] args) {
        new LoginForm();
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){
         if (e.getStateChange() == ItemEvent.SELECTED) {
            jpf_password.setEchoChar((char)0);
        } else {
             jpf_password.setEchoChar('*');
        }
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        String str_user=txt_user.getText();
	String str_pswrd=jpf_password.getText();
        
        Object obj_source=e.getSource();
        if(obj_source==jbtn_submit ){  
            try {
                Connection con=DatabaseOperation.getConnection();
                PreparedStatement st=con.prepareStatement("Select id,email,password from doctor_details where email=? and password=?");
                
                st.setString(1, str_user);
                st.setString(2, str_pswrd);
                ResultSet rs=st.executeQuery();
                if(rs.next()) {
                   int_id=rs.getString("id");
                    JOptionPane.showMessageDialog(null,"Successfully logged in");
                    new Page(int_id);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Enter the username or password correctly");
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
            } 
        }
        if(obj_source==jbtn_clear){
            String def="";
            txt_user.setText(def);
            jpf_password.setText(def);
        }
        
    }
   
}