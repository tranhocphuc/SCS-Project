// Change user account info

package usrAccountPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChangeInfo
        extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel updateInfoPromptLabel;

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

    public ChangeInfo(final String userName, final int columnID) {
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
                String newValue = ChangeInfo.this.textField.getText();
                try {
                    Class.forName("org.h2.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:h2:~/test1;IFEXISTS=TRUE", "admin", "administrator");
                    Statement stmt = connection.createStatement();
                    ResultSet results = stmt.executeQuery("SELECT * FROM registration");
                    ResultSetMetaData metadata = results.getMetaData();
                    String columnName = metadata.getColumnName(columnID);
                    PreparedStatement st = connection.prepareStatement("Update registration set " + columnName + " =? where username=?");
                    st.setString(1, newValue);
                    st.setString(2, userName);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnSearch, "Your info has been successfully updated");
                    dispose();
                } catch (SQLException | ClassNotFoundException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btnSearch.setFont(new Font("Tahoma", 0, 29));
        btnSearch.setBackground(new Color(240, 240, 240));
        btnSearch.setBounds(438, 127, 170, 59);
        this.contentPane.add(btnSearch);
        this.updateInfoPromptLabel = new JLabel("Update Info :");
        this.updateInfoPromptLabel.setFont(new Font("Tahoma", 0, 30));
        this.updateInfoPromptLabel.setBounds(45, 37, 326, 67);
        this.contentPane.add(this.updateInfoPromptLabel);
    }
}
