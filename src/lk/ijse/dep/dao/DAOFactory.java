package lk.ijse.dep.dao;

import lk.ijse.dep.dao.custom.impl.CustomerDAOimpl;
import lk.ijse.dep.dao.custom.impl.ItemDAOimpl;
import lk.ijse.dep.dao.custom.impl.ItemDetailDAOimpl;
import lk.ijse.dep.dao.custom.impl.OrdersDAOimpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public <T extends SuperDAO>T getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
               return (T) new CustomerDAOimpl();
            case ITEM:
                return (T)new ItemDAOimpl();
            case ORDER:
                return (T)new OrdersDAOimpl();
            case ITEM_DETAIL:
                return (T)new ItemDetailDAOimpl();
                default:
                    return null;
        }
    }
}
