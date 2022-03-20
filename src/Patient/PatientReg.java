package Patient;


import com.toedter.calendar.JDateChooser;
import database.DatabaseOperation;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.ButtonGroup;

public class PatientReg extends JFrame implements ActionListener, ItemListener {

    Container co;
    JLabel id_lbl, name_lbl, phno_lbl, age_lbl, gen_lbl, bldgrp_lbl, address_lbl, dist_lbl, apoint_lbl, symp_lbl, doctName_lbl, lbg;
    JTextField id_txt, name_txt, age_txt, phno_txt, address_txt;
    JRadioButton male_rdb, female_rdb;
    JComboBox bldgrp_jcb, dist_jcb, doctName_jcb;
    JButton save_jbt, back;
    ButtonGroup gender;
    JDateChooser apt_date;
    ImageIcon bg, iback;
    JTextArea symp_txt;
    String gen = "";
    int id=1000;
    Font text = new Font("Cascadia Code", Font.PLAIN, 18);
    Font lab = new Font("Bookman Old Style", Font.BOLD, 18);

    PatientReg() {
        bg = new ImageIcon("img\\diagnosis\\l.png");
        lbg = new JLabel(bg);
        lbg.setBounds(0, 0, 1200, 800);

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
                new PatientOption();
                setVisible(false);
            }
        });

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

        //RADIO BUTTONS
        male_rdb = new JRadioButton("Male");
        male_rdb.setBackground(Color.decode("#d1eaf0"));
        female_rdb = new JRadioButton("Female");
        female_rdb.setBackground(Color.decode("#d1eaf0"));
        gender=new ButtonGroup();
        gender.add(male_rdb);
        gender.add(female_rdb);

        dist_jcb = new JComboBox();
        dist_jcb.addItem("-SELECT-");
        dist_jcb.addItem("Chennai");
        dist_jcb.addItem("Coimbatore");
        dist_jcb.addItem("Erode");
        dist_jcb.addItem("Tirunelveli");
        dist_jcb.addItem("Madurai");
        dist_jcb.addItem("Salem");
        dist_jcb.addItem("Trichy");

        bldgrp_jcb = new JComboBox();
        bldgrp_jcb.addItem("-SELECT-");
        bldgrp_jcb.addItem("O+");
        bldgrp_jcb.addItem("O-");
        bldgrp_jcb.addItem("A+");
        bldgrp_jcb.addItem("A-");
        bldgrp_jcb.addItem("B+");
        bldgrp_jcb.addItem("B-");
        bldgrp_jcb.addItem("AB+");
        bldgrp_jcb.addItem("AB-");

        doctName_jcb = new JComboBox();
        doctName_jcb.addItem("-SELECT-");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DatabaseOperation.getConnection();
            Statement st = con.createStatement();
            String query = "select * from doctor_details";
            ResultSet res = st.executeQuery(query);
         
                while (res.next()) {
                    doctName_jcb.addItem(res.getString("Name"));
                }
            query = "SELECT id FROM patient WHERE id=(SELECT max(id) FROM patient)";
            res = st.executeQuery(query);
            while(res.next()){
                id=res.getInt("ID");
            }
            con.setAutoCommit(true);
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        //JDATE CHOOSER
        apt_date = new JDateChooser();
        apt_date.setLocale(Locale.UK);
        apt_date.setDateFormatString("yyyy/MM/dd");

        //TextArea
        symp_txt = new JTextArea();

        //BUTTONS
        save_jbt = new JButton("Save");

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
        id++;
        id_txt.setText(Integer.toString(id));
        id_txt.setEditable(false);
        
        name_txt.setBounds(285, 210, 210, 27);
        male_rdb.setBounds(285, 294, 80, 25);
        female_rdb.setBounds(370, 294, 100, 25);
        age_txt.setBounds(285, 370, 80, 27);
        address_txt.setBounds(285, 450, 210, 27);
        dist_jcb.setBounds(285, 530, 120, 27);

        phno_txt.setBounds(890, 210, 210, 27);
        bldgrp_jcb.setBounds(890, 290, 120, 25);
        apt_date.setBounds(890, 375, 210, 27);
        symp_txt.setBounds(890, 440, 250, 60);
        doctName_jcb.setBounds(890, 535, 120, 25);

        //BUTTONS
        save_jbt.setBounds(565, 640, 90, 40);

        //Adding listeners
        save_jbt.addActionListener(this);
        male_rdb.addItemListener(this);
        female_rdb.addItemListener(this);

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
        male_rdb.setFont(text);
        female_rdb.setFont(text);
        age_txt.setFont(text);
        address_txt.setFont(text);
        dist_jcb.setFont(text);
        phno_txt.setFont(text);
        bldgrp_jcb.setFont(text);
        apt_date.setFont(text);
        symp_txt.setFont(text);
        doctName_jcb.setFont(text);

        symp_txt.setLineWrap(true);
        symp_txt.setWrapStyleWord(true);
        symp_txt.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        //BUTTON
        save_jbt.setFont(text);

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

        add(id_txt);
        add(name_txt);
        add(phno_txt);
        add(age_txt);
        add(male_rdb);
        add(female_rdb);
        add(bldgrp_jcb);
        add(address_txt);
        add(dist_jcb);
        add(doctName_jcb);

        add(apt_date);

        add(symp_txt);

        add(save_jbt);

        co = getContentPane();
        co.setBackground(Color.decode("#d1eaf0"));
        co.setLayout(null);
        co.add(lbg);
        //#f3a183  #eacda3
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 1250, 800);
        setTitle("Patient Registration");
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {

        if (ie.getSource() == male_rdb) {
            gen = "MALE";
        } else {
            gen = "FEMALE";
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save_jbt) {

            //ID
            if (!Pattern.matches("[0-9]{0,}", id_txt.getText()) || (id_txt.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Please Enter valid ID!", "ID", JOptionPane.ERROR_MESSAGE);
            } //NAME
            else if (!Pattern.matches("[a-zA-Z][a-zA-Z ]*", name_txt.getText()) || (name_txt.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Please Enter valid Name!", "Name", JOptionPane.ERROR_MESSAGE);
            }
            //GENDER
            else if ((male_rdb.isSelected() == false) && (female_rdb.isSelected() == false)) {
                JOptionPane.showMessageDialog(null, "Please select your Gender", "Gender", JOptionPane.ERROR_MESSAGE);
            } //AGE
            else if ((age_txt.getText().isEmpty()) || Integer.parseInt(age_txt.getText()) < 0 || Integer.parseInt(age_txt.getText()) > 100) {
                JOptionPane.showMessageDialog(this, "Please Enter a Valid age!", "Age", JOptionPane.ERROR_MESSAGE);
            } //ADDRESS
            else if (!Pattern.matches("^[A-Za-z1-9\\s||,||A-Za-z1-9\\s||,||A-Za-z1-9\\s*]{1,40}$", address_txt.getText()) || (address_txt.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter valid Address!", "Address", JOptionPane.ERROR_MESSAGE);
            } //DISTRICT
            else if (Pattern.matches("-SELECT-", dist_jcb.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(this, "Please select your District!", "District", JOptionPane.ERROR_MESSAGE);
            } //PHONE NUMBER:
            else if (!Pattern.matches("^[789]\\d{9}$", phno_txt.getText().toString())) {
                JOptionPane.showMessageDialog(this, "Please enter a valid phone number", "Phone Number", JOptionPane.ERROR_MESSAGE);
            } //BLOOD GROUP
            else if (Pattern.matches("-SELECT-", bldgrp_jcb.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(this, "Please select your Blood Group !", "Blood Group", JOptionPane.ERROR_MESSAGE);
            } //DATE
            else if (((JTextField) apt_date.getDateEditor().getUiComponent()).getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter a valid Date", "DATE", JOptionPane.ERROR_MESSAGE);
            } //SYMPTOMS
            else if (!Pattern.matches("(^[A-Za-z\\s])||,||[A-Za-z\\s||,*]{1,100}$", symp_txt.getText()) || (symp_txt.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Please tell your Symptoms!", "Symptoms", JOptionPane.ERROR_MESSAGE);
            } //DOCTOR
            else if (Pattern.matches("-SELECT-", doctName_jcb.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(this, "Please select your Doctor Name !", "DOCTOR NAME", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int id = Integer.parseInt(id_txt.getText());
                    String name = name_txt.getText();
                    String phno = phno_txt.getText();
                    int age = Integer.parseInt(age_txt.getText());
                    String bldgrp = bldgrp_jcb.getSelectedItem().toString();
                    Date aptDate = apt_date.getDate();
                    String address = address_txt.getText();
                    String district = dist_jcb.getSelectedItem().toString();
                    String symptoms = symp_txt.getText();
                    String doctName = doctName_jcb.getSelectedItem().toString();

                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PatientReg.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Connection con = DatabaseOperation.getConnection();
                    String query = "insert into patient values(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pdmt = con.prepareStatement(query);

                    pdmt.setInt(1, id);
                    pdmt.setString(2, name);
                    pdmt.setInt(3, age);
                    pdmt.setString(4, gen);
                    pdmt.setString(5, address);
                    pdmt.setString(6, district);
                    pdmt.setString(7, phno);
                    pdmt.setString(8, bldgrp);
                    pdmt.setDate(9, new java.sql.Date(aptDate.getTime()));
                    pdmt.setString(10, symptoms);
                    pdmt.setString(11, doctName);

                    pdmt.executeUpdate();
                    con.setAutoCommit(true);

                    JOptionPane.showMessageDialog(this, "Registration Completed");

                } catch (HeadlessException | NumberFormatException | SQLException ee) {
                    JOptionPane.showMessageDialog(this, ee.toString());
                }

            }

        }

    }

    public static void main(String[] args) {
        new PatientReg();
    }

}