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
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

public class Update extends JFrame implements ActionListener{
    JLabel lbl_heading,lbl_name,lbl_id,lbl_email,lbl_password,lbl_mobile,lbl_address,lbl_qualification,lbl_gender,lbl_blood_group,lbl_dateofjoining;
    TextField txt_name,txt_id,txt_email,txt_password,txt_mobile,txt_address,txt_qualification,txt_gender,txt_blood_group,txt_dateofjoining;
    Container co;
    JButton jbtn_submit,back;
    ImageIcon iback;
    
    public Update(String int_id){
        co=getContentPane();
        co.setLayout(null);
        setTitle("Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         iback = new ImageIcon("img\\doctor\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#EBF2FB"));
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
        
        lbl_heading=new JLabel("UPDATE THE DETAILS");
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
        
         ImageIcon submit=new ImageIcon("img\\doctor\\submit.png");
        jbtn_submit=new JButton("SUBMIT", submit);
        
        lbl_heading.setBounds(400,50,350,25);
         lbl_id.setBounds(300, 100, 120, 25);
         lbl_name.setBounds(300, 150, 120, 25);
         lbl_email.setBounds(300, 200, 120, 25);
         lbl_password.setBounds(300,250,120,25);
         lbl_mobile.setBounds(300,300,120,25);
         lbl_address.setBounds(300,350,120,25);
         lbl_qualification.setBounds(300,400,120,25);
         lbl_gender.setBounds(300,450,120,25);
         lbl_blood_group.setBounds(300,500,120,25);
         lbl_dateofjoining.setBounds(300,550, 150, 25);
         
        
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
         
         
         jbtn_submit.setBounds(500,600,60,50);
         jbtn_submit.addActionListener(this);
         co.setBackground(Color.decode("#EBF2FB"));
        
        co.add(lbl_heading);
        co.add(lbl_id);
        co.add(lbl_name);
        co.add(lbl_email);
        co.add(lbl_password);
        co.add(lbl_mobile);
        co.add(lbl_address);
        co.add(lbl_qualification);
        co.add(lbl_gender);
        co.add(lbl_blood_group);
        co.add(lbl_dateofjoining);
        
        co.add(txt_id);
        co.add(txt_name);
        co.add(txt_email);
        co.add(txt_password);
        co.add(txt_mobile);
        co.add(txt_address);
        co.add(txt_qualification);
        co.add(txt_gender);
        co.add(txt_blood_group);
        co.add(txt_dateofjoining);
        
        co.add(jbtn_submit);
        try{
                        
                        // JOptionPane.showMessageDialog(this," "+int_eid);

                        Connection con=DatabaseOperation.getConnection();

                        String query="select name,email,password,mobile,address,qualification,gender,bloodgroup,dateofjoining from doctor_details where id=?";
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1,int_id);
                        ResultSet rst=pstmt.executeQuery();
                        if(rst.next()){
                        //txt_id.setText(rst.getString("id"));
                        txt_id.setText(int_id);
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
    /*  @Override
     public void paint(Graphics g)   
 {  
  super.paint(g);  
  Graphics2D g2d = (Graphics2D) g;  
  GradientPaint gp1 = new GradientPaint(0, 400, Color.white, 400, 360, Color.blue);  
  g2d.setPaint(gp1);  
  g2d.fillRect(00, 00,this.getWidth(), this.getHeight());  
 }  
   */
    public void actionPerformed(ActionEvent ae){
        
        Object obj_source=ae.getSource();
        
        if(obj_source==jbtn_submit){
             txt_id.setEditable(false);
            txt_name.setEditable(false);
            txt_dateofjoining.setEditable(false);
            txt_gender.setEditable(false);
            txt_blood_group.setEditable(false);

        try{
           
                   
                   Connection con=DatabaseOperation.getConnection();
                   //if(!Pattern.matches("[A-Z][a-z]*", txt_name.getText())){
                     //   JOptionPane.showMessageDialog(null,"Please enter a valid name","Error",JOptionPane.ERROR_MESSAGE);
                    //}
                    /*if(!Pattern.matches("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}",txt_dateofjoining.getText())){
                    JOptionPane.showMessageDialog(null, "Please enter in the format yyyy-MM-dd ", "Error", JOptionPane.ERROR_MESSAGE);
                }*/
                if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txt_email.getText()))) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!Pattern.matches("[789]{1}[0-9]{9}", txt_mobile.getText())){
                        JOptionPane.showMessageDialog(null,"Please enter a valid phone number","Error",JOptionPane.ERROR_MESSAGE);
                    }
                else if(txt_gender.getText()==null){
                    JOptionPane.showMessageDialog(null,"Please enter the gender","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(txt_blood_group.getText()==null){
                    JOptionPane.showMessageDialog(null,"Please enter the blood group","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!Pattern.matches("[A-Z]*[a-z]*",txt_qualification.getText())){
                     JOptionPane.showMessageDialog(null,"Please enter a valid qualification","Error",JOptionPane.ERROR_MESSAGE);
                }
               
                    else if(!Pattern.matches("^[#.0-9\\a-zA-Z\\s,-]+$", txt_address.getText())){
                       JOptionPane.showMessageDialog(null,"Please enter a valid address\n","Error",JOptionPane.ERROR_MESSAGE);
                    }
                
               else if(!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",txt_password.getText())){
                    JOptionPane.showMessageDialog(null,"Please enter a valid password(Must have atleast one numeric character,\n"+
                            "one lowercase character ,at least one uppercase character\n"
                            + "at least one special symbol among @#$%\n" 
                            +"Password length should be between 8 and 20)","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                   String query="update doctor_details set name=?,email=?,password=?,mobile=?,address=?,qualification=?,gender=?,bloodgroup=?,dateofjoining=? where id=?";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   //pstmt.setString(1,txt_id.getText());
                   pstmt.setString(1,txt_name.getText());
                   pstmt.setString(2,txt_email.getText());
                   pstmt.setString(3,txt_password.getText());
                   pstmt.setString(4,txt_mobile.getText());
                   pstmt.setString(5,txt_address.getText());
                   pstmt.setString(6,txt_qualification.getText());
                   pstmt.setString(7,txt_gender.getText());
                   pstmt.setString(8,txt_blood_group.getText());
                   pstmt.setString(9,txt_dateofjoining.getText());
                   pstmt.setString(10,txt_id.getText());
                   

                   pstmt.executeUpdate();
                   con.setAutoCommit(true);
                   JOptionPane.showMessageDialog(this, "Updation Success!");
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
            }

        }
    }
  
}
