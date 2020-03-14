package medapp.dao;

import medapp.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPatient(Patient patient) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(patient);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> listPatients() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Patient> patientList = session.createQuery("from Patient").list();
        return patientList;
    }

    @Override
    public void removePatient(Integer id) {
    }
}
