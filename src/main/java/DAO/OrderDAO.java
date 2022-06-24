package DAO;

import config.AppConfig;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final String SELECT_ALL_SQL = "select orders.id, orders.customer, orders.address, coffee.name, coffee.country, orders.sum\n" +
            "from orders inner join coffee on orders.product_id = coffee.id;";
    private static final String SELECT_BY_ID = "select sum, product_id from orders where id = ?;";
    private static final String INSERT_SQL = "begin;\n" +
            "insert into orders (customer, address, sum, product_id)\n" +
            "values (?, ?, ?, ?);\n" +
            "update coffee set amount = amount - (?) where id = ?;\n" +
            "commit;";
    private static final String DELETE_SQL = "begin;\n" +
            "delete from orders where id = ?;\n" +
            "update coffee set amount = amount + ? where id = ?;\n" +
            "commit;";

    public List<Order> selectAllOrders() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = AppConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String customer = resultSet.getString("customer");
                String address = resultSet.getString("address");
                String sort = resultSet.getString("name");
                String country = resultSet.getString("country");
                int sum = resultSet.getInt("sum");
                orders.add(new Order(id, customer, address, sum, sort, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order selectOrderById(int id) {
        Order order = null;

        try (Connection connection = AppConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int sum = resultSet.getInt("sum");
                int productId = resultSet.getInt("product_id");
                order = new Order(productId, sum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public void insertOrder(Order order) {
        try (Connection connection = AppConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);) {

            preparedStatement.setString(1, order.getCustomer());
            preparedStatement.setString(2, order.getAddress());
            preparedStatement.setInt(3, order.getSum());
            preparedStatement.setInt(4, order.getProductId());
            preparedStatement.setInt(5, order.getSum());
            preparedStatement.setInt(6, order.getProductId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int id) throws SQLException {
        Order order = selectOrderById(id);
        boolean rowDeleted;

        try (Connection connection = AppConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);) {

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, order.getSum());
            preparedStatement.setInt(3, order.getProductId());
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
    }
}
