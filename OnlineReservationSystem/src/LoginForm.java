
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame {

    JTextField user;
    JPasswordField pass;
    JButton login;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Password:");

        user = new JTextField();
        pass = new JPasswordField();
        login = new JButton("Login");

        l1.setBounds(30, 30, 80, 25);
        user.setBounds(120, 30, 120, 25);

        l2.setBounds(30, 70, 80, 25);
        pass.setBounds(120, 70, 120, 25);

        login.setBounds(100, 120, 80, 25);

        add(l1); add(user);
        add(l2); add(pass);
        add(login);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DBConnection.getConnection();
                    PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM users WHERE username=? AND password=?"
                    );
                    ps.setString(1, user.getText());
                    ps.setString(2, new String(pass.getPassword()));

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        new ReservationForm();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Login");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
