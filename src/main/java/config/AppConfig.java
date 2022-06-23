package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConfig {
    private static String jdbcURL = "jdbc:postgresql://localhost:5432/db_crud";
    private static String jdbcUser = "admin";
    private static String jdbcPassword = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
