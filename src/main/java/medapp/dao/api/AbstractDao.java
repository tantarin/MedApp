package medapp.dao.api;

import javax.persistence.*;

public abstract class AbstractDao {
    private static final EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("TestPersistence");
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }
}
