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
    private static final String SELECT_ALL_SQL = "select orders.customer, orders.address, coffee.name, coffee.country, orders.sum\n" +
            "from orders inner join coffee on orders.product_id = coffee.id;";
    private static final String SELECT_FOR_DELETE = "select coffee.id, coffee.amount\n" +
            "from coffee inner join orders on coffee.id = orders.product_id\n" +
            "where orders.id = ?;";
    private static final String INSERT_SQL = "begin;\n" +
            "insert into orders (customer, address, sum, product_id)\n" +
            "values (?, ?, ?, ?);\n" +
            "update coffee set amount = amount - ? where id = ?;\n" +
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
                String customer = resultSet.getString("customer");
                String address = resultSet.getString("address");
                String sort = resultSet.getString("name");
                String country = resultSet.getString("country");
                int sum = resultSet.getInt("sum");
                orders.add(new Order(customer, address, sum, sort, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
