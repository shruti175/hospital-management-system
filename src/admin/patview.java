/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import database.DatabaseOperation;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class patview extends JFrame {

    Container co = getContentPane();
    JLabel l_pid,l,title;
    JComboBox t_pid;
    ImageIcon isearch, logo,iback;
    JButton search,back;
    Font text = new Font("Bookman Old Style", Font.PLAIN, 15);
    Font lab = new Font("Century Gothic", Font.BOLD, 22);

    patview() {

        logo = new ImageIcon("img/diagnosis/logo.png");
        l = new JLabel(logo);
        l.setBounds(40, 50, 550, 652);
        add(l);

        l_pid = new JLabel("Patient ID : ");
        l_pid.setForeground(Color.decode("#29aae1"));
        l_pid.setBounds(660, 330, 200, 20);
        l_pid.setFont(lab);
        add(l_pid);
        
        title=new JLabel("Patient Details");
        title.setForeground(Color.decode("#29aae1"));
        title.setFont(new Font("Arial Black",Font.BOLD,28));
        title.setBounds(695,180,500,50);
        add(title);

        t_pid = new JComboBox();
        
        try{
          t_pid.addItem("select");
 
          Connection con=DatabaseOperation.getConnection();
          String query="select id from patient";
            PreparedStatement pstmt=con.prepareStatement(query);

              ResultSet rst=pstmt.executeQuery();
             while(rst.next()){
         t_pid.addItem(rst.getString("id"));
          }
        }
 catch(Exception ex){
 JOptionPane.showMessageDialog(this, " ERRORRR! "+ ex.toString());
 }
        t_pid.setBounds(790, 330, 200, 25);
        t_pid.setFont(text);
        add(t_pid);
        
        iback = new ImageIcon("img\\diagnosis\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#e1f2f0"));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patpage();
                setVisible(false);
            }
        });

        isearch = new ImageIcon("img\\diagnosis\\search.png");
        search = new JButton(isearch);
        isearch.setImageObserver(search);
        search.setBounds(995, 320, 45, 45);
        search.setBackground(Color.decode("#e1f2f0"));
        search.setBorderPainted(false);
        search.setFocusPainted(false);
        add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t_pid.getSelectedItem().toString();
                try {
                    Connection con =DatabaseOperation.getConnection();
                    Statement st = con.createStatement();
                    String query = "select * from patient where id='" + id + "'";
                    ResultSet res = st.executeQuery(query);
                    if (!res.next()) {
                        JOptionPane.showMessageDialog(null, "Patient details not registered");
                    } else {
                        new ViewDetails(id);
                        setVisible(false);
                    }
                    con.setAutoCommit(true);
                } catch (HeadlessException | NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(null);
        setBounds(100, 100, 1250, 800);
        co.setBackground(Color.decode("#e1f2f0"));
        setTitle("Patient Details");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new patview();
    }
}