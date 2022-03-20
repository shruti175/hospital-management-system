package Patient;

import com.toedter.calendar.JDateChooser;
import database.DatabaseOperation;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PatUpdate extends JFrame {

    JLabel name_lbl, phno_lbl, age_lbl, gen_lbl, bldgrp_lbl, address_lbl, dist_lbl, apoint_lbl, ttl_lbl, id_lbl,lbg;
    JTextField name_txt, age_txt, phno_txt, address_txt, gen_txt, bldgrp_txt, dist_txt, apoint_txt, id_txt;
    JButton close_jbt, back_jbt, save_jbt;
    JComboBox id_jcb;
    JDateChooser apoint_date;
    Container co;
    ImageIcon bg, iback;
    Font text = new Font("Cascadia Code", Font.PLAIN, 18);
    Font lab = new Font("Bookman Old Style", Font.BOLD, 18);

    PatUpdate(String id) {

        bg = new ImageIcon("img\\diagnosis\\l.png");
        lbg = new JLabel(bg);
        lbg.setBounds(0, 0, 1200, 800);

        //ADDING LABELS
        id_lbl = new JLabel("PATIENT ID");
        ttl_lbl = new JLabel("PATIENT DETAILS");
        name_lbl = new JLabel("Name");
        phno_lbl = new JLabel("Phone Number");
        age_lbl = new JLabel("Age");
        gen_lbl = new JLabel("Gender");
        bldgrp_lbl = new JLabel("Blood Group");
        address_lbl = new JLabel("Address");
        dist_lbl = new JLabel("District");
        apoint_lbl = new JLabel("Appointment Date");

        // date chooser
        apoint_date = new JDateChooser();
        apoint_date.setLocale(Locale.UK);
        apoint_date.setDateFormatString("yyyy/MM/dd");

        back_jbt = new JButton("BACK");
        save_jbt = new JButton("SAVE");

        id_txt = new JTextField();
        name_txt = new JTextField();
        phno_txt = new JTextField();
        address_txt = new JTextField();
        age_txt = new JTextField();
        gen_txt = new JTextField();
        bldgrp_txt = new JTextField();
        dist_txt = new JTextField();
        apoint_txt = new JTextField();

        //FONT SETTING:    
        ttl_lbl.setFont(new Font("Serif", Font.BOLD, 20));
        ttl_lbl.setForeground(Color.red);

        //SETTING BOUNDS
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

        //TEXTFIELDS
        id_txt.setBounds(580, 113, 200, 27);

        name_txt.setBounds(285, 210, 210, 27);
        gen_txt.setBounds(285, 294, 210, 28);
        age_txt.setBounds(285, 370, 80, 27);
        address_txt.setBounds(285, 450, 210, 27);
        dist_txt.setBounds(285, 530, 120, 27);
        phno_txt.setBounds(890, 210, 210, 27);
        bldgrp_txt.setBounds(890, 290, 120, 25);
        apoint_date.setBounds(890, 375, 210, 27);

        //BUTTONS
        save_jbt.setBounds(545, 640, 130, 50);

        iback = new ImageIcon("img\\diagnosis\\back.png");
        back_jbt = new JButton(iback);
        iback.setImageObserver(back_jbt);
        back_jbt.setBounds(10, 10, 75, 75);
        back_jbt.setBackground(Color.decode("#d1eaf0"));
        back_jbt.setBorderPainted(false);
        back_jbt.setFocusPainted(false);
        //ADDING LISTENERS

        back_jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewDetails(id);
                setVisible(false);
            }
        });

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

        id_txt.setFont(text);
        id_txt.setEditable(false);
        name_txt.setFont(text);
        age_txt.setFont(text);
        address_txt.setFont(text);
        dist_txt.setFont(text);
        phno_txt.setFont(text);
        bldgrp_txt.setFont(text);
        gen_txt.setFont(text);
        save_jbt.setFont(text);

        save_jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Name
                if (!Pattern.matches("[a-zA-Z][a-zA-Z ]*", name_txt.getText()) || (name_txt.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Please Enter valid Name!", "Name", JOptionPane.ERROR_MESSAGE);
                } //AGE
                else if ((age_txt.getText().isEmpty()) || Integer.parseInt(age_txt.getText()) < 0 || Integer.parseInt(age_txt.getText()) > 100) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid age!", "Age", JOptionPane.ERROR_MESSAGE);
                } //ADDRESS
                else if (!Pattern.matches("^[A-Za-z1-9\\s||,||A-Za-z1-9\\s||,||A-Za-z1-9\\s*]{1,40}$", address_txt.getText()) || (address_txt.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Please enter valid Address!", "Address", JOptionPane.ERROR_MESSAGE);
                } //DISTRICT
                else if (dist_txt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter your District!", "District", JOptionPane.ERROR_MESSAGE);
                } //PHONE NUMBER:
                else if (!Pattern.matches("^[789]\\d{9}$", phno_txt.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid phone number", "Phone Number", JOptionPane.ERROR_MESSAGE);
                } //BLOOD GROUP
                else if (bldgrp_txt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter your Blood Group !", "Blood Group", JOptionPane.ERROR_MESSAGE);
                } //APPOINTMENT DATE
                else if (((JTextField) apoint_date.getDateEditor().getUiComponent()).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid date", "Date", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int id = Integer.parseInt(id_txt.getText());
                        String name = name_txt.getText();
                        String phno = phno_txt.getText();
                        int age = Integer.parseInt(age_txt.getText());
                        String gen = gen_txt.getText();
                        String bldgrp = bldgrp_txt.getText();
                        Date aptDate = apoint_date.getDate();
                        String address = address_txt.getText();
                        String district = dist_txt.getText();

                        Connection con = DatabaseOperation.getConnection();

                        String query = "update patient set name=?,ph_no=?,age=?,gender=?,bloodgrp=?,address=?,district=?,appointment=? where id=?";
                        PreparedStatement pdmt = con.prepareStatement(query);
                        pdmt.setString(1, name);
                        pdmt.setString(2, phno);
                        pdmt.setInt(3, age);
                        pdmt.setString(4, gen);
                        pdmt.setString(5, bldgrp);
                        pdmt.setString(6, address);
                        pdmt.setString(7, district);
                        pdmt.setDate(8, new java.sql.Date(aptDate.getTime()));
                        pdmt.setInt(9, id);

                        pdmt.executeUpdate();
                        con.setAutoCommit(true);

                        con.close();
                        JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY ! ");

                    } catch (SQLIntegrityConstraintViolationException ve) {
                        JOptionPane.showMessageDialog(null, "ID already exists");
                    } catch (HeadlessException | NumberFormatException | SQLException ee) {
                        JOptionPane.showMessageDialog(null, ee.toString());
                    }

                }
            }

        });

        //ADDING TO FRAMES:
        add(id_lbl);
        add(name_lbl);
        add(phno_lbl);
        add(age_lbl);
        add(gen_lbl);
        add(bldgrp_lbl);
        add(address_lbl);
        add(dist_lbl);
        add(apoint_lbl);

        add(id_txt);
        add(name_txt);
        add(phno_txt);
        add(age_txt);
        add(gen_txt);
        add(bldgrp_txt);
        add(address_txt);
        add(dist_txt);
        add(apoint_txt);
        add(apoint_date);

        add(back_jbt);
        add(save_jbt);

        co = getContentPane();
        co.setBackground(Color.decode("#d1eaf0"));
        co.setLayout(null);
        co.add(lbg);
        //#f3a183  #eacda3
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 1250, 800);
        setTitle("Patient Update Form");
        setVisible(true);

        //FETCHING FROM DATABASE
        try {

            Connection con = DatabaseOperation.getConnection();
            String query = "select name,ph_no,age,gender,bloodgrp,appointment,address,district from patient where id=?";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, id);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                id_txt.setText(id);
                name_txt.setText(rst.getString(1));
                phno_txt.setText(rst.getString(2));
                age_txt.setText(rst.getString(3));
                gen_txt.setText(rst.getString(4));
                bldgrp_txt.setText(rst.getString(5));
                apoint_txt.setText(rst.getDate(6).toString());
                address_txt.setText(rst.getString(7));
                dist_txt.setText(rst.getString(8));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "" + ex.toString());
        }

    }

}