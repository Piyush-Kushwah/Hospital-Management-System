package HospitalManagementsSystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        if (URL == null || URL.isBlank()) {
            throw new RuntimeException("DB_URL environment variable is not configured!");
        }

        if (USERNAME == null || USERNAME.isBlank()) {
            throw new RuntimeException("DB_USERNAME environment variable is not configured!");
        }

        if (PASSWORD == null || PASSWORD.isBlank()) {
            throw new RuntimeException("DB_PASSWORD environment variable is not configured!");
        }

        try {
            Connection connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            throw new RuntimeException(e);
        }
    }
}