package medapp.dao.impl;

import medapp.dao.api.AssignmentDAO;
import medapp.model.Assignment;
import medapp.model.Patient;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AssignmentDAOImpl implements AssignmentDAO {


    @PersistenceContext
    private EntityManager entityManager;

    /**
     *
     * @param assignment
     */
    @Override
    public void add(Assignment assignment) {
        entityManager.persist(assignment);
        assignment = entityManager.find(Assignment.class, assignment.getId());
        entityManager.refresh(assignment);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Assignment> getAll(Long id) {
        Query query = entityManager.createQuery("FROM Patient as p LEFT join fetch p.assignments where p.id=:id");
        query.setParameter("id", id);
        Patient patient = (Patient) query.getResultList();
        return new ArrayList<Assignment>(patient.getAssignments());
    }

    /**
     *
     * @param assignment
     */
    @Override
    public void update(Assignment assignment) {
            entityManager.persist(assignment);
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Assignment getById(Long id) {
        Query query = entityManager.createQuery("FROM Assignment ass where ass.id=:id");
        query.setParameter("id", id);
        return (Assignment) query.getResultList().toArray()[0];
    }
}
