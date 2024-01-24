package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    protected Connection connection;

    protected void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/market_instrument", "postgres",
                    "123");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
