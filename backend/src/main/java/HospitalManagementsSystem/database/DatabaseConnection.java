package HospitalManagementsSystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = System.getenv("DB_URL");

    private static final String USERNAME = System.getenv("DB_USERNAME");

    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}