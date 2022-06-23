package DAO;

import config.AppConfig;
import model.Coffee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDAO {
    private static final String SELECT_ALL_SQL = "select * from coffee";
    private static final String SELECT_BY_ID = "select id, name, country, amount from coffee where id = ?";
    private static final String INSERT_SQL = "insert into coffee (name, country, amount)\n" +
            "values (?, ?, ?)";
    private static final String UPDATE_SQL = "update coffee set name = ?, country = ?, amount = ? " +
            "where id = ?";
    private static final String DELETE_SQL = "delete from coffee where id = ?";


    public void insertCoffee(Coffee coffee) throws SQLException {
        try (Connection connection = AppConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);) {

            preparedStatement.setString(1, coffee.getName());
            preparedStatement.setString(2, coffee.getCountry());
            preparedStatement.setInt(3, coffee.getAmount());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCoffee(Coffee coffee) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = AppConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);) {
            preparedStatement.setString(1, coffee.getName());
            preparedStatement.setString(2, coffee.getCountry());
            preparedStatement.setInt(3, coffee.getAmount());
            preparedStatement.setInt(4, coffee.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
    }

    public List<Coffee> selectAllCoffee() {
        List<Coffee> coffee = new ArrayList<>();

        try (Connection connection = AppConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                int amount = resultSet.getInt("amount");
                coffee.add(new Coffee(id, name, country, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coffee;
    }

    public Coffee selectCoffeeById(int id) {
        Coffee coffee = null;

        try (Connection connection = AppConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                int amount = resultSet.getInt("amount");
                coffee = new Coffee(id, name, country, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coffee;
    }

    public void deleteCoffee(int id) throws SQLException {
        boolean rowDeleted;

        try (Connection connection = AppConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);) {

            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
    }
}
