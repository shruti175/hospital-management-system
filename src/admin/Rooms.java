package admin;


import database.DatabaseOperation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Rooms extends JFrame {

    JLabel lbl_total_wards, lbl_used_wards, lbl_available_wards, lbl_heading;
    JTextField txt_total_wards, txt_used_wards, txt_available_wards;
    Container co;
    ImageIcon iback;
    JButton back;
    int total = 100, count, available;
    String a, u;
    JTable record;
    JScrollPane sp;
    DefaultTableModel model = new DefaultTableModel();
    JTable jtbl = new JTable(model);

    Rooms() {

        co = getContentPane();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rooms");
        
        lbl_heading=new JLabel("ROOMS");
        lbl_heading.setFont(new Font("Bodoni MT",Font.BOLD,25));
        lbl_heading.setBounds(580,50,100,100);
        add(lbl_heading);
        
        co.setBackground(Color.decode("#CDF0EA"));
        
        iback = new ImageIcon("img\\diagnosis\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(10, 10, 75, 75);
        back.setBackground(Color.decode("#CDF0EA"));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
              new adminpage();
                setVisible(false);
            }
        });

        
        setBounds(100,100,1250, 800);
        setVisible(true);

        try {
            Connection con = DatabaseOperation.getConnection();
            String query = "select count(roomid) from room";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                count = rst.getInt("count(roomid)");
                u = (rst.getString("count(roomid)"));

            }
            a = (Integer.toString(total - count));

            String[][] c_details = {{"Total Wards", Integer.toString(total)},
                                    {"Used Wards", u},
                                    {"Available Wards", a}};
            String[] c_heading = {"", ""};
            record = new JTable(c_details, c_heading);
            record.setFont(new Font("Cascadia Code", Font.PLAIN, 19));
            record.setRowHeight(45);
            record.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 25));
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) record.getDefaultRenderer(Object.class);
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            record.getTableHeader().setBackground(Color.decode("#7fa19a"));
            record.getTableHeader().setForeground(Color.decode("#ddede9"));
            record.setForeground(Color.decode("#4e8076"));
            record.setBackground(Color.white);
            sp = new JScrollPane(record);
            add(sp);
            sp.setBounds(110, 160, 1000, 140);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        model.addColumn("Room ID");
        model.addColumn("Patient Name");
        model.addColumn("Room Type");
        try {
            Connection con = DatabaseOperation.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM room");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt("roomid"), Rs.getString("PatientName"),Rs.getString("Roomtype")});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        jtbl.setFont(new Font("Cascadia Code", Font.PLAIN, 19));
        jtbl.setRowHeight(35);
        jtbl.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 19));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbl.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jtbl.getTableHeader().setBackground(Color.decode("#7fa19a"));
        jtbl.getTableHeader().setForeground(Color.decode("#ddede9"));
        jtbl.setForeground(Color.decode("#4e8076"));
        jtbl.setBackground(Color.white);
        JScrollPane pg = new JScrollPane(jtbl);
        pg.setBounds(110,400,1000,250);
        add(pg);
    }

    public static void main(String[] args) {
        new Rooms();
    }
}