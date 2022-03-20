/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;


import Doctor.LoginForm;
import Doctor.Patdiag;
import Doctor.Update;
import Doctor.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Page extends JFrame{
   JLabel lbl_patient,lbl_view,lbl_update;
    JButton jbtn_view,jbtn_update,jbtn_patient,back;
    Container co;
    ImageIcon iback;
    Page(String int_id){
       
        co=getContentPane();
        setTitle("Page");
        co.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         
        iback = new ImageIcon("img\\doctor\\back.png");
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
            
              new LoginForm();
                setVisible(false);
            }
        });
        
        lbl_view=new JLabel("VIEW");
        lbl_view.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_view.setFont(new Font("High Tower Text",Font.BOLD,20));
        lbl_view.setForeground(Color.decode("#4C96F3"));
        lbl_update=new JLabel("UPDATE");
        lbl_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_update.setFont(new Font("High Tower Text",Font.BOLD,20));
        lbl_update.setForeground(Color.decode("#4B4DF7"));
        lbl_patient=new JLabel("PATIENT DIAGNOSIS");
        lbl_patient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_patient.setFont(new Font("High Tower Text",Font.BOLD,20));
        lbl_patient.setForeground(Color.decode("#0057DB"));
        
        
        co.setBackground(Color.white);
      
        
        
        ImageIcon img1=new ImageIcon("img\\doctor\\view.jpg");
        jbtn_view=new JButton("VIEW",img1);
        
        ImageIcon img2=new ImageIcon("img\\doctor\\1.png");
        jbtn_update=new JButton("UPDATE",img2);
        
       ImageIcon img3=new ImageIcon("img\\doctor\\patient.jpg");
        jbtn_patient=new JButton("Appointments",img3);
        
        lbl_update.setBounds(580,30, 100, 100);
        lbl_view.setBounds(150,30,300,100);
        lbl_patient.setBounds(920,30,300,100);
        jbtn_view.setBounds(10,100,400,600);
       jbtn_update.setBounds(420,100,400,600);
        jbtn_patient.setBounds(830,100,400,600);
        
        co.add(lbl_view);
        co.add(lbl_update);
        co.add(lbl_patient);
        co.add(jbtn_view);
        co.add(jbtn_update);
        co.add(jbtn_patient);
        
        
        setBounds(100,100,1250,800);
        super.setResizable(false);
        setVisible(true);
        
        
        lbl_patient.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                new Appointments(int_id);
                dispose();
                
            } 
        });
        lbl_view.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                new View(int_id);
                dispose();
                
            } 
        });
        lbl_update.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                new Update(int_id);
                dispose();
                
            } 
        });
        
        jbtn_view.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                new View(int_id);
                setVisible(false);
            }
        });
        jbtn_update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Update(int_id);
                setVisible(false);
            }
        });
        jbtn_patient.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Appointments(int_id);
                setVisible(false);
            }
        });
        
        
    }
     
    
}
