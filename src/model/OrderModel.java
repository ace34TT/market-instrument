package model;

import database.ConnectionManager;
import entity.Order;

public class OrderModel extends ConnectionManager {
    public OrderModel() {
    }

    public Order insert() {
        String sql = "INSERT INTO instrument_types (name) VALUES (?)";
        createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, type.getName());

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

        preparedStatement.close();
        connection.close();
    }

}
