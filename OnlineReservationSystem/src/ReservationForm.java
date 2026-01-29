import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ReservationForm extends JFrame {

    JTextField name, age, trainName, date;
    JComboBox<String> gender, classType, trainNo, source, destination;
    JButton insert, cancel;

    public ReservationForm() {

        setTitle("Reservation Form");
        setSize(450, 480);
        setLayout(null);

        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Age");
        JLabel l3 = new JLabel("Gender");
        JLabel l4 = new JLabel("Train No");
        JLabel l5 = new JLabel("Train Name");
        JLabel l6 = new JLabel("Class");
        JLabel l7 = new JLabel("Journey Date");
        JLabel l8 = new JLabel("From");
        JLabel l9 = new JLabel("To");

        name = new JTextField();
        age = new JTextField();
        trainName = new JTextField();
        trainName.setEditable(false);
        date = new JTextField();

        gender = new JComboBox<>(new String[]{"Male", "Female"});
        classType = new JComboBox<>(new String[]{"Sleeper", "AC", "General"});

        // Train numbers dropdown
        trainNo = new JComboBox<>(new String[]{
                "Select",
                "12301",
                "12951",
                "12002"
        });

        // Source & Destination dropdown
        source = new JComboBox<>(new String[]{
                "Select", "Mumbai", "Delhi", "Pune", "Chennai"
        });

        destination = new JComboBox<>(new String[]{
                "Select", "Mumbai", "Delhi", "Pune", "Chennai"
        });

        insert = new JButton("Insert");
        cancel = new JButton("Cancel Ticket");

        int y = 20;
        JLabel[] labels = {l1,l2,l3,l4,l5,l6,l7,l8,l9};
        JComponent[] fields = {
                name, age, gender, trainNo, trainName,
                classType, date, source, destination
        };

        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(30, y, 120, 25);
            fields[i].setBounds(180, y, 180, 25);
            add(labels[i]);
            add(fields[i]);
            y += 35;
        }

        insert.setBounds(90, y, 100, 30);
        cancel.setBounds(220, y, 130, 30);
        add(insert);
        add(cancel);

        // 🔹 AUTO TRAIN NAME BASED ON TRAIN NUMBER
        trainNo.addActionListener(e -> {
            String tn = trainNo.getSelectedItem().toString();
            switch (tn) {
                case "12301":
                    trainName.setText("Rajdhani Express");
                    break;
                case "12951":
                    trainName.setText("Mumbai Rajdhani");
                    break;
                case "12002":
                    trainName.setText("Shatabdi Express");
                    break;
                default:
                    trainName.setText("");
            }
        });

        // 🔹 INSERT & GENERATE PNR
        insert.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO reservation VALUES (NULL,?,?,?,?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS
                );

                ps.setString(1, name.getText());
                ps.setInt(2, Integer.parseInt(age.getText()));
                ps.setString(3, gender.getSelectedItem().toString());
                ps.setString(4, trainNo.getSelectedItem().toString());
                ps.setString(5, trainName.getText());
                ps.setString(6, classType.getSelectedItem().toString());
                ps.setString(7, date.getText());
                ps.setString(8, source.getSelectedItem().toString());
                ps.setString(9, destination.getSelectedItem().toString());

                ps.executeUpdate();

                // 🔹 GET GENERATED PNR
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int pnr = rs.getInt(1);
                    JOptionPane.showMessageDialog(
                            null,
                            "Ticket Reserved Successfully\nPNR Number: " + pnr
                    );
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in Reservation");
            }
        });

        cancel.addActionListener(e -> new CancellationForm());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}










//
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class ReservationForm extends JFrame {
//
//    JTextField name, age, trainNo, trainName, date, from, to;
//    JComboBox<String> gender, classType;
//    JButton insert, cancel;
//
//    public ReservationForm() {
//
//        setTitle("Reservation Form");
//        setSize(400, 450);
//        setLayout(null);
//
//        JLabel l1 = new JLabel("Name");
//        JLabel l2 = new JLabel("Age");
//        JLabel l3 = new JLabel("Gender");
//        JLabel l4 = new JLabel("Train No");
//        JLabel l5 = new JLabel("Train Name");
//        JLabel l6 = new JLabel("Class");
//        JLabel l7 = new JLabel("Date");
//        JLabel l8 = new JLabel("From");
//        JLabel l9 = new JLabel("To");
//
//        name = new JTextField();
//        age = new JTextField();
//        trainNo = new JTextField();
//        trainName = new JTextField();
//        date = new JTextField();
//        from = new JTextField();
//        to = new JTextField();
//
//        gender = new JComboBox<>(new String[]{"Male", "Female"});
//        classType = new JComboBox<>(new String[]{"Sleeper", "AC", "General"});
//
//        insert = new JButton("Insert");
//        cancel = new JButton("Cancel Ticket");
//
//        int y = 20;
//        JLabel[] labels = {l1,l2,l3,l4,l5,l6,l7,l8,l9};
//        JComponent[] fields = {name,age,gender,trainNo,trainName,classType,date,from,to};
//
//        for (int i = 0; i < labels.length; i++) {
//            labels[i].setBounds(30, y, 100, 25);
//            fields[i].setBounds(150, y, 150, 25);
//            add(labels[i]);
//            add(fields[i]);
//            y += 35;
//        }
//
//        insert.setBounds(70, y, 100, 30);
//        cancel.setBounds(200, y, 120, 30);
//        add(insert);
//        add(cancel);
//
//        insert.addActionListener(e -> {
//            try {
//                Connection con = DBConnection.getConnection();
//                PreparedStatement ps = con.prepareStatement(
//                    "INSERT INTO reservation VALUES (NULL,?,?,?,?,?,?,?,?,?)"
//                );
//
//                ps.setString(1, name.getText());
//                ps.setInt(2, Integer.parseInt(age.getText()));
//                ps.setString(3, gender.getSelectedItem().toString());
//                ps.setString(4, trainNo.getText());
//                ps.setString(5, trainName.getText());
//                ps.setString(6, classType.getSelectedItem().toString());
//                ps.setString(7, date.getText());
//                ps.setString(8, from.getText());
//                ps.setString(9, to.getText());
//
//                ps.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Ticket Reserved Successfully");
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        cancel.addActionListener(e -> new CancellationForm());
//
//        setVisible(true);
//    }
//}
