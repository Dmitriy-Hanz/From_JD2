package projectGroup.dao;

public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();
    private final DAO daoImpl = new EntityDAO();

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public DAO getImplThroughDAO() {
        return daoImpl;
    }

}
