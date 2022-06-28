package DAO;

import config.HibernateConfig;
import model.Chocolate;
import model.Coffee;
import model.Product;
import model.Tea;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class ProductDAOImpl implements ProductDAO{

    public List<?> selectAll(List<?> products, String string, Class<? extends Product> aClass) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            products = session.createQuery(string, aClass).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return products;
    }

    public Object selectById(Object object, Class<? extends Product> aClass, int id) {
        try (Session session = HibernateConfig.getSessionFactory().getCurrentSession()) {
            object = session.get(aClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public void insert(Object object) {
        try (Session session = HibernateConfig.getSessionFactory().getCurrentSession()) {
            session.save(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Object object) {
        try (Session session = HibernateConfig.getSessionFactory().getCurrentSession()) {
            session.update(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Object object, Class<? extends Product> aClass, int id) {
        try (Session session = HibernateConfig.getSessionFactory().getCurrentSession()) {
            object = session.get(aClass, id);
            if(object != null) {
                session.delete(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Coffee> selectAllCoffee() {
        List<Coffee> coffee = null;
        //извлечение необходимых данных для предотвращения проблемы N+1
        return (List<Coffee>) selectAll(coffee,
                "select coffee_id, name, region, growth_height\n" +
                        "from coffee inner join products on products.product_id = coffee.coffee_id",
                Coffee.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tea> selectAllTea() {
        List<Tea> tea = null;
        return (List<Tea>) selectAll(tea,
                "select tea_id, name, province, type\n" +
                        "from tea inner join products on products.product_id = tea_id",
                Tea.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Chocolate> selectAllChocolate() {
        List<Chocolate> chocolate = null;
        return (List<Chocolate>) selectAll(chocolate,
                "select chocolate_id, name, per_of_cocoa, country\n" +
                        "from chocolate inner join products on products.product_id = chocolate_id",
                Chocolate.class);
    }

    @Override
    public Coffee selectByIdCoffee(int id) {
        Coffee coffee = null;
        return (Coffee) selectById(coffee, Coffee.class, id);
    }

    @Override
    public Tea selectByIdTea(int id) {
        Tea tea = null;
        return (Tea) selectById(tea, Tea.class, id);
    }

    @Override
    public Chocolate selectByIdChocolate(int id) {
        Chocolate chocolate = null;
        return (Chocolate) selectById(chocolate, Chocolate.class, id);
    }

    @Override
    public void insertCoffee(Coffee coffee) {
        insert(coffee);
    }

    @Override
    public void insertTea(Tea tea) {
        insert(tea);
    }

    @Override
    public void insertChocolate(Chocolate chocolate) {
        insert(chocolate);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        update(coffee);
    }

    @Override
    public void updateTea(Tea tea) {
        update(tea);
    }

    @Override
    public void updateChocolate(Chocolate chocolate) {
        update(chocolate);
    }

    @Override
    public void deleteCoffee(int id) {
        Coffee coffee = null;
        delete(coffee, Coffee.class, id);
    }

    @Override
    public void deleteTea(int id) {
        Tea tea = null;
        delete(tea, Tea.class, id);
    }

    @Override
    public void deleteChocolate(int id) {
        Chocolate chocolate = null;
        delete(chocolate, Chocolate.class, id);
    }
}
