/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/*import database.DatabaseOperation;
import homepage.homepage;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
public class Admin extends javax.swing.JFrame{
     
     Graphics g;
     Container co;
     Label u_name,p_word,create,head;
     JLabel log;
     TextField t_user,t_pass;
     ImageIcon ilog;
     JPanel p1,p2;
     JSplitPane jsp;
     Button login,cancel;
     public Admin(){
         
         co=getContentPane();
         co.setLayout(null);
         co. setBounds(130,110,500,600);
         p1=new JPanel(null);
        p2=new JPanel(null);
        jsp=new JSplitPane();
        co.add(jsp);
        jsp.setDividerLocation(400);
         setTitle("Doctor Login");
         
 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         setLayout(null);
         co.setBackground(Color.decode("#003333"));
         
         head=new Label("Login Form");
         head.setFont(new java.awt.Font("Tahoma", 1, 32));
         head.setBounds(180,20, 220, 35);// NOI18N
         head.setForeground(new java.awt.Color(51,153,255));
         
         u_name=new Label("Username :");
         u_name.setFont(new java.awt.Font("Tahoma", 1, 22));
         u_name.setBounds(100,180, 120, 35);// NOI18N
         u_name.setForeground(new java.awt.Color(51,153,255));
         
         t_user=new TextField();
         t_user.setBounds(300, 180, 250,35 );
         
         p_word=new Label("Password :");
         p_word.setFont(new java.awt.Font("Tahoma", 1, 22));
         p_word.setBounds(100,250,150,35);
         p_word.setForeground(new java.awt.Color(51,153,255));
         
         t_pass=new TextField();
         t_pass.setEchoChar('*');
         t_pass .setBounds(300,250,250,35);
         
   
         create=new Label("Click here to create  a new account");
       create.setFont(new java.awt.Font("Tahoma", 1, 20)); 
         create.setForeground(new java.awt.Color(51,153,255));
         create.setBounds(100,450,400,30);
        
         
         login=new Button("Login"); 
         login.setFont(new java.awt.Font("Tahoma", 1, 22)); 
         login.setBounds(380,350,100,55);
         login.setBackground(new java.awt.Color(51, 0, 205));
         login.setForeground(new java.awt.Color(255, 255, 255));
         
         cancel=new Button("Cancel");
         cancel.setFont(new java.awt.Font("Tahoma", 1, 22)); 
         cancel.setBounds(100,350,100,55);
         cancel.setBackground(new java.awt.Color(255, 51, 51));
         cancel.setForeground(new java.awt.Color(255, 255, 255));
         
         p2.setBounds(600,150,500,400);
         add(p2);
         p2.setBackground(Color.black);
          ilog=new ImageIcon("img\\admin\\img2.jpg");
          log=new JLabel(ilog);
          log.setBounds(0,0,500,400);
          p2.add(log);
           
          
         add(head);
         add(u_name);
         add(p_word);
         add(create);
         add(t_user);
         add(t_pass);
         add(login);
         add(cancel);
         
         setBounds(100,100,1250,800);
         setBackground(Color.pink);
         setResizable(false);
         setVisible(true);
         
         login.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String uname=t_user.getText();
                        String pass=t_pass.getText();

                        insert(uname, pass);
                    }
                });
         
          login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new adminpage();
                setVisible(false);
            }
        });
         
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 homepage rgf= new homepage();
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
     
      
    public static void main(String args[]){
     
        new Admin();
        
    }

    public void insert(String uname,String pass){

  		try
  		{
                       if(!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", uname)){
                        JOptionPane.showMessageDialog(login,"Invalid email");
                    }
                        else if(!Pattern.matches("^(?=.[a-z])(?=.[A-Z])(?=.[0-9])(?=.[@!$#%&*?])(?=\\S+$).{8,20}$", pass)){
                        JOptionPane.showMessageDialog(login,"Set valid password");
                    }
                        else{
   			
   			Connection con=DatabaseOperation.getConnection();
   			Statement  st=con.createStatement();

			String query="insert into doctor_details values('"+uname+"','"+pass+"')";

   			st.executeUpdate(query);
   			con.close();

   			JOptionPane.showMessageDialog(null,"Success!");
  		}
                }
  		catch(Exception e)
  		{
   			JOptionPane.showMessageDialog(null,"  Exception   -->"+e);
  		}
        }

}*/
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

public class Admin extends JFrame implements ActionListener,ItemListener{
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
    public Admin(){
        setTitle("Login Form");
        co=getContentPane();
        //co.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg=new ImageIcon("img\\admin\\adfront.jpg");
        submit=new ImageIcon("img\\doctor\\submit.png");
        clear=new ImageIcon("img\\doctor\\clear2.png");
        
         iback = new ImageIcon("img\\doctor\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#ebf2fe"));
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
        
        
        
        
        
        
        jp_panel2.setBackground(Color.decode("#ebf2fe"));
        jp_panel1.setBackground(Color.decode("#ebf2fe"));
        
        
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
        new Admin();
        
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
                PreparedStatement st=con.prepareStatement("Select email,password from admin where email=? and password=?");
                
                st.setString(1, str_user);
                st.setString(2, str_pswrd);
                ResultSet rs=st.executeQuery();
                if(rs.next()) {
                   //int_id=rs.getString("id");
                    JOptionPane.showMessageDialog(null,"Successfully logged in");
                    new  adminpage();
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