package DAO;

import model.Chocolate;
import model.Coffee;
import model.Product;
import model.Tea;

import java.util.List;

public interface ProductDAO {
    List<Coffee> selectAllCoffee();
    List<Tea> selectAllTea();
    List<Chocolate> selectAllChocolate();

    Coffee selectByIdCoffee(int id);
    Tea selectByIdTea(int id);
    Chocolate selectByIdChocolate(int id);

    void insertCoffee(Coffee coffee);
    void insertTea(Tea tea);
    void insertChocolate(Chocolate chocolate);

    void updateCoffee(Coffee coffee);
    void updateTea(Tea tea);
    void updateChocolate(Chocolate chocolate);

    void deleteCoffee(int id);
    void deleteTea(int id);
    void deleteChocolate(int id);
}
