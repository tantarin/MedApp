package medapp.dao.impl;

import medapp.dao.api.EventDAO;
import medapp.model.Event;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class EventDAOImpl implements EventDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEvent(Event event) {
        entityManager.persist(event);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> getAll() {
        return entityManager.createQuery("FROM Event").getResultList();
    }

    @Override
    public Event getById(Long id) {
        return  (Event) entityManager.find(Event.class,id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> filterByDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.date = ?1");
        String date = formatForDateNow.format(dateNow);
        query.setParameter(1,date);
        List<Event> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Event> filterByHour() {
        Date dateNow = new Date();
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");
        String timeNow = time.format(dateNow);
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.time = ?1");
        query.setParameter(1,timeNow);
        List<Event> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Event> filterByPatient(Integer id) {
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.patient.id= ?1", Event.class);
        query.setParameter(1,Integer.toString(id));
        return query.getResultList();
    }

    @Override
    public void deleteFromToday(Long patientId) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatForDateNow.format(dateNow);
        System.out.println("patient id "+patientId + "string "+date);
        Query query = entityManager.createQuery("delete from Event e where e.date >=:date AND e.patient.id=:pId");
        query.setParameter("date","'"+date+"'").setParameter("pId",patientId).executeUpdate();
        System.out.println("from dao event delete");

    }
}
