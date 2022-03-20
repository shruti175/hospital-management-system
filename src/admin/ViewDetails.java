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
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewDetails extends JFrame {

    Container co;
    JLabel id_lbl, name_lbl, phno_lbl, age_lbl, gen_lbl, bldgrp_lbl, address_lbl, dist_lbl, apoint_lbl, symp_lbl, doctName_lbl, lbg;
    JTextField id_txt, name_txt, age_txt, phno_txt, address_txt,apt_date,bldgrp_jcb, dist_jcb, doctName_jcb,gender;
    JButton back;
    ImageIcon bg,iback;
    JTextArea symp_txt;
    Font text = new Font("Cascadia Code", Font.PLAIN, 18);
    Font lab = new Font("Bookman Old Style", Font.BOLD, 18);

    ViewDetails(String id) {
        
        iback = new ImageIcon("img\\diagnosis\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#d1eaf0"));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patview();
                setVisible(false);
            }
        });

        bg = new ImageIcon("img\\diagnosis\\l.png");
        lbg = new JLabel(bg);
        lbg.setBounds(0, 0, 1200, 800);

        //LABEL NAMING
        id_lbl = new JLabel("PATIENT ID");
        name_lbl = new JLabel("NAME");
        phno_lbl = new JLabel("PHONE NUMBER");
        age_lbl = new JLabel("AGE");
        gen_lbl = new JLabel("GENDER");
        bldgrp_lbl = new JLabel("BlOOD GROUP");
        address_lbl = new JLabel("ADDRESS");
        dist_lbl = new JLabel("DISTRICT");
        apoint_lbl = new JLabel("APOINTMENT DATE");
        symp_lbl = new JLabel("SYMPTOMS");
        doctName_lbl = new JLabel("DOCTOR");

        //TEXTFIELD NAMING
        id_txt = new JTextField();
        name_txt = new JTextField();
        phno_txt = new JTextField();
        address_txt = new JTextField();
        age_txt = new JTextField();
        dist_jcb = new JTextField();
        bldgrp_jcb = new JTextField();
        doctName_jcb = new JTextField();
        apt_date = new JTextField();
        gender = new JTextField();

        //TextArea
        symp_txt = new JTextArea();


        //SETTING BOUNDS FOR THE COMPONENTS
        //LABELS
        id_lbl.setBounds(430, 100, 150, 50);

        name_lbl.setBounds(150, 200, 100, 50);
        gen_lbl.setBounds(150, 280, 120, 50);
        age_lbl.setBounds(150, 360, 100, 50);
        address_lbl.setBounds(150, 440, 130, 50);
        dist_lbl.setBounds(150, 520, 130, 50);

        phno_lbl.setBounds(685, 200, 230, 50);
        bldgrp_lbl.setBounds(685, 280, 180, 50);
        apoint_lbl.setBounds(685, 360, 250, 50);
        symp_lbl.setBounds(685, 440, 180, 50);
        doctName_lbl.setBounds(685, 520, 180, 50);

        //TEXTFIELDS
        id_txt.setBounds(580, 113, 200, 27);

        name_txt.setBounds(285, 210, 210, 27);
        gender.setBounds(285, 294, 210, 28);
        age_txt.setBounds(285, 370, 80, 27);
        address_txt.setBounds(285, 450, 210, 27);
        dist_jcb.setBounds(285, 530, 120, 27);
        phno_txt.setBounds(890, 210, 210, 27);
        bldgrp_jcb.setBounds(890, 290, 120, 25);
        apt_date.setBounds(890, 375, 210, 27);
        symp_txt.setBounds(890, 440, 250, 60);
        doctName_jcb.setBounds(890, 535, 120, 25);

        //SETTING FONTS AND COLORS FOR LABELS
        id_lbl.setFont(new Font("Century Gothic", Font.BOLD, 20));
        id_lbl.setForeground(Color.decode("#29aae1"));

        name_lbl.setFont(lab);
        name_lbl.setForeground(Color.decode("#29aae1"));

        gen_lbl.setFont(lab);
        gen_lbl.setForeground(Color.decode("#29aae1"));

        age_lbl.setFont(lab);
        age_lbl.setForeground(Color.decode("#29aae1"));

        address_lbl.setFont(lab);
        address_lbl.setForeground(Color.decode("#29aae1"));

        dist_lbl.setFont(lab);
        dist_lbl.setForeground(Color.decode("#29aae1"));

        phno_lbl.setFont(lab);
        phno_lbl.setForeground(Color.decode("#29aae1"));

        bldgrp_lbl.setFont(lab);
        bldgrp_lbl.setForeground(Color.decode("#29aae1"));

        apoint_lbl.setFont(lab);
        apoint_lbl.setForeground(Color.decode("#29aae1"));

        symp_lbl.setFont(lab);
        symp_lbl.setForeground(Color.decode("#29aae1"));

        doctName_lbl.setFont(lab);
        doctName_lbl.setForeground(Color.decode("#29aae1"));

        //SETTING COLORS FOR TEXTFIELDS:
        id_txt.setFont(text);
        name_txt.setFont(text);
        age_txt.setFont(text);
        address_txt.setFont(text);
        dist_jcb.setFont(text);
        phno_txt.setFont(text);
        bldgrp_jcb.setFont(text);
        apt_date.setFont(text);
        symp_txt.setFont(text);
        doctName_jcb.setFont(text);
        gender.setFont(text);
        symp_txt.setLineWrap(true);
        symp_txt.setWrapStyleWord(true);
        symp_txt.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        id_txt.setEditable(false);
        name_txt.setEditable(false);
        age_txt.setEditable(false);
        address_txt.setEditable(false);
        dist_jcb.setEditable(false);
        phno_txt.setEditable(false);
        bldgrp_jcb.setEditable(false);
        apt_date.setEditable(false);
        symp_txt.setEditable(false);
        doctName_jcb.setEditable(false);
        gender.setEditable(false);

        //ADDING TO FRAMES
        add(id_lbl);
        add(name_lbl);
        add(phno_lbl);
        add(age_lbl);
        add(gen_lbl);
        add(bldgrp_lbl);
        add(address_lbl);
        add(dist_lbl);
        add(apoint_lbl);
        add(symp_lbl);
        add(doctName_lbl);
        add(gender);
        add(id_txt);
        add(name_txt);
        add(phno_txt);
        add(age_txt);
        add(bldgrp_jcb);
        add(address_txt);
        add(dist_jcb);
        add(doctName_jcb);
        add(apt_date);
        add(symp_txt);

        try {
            Connection con=DatabaseOperation.getConnection();
            Statement st = con.createStatement();
            String query = "select * from patient where id='" + id + "'";
            ResultSet res = st.executeQuery(query);
            if (!res.next()) {
                JOptionPane.showMessageDialog(null, "Patient Details not Registered.");
            } else {
                query = "select * from patient where id='" + id + "'";
                res = st.executeQuery(query);
                while (res.next()) {
                    id_txt.setText(id);
                    name_txt.setText(res.getNString("name"));
                    age_txt.setText(res.getNString("age"));
                    phno_txt.setText(res.getNString("ph_no"));
                    address_txt.setText(res.getNString("address"));
                    dist_jcb.setText(res.getNString("district"));
                    apt_date.setText(res.getDate("appointment").toString());
                    bldgrp_jcb.setText(res.getNString("bloodgrp"));
                    doctName_jcb.setText(res.getNString("doctor"));
                    symp_txt.setText(res.getNString("symptoms"));
                    gender.setText(res.getNString("gender"));
                    
                }
            }
            con.setAutoCommit(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        co = getContentPane();
        co.setBackground(Color.decode("#d1eaf0"));
        co.setLayout(null);
        co.add(lbg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,1250, 800);
        setTitle("Patient Details");
        setVisible(true);
    }

}
