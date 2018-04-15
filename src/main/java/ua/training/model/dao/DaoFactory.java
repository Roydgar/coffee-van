package ua.training.model.dao;


import ua.training.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract CoffeesDao createCoffeesDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
