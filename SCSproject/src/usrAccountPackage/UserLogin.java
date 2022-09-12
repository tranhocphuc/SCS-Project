// Graphical user interface for account log in. Main class of project.
package usrAccountPackage;

import mainPackage.JFrameMain;
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

public class UserLogin
        extends JFrame {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test1;IFEXISTS=TRUE";
    static final String USER = "admin";
    static final String PASS = "administrator";
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JButton regButton;
    private JLabel label;
    private JPanel contentPane;

    public static void main(String[] args) {
        h2Database.createTable();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                    frame.setTitle("User-Login");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserLogin() {
        setDefaultCloseOperation(3);
        setBounds(450, 190, 1014, 597);

        setResizable(false);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager) null);
        
        JLabel appName = new JLabel("Vital Covid-19 information");
        appName.setForeground(Color.BLACK);
        appName.setFont(new Font("Times New Roman", 0, 40));
        appName.setBounds(280, 20, 500, 93);
        this.contentPane.add(appName);
        
        JLabel logInLabel = new JLabel("Login");
        logInLabel.setForeground(Color.BLACK);
        logInLabel.setFont(new Font("Times New Roman", 0, 38));
        logInLabel.setBounds(430, 75, 273, 93);
        this.contentPane.add(logInLabel);

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

        this.regButton = new JButton("Register");
        this.regButton.setFont(new Font("Tahoma", 0, 26));
        this.regButton.setBounds(322, 392, 162, 73);
        this.regButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserRegistration newUser = new UserRegistration();
                newUser.setTitle("Registration");
                newUser.setVisible(true);
            }
        });

        this.btnNewButton = new JButton("Login");
        this.btnNewButton.setFont(new Font("Tahoma", 0, 26));
        this.btnNewButton.setBounds(545, 392, 162, 73);
        this.btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = UserLogin.this.textField.getText();
                String password = UserLogin.this.passwordField.getText();
                try {
                    Class.forName("org.h2.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:h2:~/test1;IFEXISTS=TRUE", "admin", "administrator");

                    PreparedStatement st = conn.prepareStatement("Select username, password from registration where username=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        UserLogin.this.dispose();
                        JFrameMain frame = new JFrameMain();
                        frame.setUserName(userName);
                        frame.setVisible(true);
                        JOptionPane.showMessageDialog(UserLogin.this.btnNewButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(UserLogin.this.btnNewButton, "Wrong Username & Password");
                    }
                } catch (SQLException | ClassNotFoundException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        this.contentPane.add(this.btnNewButton);
        this.contentPane.add(this.regButton);

        this.label = new JLabel("");
        this.label.setBounds(0, 0, 1008, 562);
        this.contentPane.add(this.label);
    }
}
