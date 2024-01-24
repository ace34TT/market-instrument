package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionManager;
import entity.InstrumentType;

public class InstrumentTypeModel extends ConnectionManager {

    public InstrumentTypeModel() {
    }

    public void insert(InstrumentType type) throws SQLException {
        String sql = "INSERT INTO instrument_types (name) VALUES (?)";
        createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, type.getName());

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

        preparedStatement.close();
        connection.close();
    }

    public List<InstrumentType> getAll() {
        List<InstrumentType> types = new ArrayList<>();
        try {
            createConnection();
            String sql = "SELECT * FROM instrument_types";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                types.add(new InstrumentType(resultSet.getString("id"), resultSet.getString("name")));
            }
            preparedStatement.close();
            connection.close();
            return types;
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
