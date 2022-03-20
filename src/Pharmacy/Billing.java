package Pharmacy;

import database.DatabaseOperation;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Billing extends JFrame{
    ImageIcon ibg,iback;
    JLabel bg,billno_lbl,patid_lbl,name_lbl,tot_lbl;
    JTable record;
    JScrollPane sp;
    JButton back;
    Container co=getContentPane();
    Font lab = new Font("Bookman Old Style", Font.BOLD, 18);
    String medicine="",quantity="";
    public Billing(String id){
        
        //back button
        iback = new ImageIcon("img\\pharmacy\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(20, 10, 75, 75);
        back.setBackground(Color.decode("#d9d8d9"));
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
       
        ibg=new ImageIcon("img\\pharmacy\\bill.png");
        bg=new JLabel("",ibg,JLabel.CENTER);
        bg.setBounds(-15,-30,1250,800);
       
        Random billno=new Random();
        int bill=billno.nextInt(8000)+50;
        String idd=String.valueOf(bill);
        billno_lbl=new JLabel(idd);
        billno_lbl.setFont(lab);
        billno_lbl.setBounds(240,127,100,50);
       
        patid_lbl=new JLabel();
        patid_lbl.setFont(lab);
        patid_lbl.setBounds(240,180,100,50);
       
        name_lbl=new JLabel();
        name_lbl.setFont(lab);
        name_lbl.setBounds(990,182,210,50);
       
        tot_lbl=new JLabel();
        tot_lbl.setFont(lab);
        tot_lbl.setBounds(1050,615,100,50);
       
       
       
        co.add(billno_lbl);
        co.add(patid_lbl);
        co.add(name_lbl);
        co.add(tot_lbl);
       
     
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DatabaseOperation.getConnection();
            Statement st = con.createStatement();
            String query = "select * from diagnosis where id='"+id+"'";
            ResultSet res = st.executeQuery(query);
                while (res.next()) {
                    medicine = res.getString("medicine");
                    quantity = res.getString("quantity");
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
       
        int tot=0;
        String[][] c_details = new String[len][3];
        for(int i=0;i<len;i++){
            c_details[i][0]=med[i];
            c_details[i][1]=quan[i];
            c_details[i][2]=price[i];
            long final_pri=Long.parseLong(c_details[i][1])*(Long.parseLong(c_details[i][2]));
            c_details[i][2]=String.valueOf(final_pri);
           
           
           tot+=final_pri;
           
        }
        tot_lbl.setText(String.valueOf(tot));
        String[] c_heading = {"", "", ""};

        //table
        record = new JTable(c_details, c_heading);
        record.setRowHeight(60);
        record.getColumnModel().getColumn(0).setPreferredWidth(720);
        record.getColumnModel().getColumn(1).setPreferredWidth(200);
        record.getColumnModel().getColumn(1).setPreferredWidth(200);
        record.setFont(new Font("Cascadia Code", Font.PLAIN, 19));
        sp = new JScrollPane(record);
        sp.setBounds(110, 300, 1000, 400);
        add(sp);
       
        //printing name
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DatabaseOperation.getConnection();
                Statement st = con.createStatement();
                String query = "select * from diagnosis where id='"+id+"'";
                ResultSet res = st.executeQuery(query);
                while (res.next()) {
           
                   String a=res.getString("patientname");
                   name_lbl.setText(a);  
                   patid_lbl.setText(id);
                    
                }
                con.setAutoCommit(true);
            } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
       
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DatabaseOperation.getConnection();
                Statement st = con.createStatement();
                String query = "insert into pharmacy values("+bill+",'"+Integer.parseInt(id)+"','"+tot+"')";
                st.executeQuery(query);
                con.setAutoCommit(true);
            } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        
           record.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 25));
     
        //making table transparent
        record.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) record.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        record.setGridColor(new Color(0,0,0,0));
        sp.setBackground(new Color(0, 0, 0, 0));
        sp.setOpaque(false);
        record.setOpaque(false);
        ((DefaultTableCellRenderer) record.getDefaultRenderer(Object.class)).setOpaque(false);

        sp.getViewport().setOpaque(false);
        sp.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0), 1));
       
       
       
       
        setBounds(100,100,1250,800);
        setLayout(null);
        co.add(bg);
       co.setBackground(Color.decode("#d9d8d9"));

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}