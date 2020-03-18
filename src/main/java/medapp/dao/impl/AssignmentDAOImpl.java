package medapp.dao.impl;

import medapp.dao.api.AssignmentDAO;
import medapp.model.Assignment;
import medapp.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class AssignmentDAOImpl implements AssignmentDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;


    @Override
    @Transactional
    public void add(Assignment assignment) {
        entityManager.persist(assignment);
        System.out.println("hello");
    }

    @Override
    public List<Assignment> getAll(int id) {
        Query query = entityManager.createQuery("FROM Patient as p LEFT join fetch p.assignments where " +
                "p.id="+id);
        Patient patient = (Patient) query.getResultList();
        return new ArrayList<Assignment>(patient.getAssignments());
    }

    @Override
    public Assignment getById(int id) {
        Assignment ass = (Assignment) entityManager.find(Assignment.class,id);
        return ass;
    }
}
