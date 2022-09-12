// Graphical user interface for registration of new user account
package usrAccountPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserRegistration
        extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JButton backButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private JLabel label;
    private JPanel contentPane;
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test1;IFEXISTS=TRUE";
    static final String USER = "admin";
    static final String PASS = "administrator";

    public UserRegistration() {
        setDefaultCloseOperation(3);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager) null);

        JLabel lblNewLabel = new JLabel("User Registration");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", 0, 40));
        lblNewLabel.setBounds(400, 20, 300, 93);
        this.contentPane.add(lblNewLabel);

        this.textField = new JTextField();
        this.textField.setFont(new Font("Tahoma", 0, 32));
        this.textField.setBounds(481, 170, 281, 68);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        this.passwordField = new JPasswordField();
        this.passwordField.setFont(new Font("Tahoma", 0, 32));
        this.passwordField.setBounds(481, 286, 281, 68);
        this.contentPane.add(this.passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", 0, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        this.contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", 0, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        this.contentPane.add(lblPassword);

        this.backButton = new JButton("Back");
        this.backButton.setFont(new Font("Tahoma", 0, 26));
        this.backButton.setBounds(345, 392, 162, 73);
        this.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserRegistration.this.dispose();
            }
        });

        this.btnNewButton = new JButton("Register");
        this.btnNewButton.setFont(new Font("Tahoma", 0, 26));
        this.btnNewButton.setBounds(545, 392, 162, 73);
        this.btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = UserRegistration.this.textField.getText();
                String password = UserRegistration.this.passwordField.getText();
                try {
                    Class.forName("org.h2.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:h2:~/test1;IFEXISTS=TRUE", "admin", "administrator");

                    PreparedStatement st = conn.prepareStatement("Select username from registration where username=?");
                    st.setString(1, userName);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(UserRegistration.this.btnNewButton, "Username existed, please choose another one.");
                    } else {
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Registration VALUES (?, ?, 'placeholding 1', 'placeholding 2')");
                        stmt.setString(1, userName);
                        stmt.setString(2, password);
                        stmt.executeUpdate();

                        stmt.close();
                        conn.close();
                        JOptionPane.showMessageDialog(UserRegistration.this.btnNewButton, "New account succesfully registered");
                    }

                } catch (SQLException | ClassNotFoundException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        this.contentPane.add(this.btnNewButton);
        this.contentPane.add(this.backButton);

        this.label = new JLabel("");
        this.label.setBounds(0, 0, 1008, 562);
        this.contentPane.add(this.label);
    }
}
