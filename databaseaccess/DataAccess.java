package databaseaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
    private static Connection connection;

    public DataAccess() throws ClassNotFoundException, SQLException {
        connection = getConnection();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw11", "root", "root");
        }
        return connection;
    }
}
