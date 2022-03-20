package Doctor;
import database.DatabaseOperation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Appointments extends JFrame {

    JLabel lbl_total_wards, lbl_used_wards, lbl_available_wards, lbl_heading;
    JTextField txt_total_wards, txt_used_wards, txt_available_wards;
    Container co;
    ImageIcon iback;
    JButton back,diagnose;
    int total = 100, count, available;
    String a, u;
    JTable record;
    JScrollPane sp;
    DefaultTableModel model = new DefaultTableModel();
    JTable jtbl = new JTable(model);

    Appointments(String id) {

        co = getContentPane();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rooms");
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
            
                new Page(id);
                setVisible(false);
            }
        });

        
        setBounds(100,100,1250, 800);
        setVisible(true);

        diagnose=new JButton("Diagnose");
        diagnose.setBounds(650,580,150,50);
        add(diagnose);
        model.addColumn("Patient ID");
        model.addColumn("Patient Name");
        model.addColumn("Appointment Date");
        String name="";
        try {
            Connection con = DatabaseOperation.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT name FROM doctor_details where id='"+id+"'");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                name=Rs.getString("name");
            }
            pstm = con.prepareStatement("SELECT * FROM patient where doctor='"+name+"'");
            Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt("id"), Rs.getString("Name"),Rs.getDate("Appointment")});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        jtbl.setFont(new Font("Cascadia Code", Font.PLAIN, 19));
        jtbl.setRowHeight(45);
        jtbl.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 19));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbl.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jtbl.getTableHeader().setBackground(Color.decode("#7fa19a"));
        jtbl.getTableHeader().setForeground(Color.decode("#ddede9"));
        jtbl.setForeground(Color.decode("#4e8076"));
        jtbl.setBackground(Color.white);
        JScrollPane pg = new JScrollPane(jtbl);
        pg.setBounds(110,100,1000,250);
        add(pg);
        
        diagnose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=jtbl.getSelectedRow();
                Object pid = model.getValueAt(row,0 );
                new Patdiag(id,pid);
                setVisible(false);
            }
        });
    }

}