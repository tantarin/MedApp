package medapp.dao.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class AbstractDao {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
}
