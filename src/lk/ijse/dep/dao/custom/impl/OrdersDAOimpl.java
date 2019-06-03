package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.custom.OrdersDAO;
import lk.ijse.dep.entity.Orders;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdersDAOimpl implements OrdersDAO {
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager=entityManager;
    }
    public void save(Orders orders) throws Exception {
        entityManager.persist(orders);
    }

    public void update(Orders orders) throws Exception {
    entityManager.merge(orders);
    }

    public void delete(String id) throws Exception {
    entityManager.remove(entityManager.getReference(Orders.class,id));
    }

    public Orders find(String id) throws Exception{
       return entityManager.find(Orders.class,id);
    }

    public List<Orders> findAll() throws Exception {
return entityManager.createNativeQuery("SELECT * from orders",Orders.class).getResultList();
    }

    @Override
    public String findMaxId() throws Exception {
        return (String) entityManager.createNativeQuery("SELECT id from `orders` ORDER BY id DESC LIMIT 1").getSingleResult();

    }
}

