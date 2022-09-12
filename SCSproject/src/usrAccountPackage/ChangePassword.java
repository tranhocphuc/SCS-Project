// Change user account password

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
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChangePassword
        extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblEnterNewPassword;
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test1;IFEXISTS=TRUE";
    static final String USER = "admin";
    static final String PASS = "administrator";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    public ChangePassword(final String name) {
        setDefaultCloseOperation(2);
        setBounds(450, 360, 1024, 234);
        setResizable(false);

        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager) null);
        this.textField = new JTextField();
        this.textField.setFont(new Font("Tahoma", 0, 34));
        this.textField.setBounds(373, 35, 609, 67);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        final JButton btnSearch = new JButton("Enter");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newPass = ChangePassword.this.textField.getText();
                try {
                    System.out.println("update password name " + name);
                    System.out.println("update password");
                    Class.forName("org.h2.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:h2:~/test1;IFEXISTS=TRUE", "admin", "administrator");
                    PreparedStatement st = conn.prepareStatement("Update registration set password=? where username=?");
                    st.setString(1, newPass);
                    st.setString(2, name);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnSearch, "Password has been successfully changed");
                } catch (SQLException | ClassNotFoundException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btnSearch.setFont(new Font("Tahoma", 0, 29));
        btnSearch.setBackground(new Color(240, 240, 240));
        btnSearch.setBounds(438, 127, 170, 59);
        this.contentPane.add(btnSearch);
        this.lblEnterNewPassword = new JLabel("Enter New Password :");
        this.lblEnterNewPassword.setFont(new Font("Tahoma", 0, 30));
        this.lblEnterNewPassword.setBounds(45, 37, 326, 67);
        this.contentPane.add(this.lblEnterNewPassword);
    }
}
