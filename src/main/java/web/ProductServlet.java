package web;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import model.Chocolate;
import model.Coffee;
import model.Tea;

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
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action) {
            case "/newcoffee":
                showNewCoffeeForm(request, response);
                break;
            case "/newtea":
                showNewTeaForm(request, response);
                break;
            case "/newchocolate":
                showNewChocolateForm(request, response);
                break;
            case "/insertcoffee":
                try {
                    insertCoffee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/inserttea":
                try {
                    insertTea(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/insertchocolate":
                try {
                    insertChocolate(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/deletecoffee":
                try {
                    deleteCoffee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/deletetea":
                try {
                    deleteTea(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/deletechocolate":
                try {
                    deleteChocolate(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/editcoffee":
                try {
                    showEditCoffeeForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edittea":
                try {
                    showEditTeaForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/editchocolate":
                try {
                    showEditChocolateForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/updatecoffee":
                try {
                    updateCoffee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/updatetea":
                try {
                    updateTea(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/updatechocolate":
                try {
                    updateChocolate(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listProduct(request, response);
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

    private void showNewCoffeeForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("coffee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewTeaForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("tea-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewChocolateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("chocolate-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCoffee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        String name = request.getParameter("name");
        String region = request.getParameter("region");
        int grownHeight = Integer.parseInt(request.getParameter("grownHeight"));

        Coffee newCoffee = new Coffee(name, region, grownHeight);
        productDAO.insertCoffee(newCoffee);
        response.sendRedirect("/list");
    }

    private void insertTea(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        String name = request.getParameter("name");
        String province = request.getParameter("province");
        String type = request.getParameter("type");

        Tea newTea = new Tea(name, province, type);
        productDAO.insertTea(newTea);
        response.sendRedirect("/list");
    }

    private void insertChocolate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        String name = request.getParameter("name");
        int percent = Integer.parseInt(request.getParameter("percent"));
        String country = request.getParameter("country");

        Chocolate newChocolate = new Chocolate(name, percent, country);
        productDAO.insertChocolate(newChocolate);
        response.sendRedirect("/list");
    }

    private void deleteCoffee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        productDAO.deleteCoffee(id);
        response.sendRedirect("/list");
    }

    private void deleteTea(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        productDAO.deleteTea(id);
        response.sendRedirect("/list");
    }

    private void deleteChocolate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        productDAO.deleteChocolate(id);
        response.sendRedirect("/list");
    }

    private void showEditCoffeeForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        Coffee existingCoffee = productDAO.selectByIdCoffee(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("coffee-form.jsp");
        request.setAttribute("coffee", existingCoffee);
        dispatcher.forward(request, response);
    }

    private void showEditTeaForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        Tea existingTea = productDAO.selectByIdTea(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("tea-form.jsp");
        request.setAttribute("tea", existingTea);
        dispatcher.forward(request, response);
    }

    private void showEditChocolateForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        Chocolate existingChocolate = productDAO.selectByIdChocolate(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("chocolate-form.jsp");
        request.setAttribute("chocolate", existingChocolate);
        dispatcher.forward(request, response);
    }

    private void updateCoffee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String region = request.getParameter("region");
        int grownHeight = Integer.parseInt(request.getParameter("grownHeight"));

        Coffee coffee = new Coffee(id, name, region, grownHeight);
        productDAO.updateCoffee(coffee);
        response.sendRedirect("/list");
    }

    private void updateTea(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String province = request.getParameter("province");
        String type = request.getParameter("type");

        Tea tea = new Tea(id, name, province, type);
        productDAO.updateTea(tea);
        response.sendRedirect("/list");
    }

    private void updateChocolate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String country = request.getParameter("country");
        int percent = Integer.parseInt(request.getParameter("percent"));

        Chocolate chocolate = new Chocolate(id, name, percent, country);
        productDAO.updateChocolate(chocolate);
        response.sendRedirect("/list");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {

        List<Coffee> listCoffee = productDAO.selectAllCoffee();
        List<Tea> listTea = productDAO.selectAllTea();
        List<Chocolate> listChocolate = productDAO.selectAllChocolate();

        request.setAttribute("listCoffee", listCoffee);
        request.setAttribute("listTea", listTea);
        request.setAttribute("listChocolate", listChocolate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }
}
