// Set up database to store user account information.

package usrAccountPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class h2Database {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test1;";
    static final String USER = "admin";
    static final String PASS = "administrator";

    public static void createTable() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:h2:~/test1;", "admin", "administrator");

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS  REGISTRATION  ( username VARCHAR(255),  password VARCHAR(255),  state VARCHAR(255),  district VARCHAR(255),  PRIMARY KEY ( username ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException sQLException) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Finished creating table");
    }
}
