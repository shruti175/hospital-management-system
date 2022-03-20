package Pharmacy;


import database.DatabaseOperation;
import homepage.homepage;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Pharmacy extends JFrame {

    Container co = getContentPane();
    JLabel l_pid,l,title;
    JTextField t_pid;
    ImageIcon isearch, logo,iback;
    JButton search,back;
    Font text = new Font("Bookman Old Style", Font.PLAIN, 15);
    Font lab = new Font("Century Gothic", Font.BOLD, 22);

    public Pharmacy() {

        logo = new ImageIcon("img\\diagnosis\\logo.png");
        l = new JLabel(logo);
        l.setBounds(40, 50, 550, 652);
        add(l);
        
        iback = new ImageIcon("img\\doctor\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#D1EFFE"));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                new homepage();
                setVisible(false);
            }
        });

        l_pid = new JLabel("Patient ID : ");
        l_pid.setForeground(Color.decode("#29aae1"));
        l_pid.setBounds(660, 330, 200, 20);
        l_pid.setFont(lab);
        add(l_pid);
        
        title=new JLabel("Pharmacy");
        title.setForeground(Color.decode("#29aae1"));
        title.setFont(new Font("Arial Black",Font.BOLD,28));
        title.setBounds(765,210,500,50);
        add(title);

        t_pid = new JTextField();
        t_pid.setBounds(790, 330, 200, 25);
        t_pid.setFont(text);
        add(t_pid);
        

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
                String id = t_pid.getText();
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DatabaseOperation.getConnection();
                    Statement st = con.createStatement();
                    String query = "select * from patient where id='" + id + "'";
                    ResultSet res = st.executeQuery(query);
                    if (!res.next()) {
                        JOptionPane.showMessageDialog(null, "Patient details not registered");
                    } else {
                        new PharmacyID(id);
                        setVisible(false);
                    }
                    con.setAutoCommit(true);
                } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(null);
        setBounds(100, 100, 1250, 800);
        co.setBackground(Color.decode("#e1f2f0"));
        setTitle("Patient Diagnosis");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new Pharmacy();
    }
}
