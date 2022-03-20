/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import database.DatabaseOperation;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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

public class patdelete  extends JFrame implements ActionListener{

 JLabel lbl_eid,head;
 JComboBox jcb_eid;
 JButton jbtn_submit,back;
 Container co;
 public patdelete(){
 this.setLocationRelativeTo(null);
 co=getContentPane();
 co.setLayout(null);

 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setTitle("DELETION FORM");

 head=new JLabel("Delete form");
 head.setBounds(780,200,360,70);
 head.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));

 
 lbl_eid=new JLabel("Patient id:");
 lbl_eid.setBounds(750, 280, 120, 25);
 lbl_eid.setFont(new java.awt.Font("Tahoma", 1, 22));

 jcb_eid=new JComboBox();
 jcb_eid.setBounds(890, 280, 100, 25);
 jcb_eid.setFont(new java.awt.Font("Tahoma", 1, 18));
 jcb_eid.setBackground(new java.awt.Color(255, 204, 204));
 
 jbtn_submit=new JButton("SUBMIT");
 jbtn_submit.addActionListener(this);
 jbtn_submit.setFont(new java.awt.Font("Tahoma", 1, 15));
 jbtn_submit.setBounds(810, 350, 100, 25);

           ImageIcon iback = new ImageIcon("img\\admin\\BACKF.jpg");
           back=new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds( 10,10, 50, 50);
        back.setBackground(Color.decode("#332E2E"));
        back.setFocusPainted(false);
        co.add(back);
  
        
        ImageIcon background = new ImageIcon("img\\admin\\patdel.jpg");
      JLabel  lbl_bg = new JLabel(" ",background, JLabel.CENTER);
        lbl_bg.setBounds(0, 0, 700, 780);
          add(lbl_bg);
       
 co.add(lbl_eid);
 co.add(jcb_eid);
 co.add(jbtn_submit);
 co.add(head);
 co.add(back);
 co.setBounds(100,100,500,600);
 
 co. setBackground(Color.decode("#FFA6C9"));
 lbl_eid.setForeground(Color.white);
head.setForeground(Color.white);
    back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
              new patpage();
                setVisible(false);
            }
        });
 try{
 jcb_eid.addItem("select");
 
Connection con=DatabaseOperation.getConnection();
 String query="select id from patient";
 PreparedStatement pstmt=con.prepareStatement(query);

 ResultSet rst=pstmt.executeQuery();
 while(rst.next()){
 jcb_eid.addItem(rst.getString("id"));
 }
 }
 catch(Exception ex){
 JOptionPane.showMessageDialog(this, " ERRORRR! "+ ex.toString());
 }
 setBounds(100,100,1250,800);
 setVisible(true);
 }
 public void actionPerformed(ActionEvent ae){
 Object obj_source=ae.getSource();
 if(obj_source==jbtn_submit){
 try{
 String id=jcb_eid.getSelectedItem().toString();
Connection con=DatabaseOperation.getConnection();
 String query="delete from patient where id=?";
 PreparedStatement pstmt=con.prepareStatement(query);

 pstmt.setString(1,id);
 pstmt.executeUpdate();
 con.setAutoCommit(true);
 JOptionPane.showMessageDialog(this, "Deleted Successfully");
 }
 catch(Exception ex){
 JOptionPane.showMessageDialog(this,"Error"+ ex.toString());
 }
 }
 }
 public static void main(String args[]){
      new patdelete();
     
 }
}