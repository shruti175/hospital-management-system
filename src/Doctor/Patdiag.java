
package Doctor;

import database.DatabaseOperation;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;

public class Patdiag extends Frame implements ActionListener {

    Label pat_id, pat_name, pat_diag, pat_med, pat_Wardrequired, title, pat_quantity,pat_symptoms;
    TextField tpat_id, tpat_name,tpat_symptoms, tpat_diag, tpat_med, tpat_quantity;
    Container co;
    
    Choice Wardrequired;

    Button submit, exit;
    JButton back;
    String str_gen;
    ImageIcon iback;

    Patdiag(String did, Object id) {
        iback = new ImageIcon("img\\doctor\\back.png");
        back = new JButton(iback);
        iback.setImageObserver(back);
        back.setBounds(30, 30, 75, 75);
        back.setBackground(Color.decode("#F08080"));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Appointments(did);
                setVisible(false);
            }
        });

        title = new Label("Patient Diagnosis Form");
        pat_id = new Label("Patient ID");
        pat_name = new Label("Patient Name");
        pat_symptoms=new Label("Patient Symptoms");
        pat_diag = new Label("Patient Diagnosis");
        pat_quantity = new Label("Quantity");
        pat_med = new Label("Patient medicine");
        pat_Wardrequired = new Label("Ward Required");

        tpat_id = new TextField();
        tpat_name = new TextField();
        tpat_symptoms=new TextField();
        tpat_diag = new TextField();
        tpat_med = new TextField();
        tpat_quantity = new TextField();
        
        try {
            Connection con = DatabaseOperation.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM patient where id='"+id+"'");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                tpat_id.setText(Rs.getString("id"));
                tpat_name.setText(Rs.getString("Name"));
                tpat_symptoms.setText(Rs.getString("Symptoms"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Wardrequired = new Choice();
        Wardrequired.add("---Select---");
        Wardrequired.add("Yes");
        Wardrequired.add("No");

        submit = new Button("REGISTER");
        exit = new Button("EXIT");

        title.setFont(new Font(Font.DIALOG, Font.BOLD, 23));
        pat_id.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        pat_name.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        pat_symptoms.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        pat_diag.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        pat_med.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        pat_quantity.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        pat_Wardrequired.setFont(new Font(Font.DIALOG, Font.BOLD, 15));

        title.setForeground(Color.white);
        pat_id.setForeground(Color.white);
        pat_name.setForeground(Color.white);
        pat_symptoms.setForeground(Color.white);
        pat_diag.setForeground(Color.white);
        pat_med.setForeground(Color.white);
        pat_quantity.setForeground(Color.white);
        pat_Wardrequired.setForeground(Color.white);

        title.setBounds(210, 50, 300, 50);
        pat_id.setBounds(75, 130, 100, 50);
        pat_name.setBounds(75, 180, 100, 50);
        pat_symptoms.setBounds(75,230,140,50);
        pat_diag.setBounds(75, 280, 140, 50);
        pat_med.setBounds(75, 330, 140, 50);
        pat_quantity.setBounds(75, 380, 140, 50);
        pat_Wardrequired.setBounds(75, 430, 140, 50);

        tpat_id.setBounds(225, 140, 225, 25);
        tpat_name.setBounds(225, 190, 225, 25);
        tpat_symptoms.setBounds(225,240,225,25);
        tpat_diag.setBounds(225, 290, 225, 25);
        tpat_med.setBounds(225, 340, 225, 25);
        tpat_quantity.setBounds(225, 390, 225, 25);
        Wardrequired.setBounds(225, 440, 225, 25);

        tpat_id.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 15));
        tpat_name.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
        tpat_symptoms.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
        tpat_diag.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
        tpat_med.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
        tpat_quantity.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
        Wardrequired.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));

        submit.setForeground(Color.white);
        submit.setBackground(Color.gray);
        submit.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));

        exit.setForeground(Color.white);
        exit.setBackground(Color.gray);
        exit.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));

        submit.setBounds(150, 490, 90, 25);
        exit.setBounds(290, 490, 75, 25);

        add(title);
        add(pat_id);
        add(pat_name);
        add(pat_symptoms);
        add(pat_diag);
        add(pat_med);
        add(pat_quantity);
        add(pat_Wardrequired);

        add(tpat_id);
        add(tpat_name);
        add(tpat_symptoms);
        add(tpat_diag);
        add(tpat_med);
        add(tpat_quantity);
        add(Wardrequired);

        add(submit);
        add(exit);

        setLayout(null);
        setBounds(100,100,1250, 800);
        setTitle("Patient Diagnosis");
        setBackground(Color.decode("#F08080"));
        setVisible(true);

        submit.addActionListener(this);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            //DIagonis
            if (!Pattern.matches("^[A-Za-z||,]{1,100}$", tpat_diag.getText()) || (tpat_diag.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter valid diagnosis!", "Diagnosis", JOptionPane.ERROR_MESSAGE);
            } //Medicine
            else if (!Pattern.matches("^[A-Za-z||,]{1,100}$", tpat_diag.getText()) || (tpat_diag.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter valid Medicine!", "Medicine", JOptionPane.ERROR_MESSAGE);
            } else if (Pattern.matches("---Select---", Wardrequired.getSelectedItem())) {
                JOptionPane.showMessageDialog(submit, "please select ward");
            } else {

                try {
                    int id = Integer.parseInt(tpat_id.getText());
                    String name = tpat_name.getText();
                    String diagonis = tpat_diag.getText();
                    String symptoms=tpat_symptoms.getText();
                    String medicine = tpat_med.getText();
                    String quantity = tpat_quantity.getText();
                    String Warequired = Wardrequired.getSelectedItem();
                    Random random = new Random();

                    //int medid = random.nextInt(2147483647);
                    String medid = String.format("%04d", random.nextInt(10000));

                    Connection con = DatabaseOperation.getConnection();
                    String query = "insert into diagnosis values(?,?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, medid);
                    pstmt.setString(2, name);
                    pstmt.setString(3, diagonis);
                    pstmt.setString(4, medicine);
                    pstmt.setString(5, quantity);
                    pstmt.setString(6, Warequired);
                    pstmt.setInt(7, id);

                    pstmt.executeUpdate();
                    con.setAutoCommit(true);
                    JOptionPane.showMessageDialog(this, "INSERTED SUCCESSFULLY!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "^^^" + ex.toString());
                }

            }
        }

    }
}
