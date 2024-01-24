package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionManager;
import entity.Instrument;

public class InstrumentModel extends ConnectionManager {

    public InstrumentModel() {
    }

    public List<Instrument> getAll() {
        List<Instrument> instruments = new ArrayList<>();
        try {
            createConnection();
            String sql = "SELECT * FROM v_instruments";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                instruments.add(new Instrument(resultSet.getString("instrument_id"),
                        resultSet.getString("instrument_name"), resultSet.getString("type_id"),
                        resultSet.getString("type_name"), resultSet.getString("category_id"),
                        resultSet.getString("category_name"), resultSet.getString("preview"),
                        resultSet.getFloat("calculated_price")));
            }
            preparedStatement.close();
            connection.close();
            return instruments;
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return null;
    }

    public void insert(Instrument instrument) throws SQLException {
        createConnection();
        String sql = "INSERT INTO instruments (name, type, category) VALUES (?, ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, instrument.getName());
        preparedStatement.setString(2, instrument.getTypeId());
        preparedStatement.setString(3, instrument.getCategoryId());

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

        preparedStatement.close();
        connection.close();
    }

    public List<Instrument> find(String queryCond) {
        List<Instrument> instruments = new ArrayList<>();

        try {
            createConnection();
            String query = "SELECT * FROM v_instruments WHERE 1=1 " + queryCond;

            // Execute the query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setString(1, queryCond);

            System.out.println("here is your query");
            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            // Convert the ResultSet into a list of Instruments

            while (resultSet.next()) {
                // Assuming Instrument has a constructor that takes a ResultSet
                instruments.add(new Instrument(resultSet.getString("instrument_id"),
                        resultSet.getString("instrument_name"), resultSet.getString("type_id"),
                        resultSet.getString("type_name"), resultSet.getString("category_id"),
                        resultSet.getString("category_name"), resultSet.getString("preview"),
                        resultSet.getFloat("calculated_price")));
            }
            preparedStatement.close();
            connection.close();
            return instruments;
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return instruments;
    }

    public void buy(String instrumentId, float price, int quantity, String userId) throws SQLException {
        createConnection();
        String sql = "INSERT INTO purchases (instrument_id, price, quantity , user_id , created_at) VALUES (?, ? , ? ,  ?, NOW())";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, instrumentId);
        preparedStatement.setFloat(2, price);
        preparedStatement.setInt(3, quantity);
        preparedStatement.setString(4, userId);

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

        preparedStatement.close();
        connection.close();
    }
}
