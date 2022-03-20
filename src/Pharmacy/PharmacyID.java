package Pharmacy;


import database.DatabaseOperation;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

public class PharmacyID extends JFrame {

    ImageIcon ibg,iback,ibill;
    JLabel bg,l_pid;
    JTextField t_pid;
    Container co = getContentPane();
    JTable record;
    JScrollPane sp;
    JButton back,bill;
    String medicine = "", quantity = "";
    Border border=BorderFactory.createLineBorder(new Color(0,0,0,0), 1);
    PharmacyID(String id) {
        
        //back button
        iback = new ImageIcon("img\\pharmacy\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#eaf2f2"));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pharmacy();
                setVisible(false);
            }
        });
        
        //backgroung img
        ibg = new ImageIcon("img\\pharmacy\\bg.png");
        bg = new JLabel("", ibg, JLabel.CENTER);
        bg.setBounds(0, 0, 1250, 800);
        
        l_pid = new JLabel("Patient ID : ");
        l_pid.setForeground(Color.decode("#29aae1"));
        l_pid.setFont(new Font("Century Gothic", Font.BOLD, 22));
        add(l_pid);

        t_pid = new JTextField();
        t_pid.setFont(new Font("Cascadia Code", Font.PLAIN, 18));
        t_pid.setText(id);
        t_pid.setEditable(false);
        add(t_pid);
        
        l_pid.setBounds(430, 70, 150, 25);
        t_pid.setBounds(560, 70, 200, 25);
        

        //fetching patient medicine details
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DatabaseOperation.getConnection();
            Statement st = con.createStatement();
            String query = "select * from diagnosis where id='"+id+"'";
            ResultSet res = st.executeQuery(query);
            if (res.next()) {
                query = "select * from diagnosis where id='"+id+"'";
                res = st.executeQuery(query);
                while (res.next()) {
                    medicine = res.getString("Medicine");
                    quantity = res.getString("Quantity");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Diagnosis not Completed");
            }
            con.setAutoCommit(true);
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[] med = medicine.split(",");
        String[] quan = quantity.split(",");
        int len = med.length;
        String[] price=new String[len];

        //fetching medicine price
        for (int i = 0; i < len; i++) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DatabaseOperation.getConnection();
                Statement st = con.createStatement();
                String query = "select * from medicine where medname='"+med[i]+"'";
                ResultSet res = st.executeQuery(query);
                while (res.next()) {
                    price[i] = res.getString("rupees");
                }
                con.setAutoCommit(true);
            } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        String[][] c_details = new String[len][3];
        for(int i=0;i<len;i++){
            c_details[i][0]=med[i];
            c_details[i][1]=quan[i];
            c_details[i][2]=price[i];
        }
        String[] c_heading = {"Medicine", "Quantity", "Price/tablet"};

        //table
        record = new JTable(c_details, c_heading);
        record.setRowHeight(60);
        sp = new JScrollPane(record);
        sp.setBounds(110, 180, 1000, 200);
        add(sp);

        //center align
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) record.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        record.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 25));
        record.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        record.getTableHeader().setBackground(new Color(226,221,221,200));
        record.getTableHeader().setForeground(Color.decode("#50aff2"));
        record.setForeground(Color.decode("#07657d"));

        //making table transparent
        record.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) record.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        record.setGridColor(new Color(0,0,0,0));
        sp.setBackground(new Color(0, 0, 0, 0));
        sp.setOpaque(false);
        record.setOpaque(false);
        ((DefaultTableCellRenderer) record.getDefaultRenderer(Object.class)).setOpaque(false);

        sp.getViewport().setOpaque(false);
        sp.setBorder(border);
        
        //bill
        ibill = new ImageIcon("img\\pharmacy\\gbill.png");
        bill = new JButton(ibill);
        bill.setBounds(1050,650,170,70);
        bill.setBorderPainted(false);
        bill.setFocusPainted(false);
        add(bill);
        bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Billing(id);
                setVisible(false);
            }
        });
        
        setBounds(100, 100, 1250, 800);
        setLayout(null);
        setTitle("Pharmacy");
        co.add(bg);
        co.setBackground(Color.decode("#d1eaf0"));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
