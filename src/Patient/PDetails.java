package Patient;


import database.DatabaseOperation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;
import javax.swing.table.DefaultTableCellRenderer;

public class PDetails extends JFrame {

    Container co = getContentPane();
    JLabel l_pid, l, l_sym, l_diag, l_med, l_ward, l_room, lbg;
    JTextField t_pid, ward;
    Choice room;
    JTextArea t_sym, t_diag, t_med;
    JButton search, confirm, back, submit;
    JTable record;
    JScrollPane sp;
    ImageIcon bg, iback;
    Font text = new Font("Cascadia Code", Font.PLAIN, 18);
    Font lab = new Font("Bookman Old Style", Font.BOLD, 20);
    int roomid = 100,medid;
    
    PDetails(String id) {

        iback = new ImageIcon("img\\diagnosis\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#d1eaf0"));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);

        bg = new ImageIcon("img\\diagnosis\\l.png");
        lbg = new JLabel("", bg, JLabel.CENTER);
        lbg.setBounds(0, 0, 1250, 800);
        l_pid = new JLabel("Patient ID : ");
        l_pid.setForeground(Color.decode("#29aae1"));
        l_pid.setFont(new Font("Century Gothic", Font.BOLD, 22));
        add(l_pid);

        t_pid = new JTextField();
        t_pid.setFont(text);
        t_pid.setText(id);
        add(t_pid);

        l_sym = new JLabel("Symptoms");
        l_sym.setForeground(Color.decode("#29aae1"));
        l_sym.setFont(lab);
        add(l_sym);

        t_sym = new JTextArea();
        t_sym.setFont(text);
        t_sym.setLineWrap(true);
        t_sym.setWrapStyleWord(true);
        t_sym.setBackground(Color.decode("#eeeeee"));
        t_sym.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(t_sym);

        String[][] c_details = new String[1][5];
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DatabaseOperation.getConnection();
            Statement st = con.createStatement();
            String query = "select * from patient where id='" + id + "'";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                c_details[0][0] = (res.getString("Name"));
                c_details[0][1] = (res.getString("Age"));
                c_details[0][2] = (res.getString("Bloodgrp"));
                c_details[0][3] = (res.getDate("Appointment").toString());
                c_details[0][4] = (res.getString("Doctor"));
                t_sym.setText(res.getString("Symptoms"));
            }
            con.setAutoCommit(true);
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String[] c_heading = {"Patient Name", "Age", "Blood Group", "Appointment Date", "Doctor Name"};

        record = new JTable(c_details, c_heading);
        record.setFont(new Font("Cascadia Code", Font.PLAIN, 19));
        record.setRowHeight(30);
        record.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 17));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) record.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        record.getTableHeader().setBackground(Color.decode("#7fa19a"));
        record.getTableHeader().setForeground(Color.decode("#ddede9"));
        record.setForeground(Color.decode("#4e8076"));
        record.setBackground(Color.white);
        sp = new JScrollPane(record);
        add(sp);

        l_diag = new JLabel("Diagnosis");
        l_diag.setForeground(Color.decode("#29aae1"));
        l_diag.setFont(lab);
        add(l_diag);

        t_diag = new JTextArea();
        t_diag.setFont(text);
        t_diag.setLineWrap(true);
        t_diag.setWrapStyleWord(true);
        t_diag.setBackground(Color.decode("#eeeeee"));
        t_diag.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(t_diag);

        l_med = new JLabel("Medicine");
        l_med.setForeground(Color.decode("#29aae1"));
        l_med.setFont(lab);
        add(l_med);

        t_med = new JTextArea();
        t_med.setFont(text);
        t_med.setLineWrap(true);
        t_med.setWrapStyleWord(true);
        t_med.setBackground(Color.decode("#eeeeee"));
        t_med.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(t_med);

        l_ward = new JLabel("Ward Required ?");
        l_ward.setForeground(Color.decode("#29aae1"));
        l_ward.setFont(lab);
        add(l_ward);

        ward = new JTextField();
        ward.setFont(text);
        add(ward);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DatabaseOperation.getConnection();
            Statement st = con.createStatement();
            String query = "select * from diagnosis where id='" + id + "'";
            ResultSet res = st.executeQuery(query);
            if (!res.next()) {
                JOptionPane.showMessageDialog(null, "Diagnosis Not Completed");
            } else {
                query = "select * from diagnosis where id='" + id + "'";
                res = st.executeQuery(query);
                while (res.next()) {
                    t_diag.setText(res.getString("Diagnosis"));
                    t_med.setText(res.getString("Medicine"));
                    ward.setText(res.getString("Ward").toUpperCase());
                    medid=res.getInt("MedID");
                }
                query = "SELECT roomid FROM room WHERE roomid=(SELECT max(roomid) FROM room)";
                res = st.executeQuery(query);
                while (res.next()) {
                    roomid = res.getInt("roomid");
                }
            }
            con.setAutoCommit(true);
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        l_room = new JLabel("Room Type : ");
        l_room.setForeground(Color.decode("#29aae1"));
        l_room.setFont(lab);
        add(l_room);

        room = new Choice();
        room.add("AC");
        room.add("Non AC");
        room.setFont(text);

        submit = new JButton("Submit");
        submit.setFont(new Font("Century Gothic", Font.BOLD, 18));
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomid++;
                String type = room.getSelectedItem();
                int patientid = Integer.parseInt(t_pid.getText());
                String date = c_details[0][3];
                String name=c_details[0][0];
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DatabaseOperation.getConnection();
                    Statement st = con.createStatement();
                    String query="select * from room where id='"+patientid+"'";
                    ResultSet res=st.executeQuery(query);
                    if(res.next()){
                        int roomno=0;
                        query="select * from room where id='"+patientid+"'";
                        res=st.executeQuery(query);
                        while(res.next()){
                            roomno=res.getInt("roomid");
                        }
                        int result = JOptionPane.showConfirmDialog(null, "Room no : "+roomno+"\nDo you want to change room type?", "You already have a room!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (result == JOptionPane.YES_OPTION) {
                            query="update room set roomtype='"+type+"' where roomid="+roomno;
                            ResultSet r=st.executeQuery(query);
                            JOptionPane.showMessageDialog(null,"Room type changed\nType :"+type);
                        }
                        //JOptionPane.showMessageDialog(null,"You already have a room!\nRoom no : "+roomno);
                    }
                    else{
                        query = "insert into room values('" + roomid + "','" + type + "','" + name+"','"+date + "','" + patientid + "','"+medid+"')";
                        st.executeQuery(query);
                        JOptionPane.showMessageDialog(null,"Room allocated!\nRoom no : "+roomid);
                        con.setAutoCommit(true);
                    }
                    
                } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sp.setBounds(90, 150, 1100, 62);
        l_pid.setBounds(430, 70, 150, 25);
        t_pid.setBounds(560, 70, 200, 25);
        t_pid.setEditable(false);
        l_sym.setBounds(110, 300, 150, 35);
        t_sym.setBounds(270, 305, 200, 50);
        l_diag.setBounds(110, 400, 150, 35);
        t_diag.setBounds(270, 405, 200, 50);
        l_med.setBounds(110, 500, 150, 35);
        t_med.setBounds(270, 505, 200, 50);
        l_ward.setBounds(750, 300, 200, 35);
        ward.setBounds(950, 305, 150, 35);
        
        t_sym.setEditable(false);
        t_diag.setEditable(false);
        t_med.setEditable(false);
        ward.setEditable(false);
        
        if (ward.getText().equals("YES")) {
            l_room.setBounds(750, 400, 200, 35);
            room.setBounds(950, 405, 150, 45);
            submit.setBounds(580, 650, 100, 45);
            add(room);
        }

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientDiagnosis();
                setVisible(false);
            }
        });

        setLayout(null);
        setBounds(100, 100, 1250, 800);
        co.setBackground(Color.decode("#d1eaf0"));
        co.add(lbg);
        setVisible(true);
        setTitle("Diagnosis Report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
