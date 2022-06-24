package web;

import DAO.CoffeeDAO;
import DAO.OrderDAO;
import model.Coffee;
import model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class CoffeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoffeeDAO coffeeDAO;
    private OrderDAO orderDAO;

    public CoffeeServlet() {
        this.coffeeDAO = new CoffeeDAO();
        this.orderDAO = new OrderDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                try {
                    insertCoffee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deleteCoffee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/update":
                try {
                    updateCoffee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/orders":
                try {
                    orders(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/insertorder":
                try {
                    insertOrder(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/deleteorder":
                try {
                    deleteOrder(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listCoffee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("coffee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCoffee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        String name = request.getParameter("name");
        String country = request.getParameter("country");
        int amount = Integer.parseInt(request.getParameter("amount"));

        Coffee newCoffee = new Coffee(name, country, amount);
        coffeeDAO.insertCoffee(newCoffee);
        response.sendRedirect("/list");
    }

    private void deleteCoffee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        coffeeDAO.deleteCoffee(id);
        response.sendRedirect("/list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        Coffee exestingCoffee = coffeeDAO.selectCoffeeById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("coffee-form.jsp");
        request.setAttribute("coffee", exestingCoffee);
        dispatcher.forward(request, response);
    }

    private void updateCoffee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String country = request.getParameter("country");
        int amount = Integer.parseInt(request.getParameter("amount"));

        Coffee coffee = new Coffee(id, name, country, amount);
        coffeeDAO.updateCoffee(coffee);
        response.sendRedirect("/list");
    }

    private void listCoffee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {

        List<Coffee> listCoffee = coffeeDAO.selectAllCoffee();

        request.setAttribute("listCoffee", listCoffee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("coffee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        String customer = request.getParameter("customer");
        String address = request.getParameter("address");
        int sum = Integer.parseInt(request.getParameter("sum"));
        int productId = Integer.parseInt(request.getParameter("product_id"));

        Order newOrder = new Order(customer, address, sum, productId);
        orderDAO.insertOrder(newOrder);
        response.sendRedirect("/orders");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        orderDAO.deleteOrder(id);
        response.sendRedirect("/orders");
    }

    private void orders(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {

        List<Order> orders = orderDAO.selectAllOrders();

        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
        dispatcher.forward(request, response);
    }

}
