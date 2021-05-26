package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String url = "jdbc:mysql://localhost:3306/cabinet_medical";
    private static String user = "admin";
    private static String passwd = "Azerty.123";

    private static Connection cn = null;


    private DbConnection() {
        try {
            cn = DriverManager.getConnection(url, user, passwd);
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        if (cn == null) {
            new DbConnection();
        }
        return cn;
    }

    public static void Fermer() {
        if (cn != null) {
            try {  cn.close(); }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
