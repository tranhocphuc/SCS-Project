// Graphical user interface for user to manage their account

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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserHome
        extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {
    }

    public UserHome(final String userName) {
        setDefaultCloseOperation(3);
        setBounds(200, 100, 1264, 900);
        setResizable(false);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager) null);
        final JButton logOutButton = new JButton("Logout");
        logOutButton.setForeground(new Color(243, 126, 126));
        logOutButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        logOutButton.setFont(new Font("Tahoma", 0, 39));
        logOutButton.setBounds(100, 118, 491, 114);
        this.contentPane.add(logOutButton);
        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(logOutButton, "Are you sure?");
                if (a == 0) {
                    UserHome.this.dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("User-Login");
                    obj.setVisible(true);
                }
            }
        });

        JButton changePassButton = new JButton("Change-password\r\n");
        changePassButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        changePassButton.setFont(new Font("Tahoma", 0, 35));
        changePassButton.setBounds(100, 320, 491, 114);
        this.contentPane.add(changePassButton);
        changePassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userName);
                bo.setTitle("Change Password");
                bo.setVisible(true);
            }
        });
        JButton changeInfoButton1 = new JButton("Update");
        changeInfoButton1.setBackground(UIManager.getColor("Button.disabledForeground"));
        changeInfoButton1.setFont(new Font("Tahoma", 0, 20));
        changeInfoButton1.setBounds(640, 160, 100, 60);
        this.contentPane.add(changeInfoButton1);
        changeInfoButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeInfo changeInfo = new ChangeInfo(userName, 3);
                changeInfo.setTitle("Change Info");
                changeInfo.setVisible(true);
            }
        });

        JButton changeInfoButton2 = new JButton("Update");
        changeInfoButton2.setBackground(UIManager.getColor("Button.disabledForeground"));
        changeInfoButton2.setFont(new Font("Tahoma", 0, 20));
        changeInfoButton2.setBounds(640, 240, 100, 60);
        this.contentPane.add(changeInfoButton2);
        changeInfoButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeInfo changeInfo = new ChangeInfo(userName, 4);
                changeInfo.setTitle("Change Info");
                changeInfo.setVisible(true);
            }
        });
        JButton backToMenuButton = new JButton("Back to menu\r\n");
        backToMenuButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        backToMenuButton.setFont(new Font("Tahoma", 0, 20));
        backToMenuButton.setBounds(0, 0, 200, 50);
        this.contentPane.add(backToMenuButton);
        backToMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserHome.this.dispose();
                JFrameMain frame = new JFrameMain();
                frame.setUserName(userName);
                frame.setVisible(true);
            }
        });
        String USER = "admin";
        String PASS = "administrator";
        String JDBC_DRIVER = "org.h2.Driver";
        String DB_URL = "jdbc:h2:~/test1;IFEXISTS=TRUE";
        JLabel placeholder1 = new JLabel("State:");
        placeholder1.setForeground(Color.BLACK);
        placeholder1.setFont(new Font("Times New Roman", 0, 38));
        placeholder1.setBounds(780, 150, 273, 93);
        this.contentPane.add(placeholder1);
        JLabel placeholder2 = new JLabel("District:");
        placeholder2.setForeground(Color.BLACK);
        placeholder2.setFont(new Font("Times New Roman", 0, 38));
        placeholder2.setBounds(780, 230, 273, 93);
        this.contentPane.add(placeholder2);
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM registration WHERE username=?;");
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                JLabel placeholder1Value = new JLabel(rs.getString("state"));
                placeholder1Value.setForeground(Color.BLACK);
                placeholder1Value.setFont(new Font("Times New Roman", 0, 38));
                placeholder1Value.setBounds(940, 150, 273, 93);
                this.contentPane.add(placeholder1Value);

                JLabel placeholder2Value = new JLabel(rs.getString("district"));
                placeholder2Value.setForeground(Color.BLACK);
                placeholder2Value.setFont(new Font("Times New Roman", 0, 38));
                placeholder2Value.setBounds(940, 230, 273, 93);
                this.contentPane.add(placeholder2Value);
            }
        } catch (SQLException | ClassNotFoundException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
