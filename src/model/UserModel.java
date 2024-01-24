package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionManager;
import entity.User;

public class UserModel extends ConnectionManager {

    public UserModel() {
    }

    public void signup(User user) throws SQLException {
        createConnection();
        String sql = "INSERT INTO instruments (name, email, password) VALUES (?, ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword());
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
        preparedStatement.close();
        connection.close();
    }

    public User signing(User user) {
        try {
            createConnection();
            String query = "SELECT * FROM Users WHERE email = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getEmail());
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            String hashedPassword = rs.getString("password");
            if (user.getPassword().equals(hashedPassword)) {
                return new User(rs.getString("id"), rs.getString("name"), user.getEmail(), hashedPassword,
                        rs.getString("role"));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
