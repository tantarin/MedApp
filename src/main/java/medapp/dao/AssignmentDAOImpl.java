package medapp.dao;

import medapp.model.Assignment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    }
}
