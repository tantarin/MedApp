package medapp.dao.impl;

import medapp.dao.api.AssignmentDAO;
import medapp.model.Assignment;
import medapp.model.Patient;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AssignmentDAOImpl implements AssignmentDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Assignment assignment) {
        entityManager.persist(assignment);
        System.out.println("Record Successfully Inserted In The Database");
    }

    @Override
    public List<Assignment> getAll(int id) {
        Query query = entityManager.createQuery("FROM Patient as p LEFT join fetch p.assignments where " +
                "p.id="+id);
        Patient patient = (Patient) query.getResultList();
        return new ArrayList<Assignment>(patient.getAssignments());
    }

    @Override
    public void update(Assignment assignment) {
            System.out.println("from dao:" + assignment.getName());
            entityManager.persist(assignment);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Assignment getById(Long id) {
            return  (Assignment) entityManager.find(Assignment.class, id);
    }
}
