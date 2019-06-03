package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.custom.ItemDetailDAO;
import lk.ijse.dep.entity.ItemDetail;
import lk.ijse.dep.entity.ItemDetailPK;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class ItemDetailDAOimpl implements ItemDetailDAO {
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager=entityManager;
    }
    public void save(ItemDetail itemDetail) throws Exception {
        entityManager.persist(itemDetail);
    }

    public void update(ItemDetail itemDetail) throws Exception {
        entityManager.merge(itemDetail);
    }

    public void delete(ItemDetailPK itemDetailPK) throws Exception {
        entityManager.remove(entityManager.getReference(ItemDetail.class, itemDetailPK));
            }

    public ItemDetail find(ItemDetailPK itemDetailPK) throws Exception {
       return entityManager.find(ItemDetail.class,itemDetailPK);
    }

    public List<ItemDetail> findAll() throws Exception {
        return entityManager.createNativeQuery("SELECT * FROM itemdetail",ItemDetail.class).getResultList();
    }

    
}


