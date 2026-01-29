import javax.swing.*;
import java.sql.*;

public class CancellationForm extends JFrame {

    JTextField pnrField;
    JTextArea detailsArea;
    JButton searchBtn, cancelBtn;

    public CancellationForm() {

        setTitle("Ticket Cancellation");
        setSize(450, 400);
        setLayout(null);

        JLabel l1 = new JLabel("Enter PNR Number:");

        pnrField = new JTextField();
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(detailsArea);

        searchBtn = new JButton("Submit");
        cancelBtn = new JButton("OK (Cancel Ticket)");

        l1.setBounds(30, 20, 150, 25);
        pnrField.setBounds(180, 20, 150, 25);
        scroll.setBounds(30, 60, 370, 200);
        searchBtn.setBounds(80, 280, 120, 30);
        cancelBtn.setBounds(220, 280, 150, 30);

        add(l1); add(pnrField);
        add(scroll);
        add(searchBtn); add(cancelBtn);

        // 🔹 SEARCH PNR
        searchBtn.addActionListener(e -> {

            String pnrText = pnrField.getText().trim();
            if (pnrText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter PNR number");
                return;
            }

            try {
                int pnr = Integer.parseInt(pnrText);

                Connection con = DBConnection.getConnection();
                if (con == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed");
                    return;
                }

                PreparedStatement ps = con.prepareStatement(
                        "SELECT pnr,name,age,gender,train_no,train_name,class_type,journey_date,source,destination FROM reservation WHERE pnr=?"
                );
                ps.setInt(1, pnr);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    detailsArea.setText(
                            "PNR Number : " + rs.getInt(1) + "\n" +
                            "Name       : " + rs.getString(2) + "\n" +
                            "Age        : " + rs.getInt(3) + "\n" +
                            "Gender     : " + rs.getString(4) + "\n" +
                            "Train No   : " + rs.getString(5) + "\n" +
                            "Train Name : " + rs.getString(6) + "\n" +
                            "Class      : " + rs.getString(7) + "\n" +
                            "Journey Dt : " + rs.getString(8) + "\n" +
                            "From       : " + rs.getString(9) + "\n" +
                            "To         : " + rs.getString(10)
                    );
                } else {
                    detailsArea.setText("");
                    JOptionPane.showMessageDialog(null, "PNR not found");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "PNR must be numeric");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unexpected error");
            }
        });


        // 🔹 CONFIRM CANCELLATION
        cancelBtn.addActionListener(e -> {
            String pnrText = pnrField.getText().trim();

            if (pnrText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter PNR first");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to cancel this ticket?",
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = DBConnection.getConnection();
                    PreparedStatement ps =
                            con.prepareStatement("DELETE FROM reservation WHERE pnr=?");
                    ps.setInt(1, Integer.parseInt(pnrText));
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully");
                    detailsArea.setText("");
                    pnrField.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cancellation failed");
                }
            }
        });

        setVisible(true);
    }
}






//
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class CancellationForm extends JFrame {
//
//    JTextField pnr;
//    JButton search, confirm;
//
//    public CancellationForm() {
//
//        setTitle("Cancel Ticket");
//        setSize(300, 200);
//        setLayout(null);
//
//        JLabel l1 = new JLabel("PNR Number:");
//        pnr = new JTextField();
//        search = new JButton("Search");
//        confirm = new JButton("Confirm Cancel");
//
//        l1.setBounds(30, 30, 100, 25);
//        pnr.setBounds(140, 30, 100, 25);
//        search.setBounds(40, 70, 90, 30);
//        confirm.setBounds(140, 70, 120, 30);
//
//        add(l1); add(pnr);
//        add(search); add(confirm);
//
//        confirm.addActionListener(e -> {
//            try {
//                Connection con = DBConnection.getConnection();
//                PreparedStatement ps = con.prepareStatement(
//                    "DELETE FROM reservation WHERE pnr=?"
//                );
//                ps.setInt(1, Integer.parseInt(pnr.getText()));
//                ps.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        setVisible(true);
//    }
//}
//
