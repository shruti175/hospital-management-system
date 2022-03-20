/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import database.DatabaseOperation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class View extends JFrame{
    JLabel lbl_heading,lbl_name,lbl_id,lbl_email,lbl_password,lbl_mobile,lbl_address,lbl_qualification,lbl_gender,lbl_blood_group,lbl_dateofjoining;
    TextField txt_name,txt_id,txt_email,txt_password,txt_mobile,txt_address,txt_qualification,txt_gender,txt_blood_group,txt_dateofjoining;
    Container co;
    JButton jbtn_submit,back;
    ImageIcon iback;
    
    public View(String int_id){
        co=getContentPane();
        co.setLayout(null);
        setTitle("VIEW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         iback = new ImageIcon("img\\doctor\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#E0EBEA"));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
         back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
              new Page(int_id);
                setVisible(false);
            }
        });
        
       lbl_heading=new JLabel("VIEW THE DETAILS");
        lbl_heading.setFont(new Font("Algerian",Font.BOLD,30));
        lbl_id=new JLabel("ID");
        lbl_id.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_name=new JLabel("Name");
        lbl_name.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_email=new JLabel("Email");
        lbl_email.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_password=new JLabel("Password");
        lbl_password.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_mobile=new JLabel("Mobile");
        lbl_mobile.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_address=new JLabel("Address");
        lbl_address.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_qualification=new JLabel("Qualificattion");
        lbl_qualification.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_gender=new JLabel("Gender");
        lbl_gender.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_blood_group=new JLabel("Blood Group");
        lbl_blood_group.setFont(new Font("Bodoni MT",Font.BOLD,20));
        lbl_dateofjoining=new JLabel("Date Of Joining");
        lbl_dateofjoining.setFont(new Font("Bodoni MT",Font.BOLD,20));
        
        
        txt_id=new TextField();
        txt_name=new TextField();
        txt_email=new TextField();
        txt_password=new TextField();
        txt_mobile=new TextField();
        txt_address=new TextField();
        txt_qualification=new TextField();
        txt_gender=new TextField();
        txt_blood_group=new TextField();
        txt_dateofjoining=new TextField();
        
        
        
        lbl_heading.setBounds(400,50,350,25);
         lbl_id.setBounds(350, 100, 120, 25);
         lbl_name.setBounds(350, 150, 120, 25);
         lbl_email.setBounds(350, 200, 120, 25);
         lbl_password.setBounds(350,250,120,25);
         lbl_mobile.setBounds(350,300,120,25);
         lbl_address.setBounds(350,350,120,25);
         lbl_qualification.setBounds(350,400,120,25);
         lbl_gender.setBounds(350,450,120,25);
         lbl_blood_group.setBounds(350,500,120,25);
         lbl_dateofjoining.setBounds(350,550, 150, 25);
         
          txt_id.setBounds(650, 100, 150, 25);
         txt_id.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_name.setBounds(650, 150, 150, 25);
         txt_name.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_email.setBounds(650, 200, 150, 25);
         txt_email.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_password.setBounds(650,250,150,25);
         txt_password.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_mobile.setBounds(650,300,150,25);
         txt_mobile.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_address.setBounds(650,350,150,25);
         txt_address.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_qualification.setBounds(650,400,150,25);
         txt_qualification.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_gender.setBounds(650,450,150,25);
         txt_gender.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_blood_group.setBounds(650,500,150,25);
         txt_blood_group.setFont(new Font("High Tower Text",Font.ITALIC,15));
         txt_dateofjoining.setBounds(650,550, 150, 25);
         txt_dateofjoining.setFont(new Font("High Tower Text",Font.ITALIC,15));
         
         
         co.setBackground(Color.decode("#E0EBEA"));
         
        
        co.add(lbl_heading);
        co.add(lbl_id);
        co.add(lbl_name);
        co.add(lbl_email);
        co.add(lbl_password);
        co.add(lbl_address);
        co.add(lbl_qualification);
        co.add(lbl_gender);
        co.add(lbl_blood_group);
        co.add(lbl_dateofjoining);
        
        co.add(txt_id);
        co.add(txt_name);
        co.add(txt_email);
        co.add(txt_password);
        co.add(txt_address);
        co.add(txt_qualification);
        co.add(txt_gender);
        co.add(txt_blood_group);
        co.add(txt_dateofjoining);
        
        try{
            txt_id.setEditable(false);
            txt_name.setEditable(false);
            txt_email.setEditable(false);
            txt_password.setEditable(false);
            txt_address.setEditable(false);
            txt_qualification.setEditable(false);
            txt_gender.setEditable(false);
            txt_blood_group.setEditable(false);
            txt_dateofjoining.setEditable(false);
                        
                        // JOptionPane.showMessageDialog(this," "+int_eid);

                        Connection con=DatabaseOperation.getConnection();

                         
                        String query="select id,name,email,password,mobile,address,qualification,gender,bloodgroup,dateofjoining from doctor_details where id=?";
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1,int_id);
                        ResultSet rst=pstmt.executeQuery();
                        if(rst.next()){
                        txt_id.setText(rst.getString("id"));
                        //txt_id.setText("int_id");
                        //txt_id.setText("id");
                        txt_name.setText(rst.getString("name"));
                        txt_email.setText(rst.getString("email"));
                        txt_password.setText(rst.getString("password"));
                        txt_mobile.setText(rst.getString("mobile"));
                        txt_address.setText(rst.getString("address"));
                        txt_qualification.setText(rst.getString("qualification"));
                        txt_gender.setText(rst.getString("gender"));
                        txt_blood_group.setText(rst.getString("bloodgroup"));
                        txt_dateofjoining.setText(rst.getString("dateofjoining"));
                        
                                                        
                        
                        }
        }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null,ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
        
        
        setBounds(100,100,1250,800);
        setVisible(true);
    }
    
}

   