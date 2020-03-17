package medapp.dao;

import medapp.model.Assignment;
import medapp.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AssignmentDAOImpl implements AssignmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addAssignment(Assignment assignment) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(assignment);
        System.out.println("hello");
    }

    @Override
    public List<Assignment> getAll(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("FROM Patient as p LEFT join fetch p.assignments where " +
                "p.id="+id);
        Patient patient = (Patient) query.getResultList();
        return new ArrayList<Assignment>(patient.getAssignments());
    }
}
