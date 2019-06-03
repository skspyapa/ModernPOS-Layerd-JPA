package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.custom.ItemDAO;
import lk.ijse.dep.entity.Item;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class ItemDAOimpl implements ItemDAO {
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
this.entityManager=entityManager;
    }
    public void save(Item item) throws Exception {
        entityManager.persist(item);
    }

    public void update(Item item) throws Exception {
        entityManager.merge(item);
    }

    public void delete(String code) throws Exception {
        entityManager.remove(entityManager.getReference(Item.class,code));
            }

    public Item find(String code) throws Exception {
        return entityManager.find(Item.class,code);
    }

    public List<Item> findAll() throws Exception {
       return entityManager.createNativeQuery("SELECT * from Item",Item.class).getResultList();
            }
    public String findMaxItemCode() throws Exception {
        Object objects = entityManager.createNativeQuery("SELECT code from item ORDER BY code DESC LIMIT 1").getSingleResult();
        return objects.toString();
    }
}

