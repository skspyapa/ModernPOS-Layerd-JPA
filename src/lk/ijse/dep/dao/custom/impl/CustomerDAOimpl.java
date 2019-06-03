package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.custom.CustomerDAO;
import lk.ijse.dep.entity.Customer;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    public void save(Customer customer) throws Exception {
        entityManager.persist(customer);
            }

    public void update(Customer customer) throws Exception {
        entityManager.merge(customer);
    }
    public void delete(String id) throws Exception {
        entityManager.remove(entityManager.getReference(Customer.class,id));
    }

    public Customer find(String id) throws Exception {
       return entityManager.find(Customer.class,id);
    }

    public List<Customer> findAll() throws Exception {
        return entityManager.createNativeQuery("SELECT * FROM customer",Customer.class).getResultList();
    }
    public String findMaxCustId() throws Exception {
        Object objects = entityManager.createNativeQuery("SELECT id from customer ORDER BY id DESC LIMIT 1").getSingleResult();
        return objects.toString();
    }
}
