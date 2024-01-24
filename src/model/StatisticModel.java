package model;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionManager;
import entity.SellsPerMonth;

public class StatisticModel extends ConnectionManager {

    public StatisticModel() {
    }

    public List<SellsPerMonth> getAll() {
        List<SellsPerMonth> stat = new ArrayList<>();
        try {
            createConnection();
            String sql = "SELECT EXTRACT(MONTH FROM am.months) AS month, " +
                    "COALESCE(SUM(p.quantity * p.price), 0) AS total " +
                    "FROM all_months am " +
                    "LEFT JOIN purchases s ON DATE_TRUNC('month', p.date) = am.months " +
                    "WHERE EXTRACT(YEAR FROM s.date) = EXTRACT(YEAR FROM CURRENT_DATE) " +
                    "GROUP BY month " +
                    "ORDER BY month;";
            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stat.add(new SellsPerMonth(resultSet.getInt("month"), resultSet.getFloat("total")));
            }
            preparedStatement.close();
            connection.close();
            return stat;
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
