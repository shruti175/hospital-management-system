/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import Doctor.LoginForm;
import database.DatabaseOperation;
import java.awt.BorderLayout;
import java.awt.Color;
   import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Docdelete extends JFrame implements ActionListener{

    JLabel lbl_eid,title,lbl_bg;
    JComboBox jcb_eid;
    ImageIcon iback;
    JButton jbtn_submit,jbtn_back,back;
    ImageIcon background;
    JPanel a;
    Container co;

    public Docdelete(){
               this.setLocationRelativeTo(null);
        co=getContentPane();
        co.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setTitle("DELETION FORM");
          
          iback = new ImageIcon("img\\diagnosis\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.white);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
             new docpage();
                setVisible(false);
            }
        });
     
        lbl_eid=new JLabel("ID");
        title=new JLabel("DOCTOR DELETION FORM");
        jcb_eid=new JComboBox();
        jbtn_submit=new JButton("SUBMIT");
        
        jbtn_submit.addActionListener(this);
        
       
        
        title.setBounds(740,200,360,70);
        lbl_eid.setBounds(780,280,100,25);
        jcb_eid.setBounds(890, 280, 100, 25);
        jbtn_submit.setBounds(810, 350, 100, 25);
   
        
        background = new ImageIcon("img\\admin\\del.jpg");
        lbl_bg = new JLabel(" ",background, JLabel.CENTER);
        lbl_bg.setBounds(0, 0, 700, 780);
          add(lbl_bg);
       
          
        co.add(title);
        co.add(lbl_eid);
        co.add(jcb_eid);
        co.add(jbtn_submit);
       
      
        
        co. setBackground(Color.decode("#CC8DBD"));

	
          title.setForeground(Color.white);
          lbl_eid.setForeground(Color.white);
          jcb_eid.setBackground(Color.WHITE);
          
          title.setFont(new Font( Font.DIALOG,Font.BOLD, 23));
           lbl_eid.setFont(new Font( Font.SERIF,Font.BOLD, 15));
            try{
                   jcb_eid.addItem("0");
                   Connection con=DatabaseOperation.getConnection();
                   String query="select id from doctor_details";
                   PreparedStatement pstmt=con.prepareStatement(query);

                   ResultSet rst=pstmt.executeQuery();

                   while(rst.next()){

                       jcb_eid.addItem(rst.getInt("id"));
                   }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, " ERRORRR! "+ ex.toString());
            }

         setLayout(null);
        setBounds(100,100,1250, 800);
        setVisible(true);
    

    
    }
    public void actionPerformed(ActionEvent ae){

        Object obj_source=ae.getSource();

        if(obj_source==jbtn_submit){

            try{
                int    eid=Integer.parseInt(jcb_eid.getSelectedItem().toString());

                   Connection con=DatabaseOperation.getConnection();
                   String query="delete from doctor_details where id=?";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   pstmt.setInt(1,eid);
                   pstmt.executeUpdate();
                   con.setAutoCommit(true);
                   JOptionPane.showMessageDialog(this, "Deleted Successfully");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error"+ ex.toString());
            }

        }
    }
  
        
      //public void paint(Graphics g){
        //Toolkit t=Toolkit.getDefaultToolkit();  
       //doc=t.getImage("C:\\Users\\Admin\\OneDrive\\Documents\\project\\doc1.jpg");
       //g.drawImage(doc, 30,55,this);  
  // }

    public static void main(String args[]){
        new Docdelete();
}
} 


