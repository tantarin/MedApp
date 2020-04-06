package medapp.dao.impl;

import medapp.dao.api.EventDAO;
import medapp.model.Event;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.date = ?1");
        String date = formatForDateNow.format(LocalDate.now());
        query.setParameter(1,date);
        return query.getResultList();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Event> filterByHour() {
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");
        String timeNow = time.format(LocalDate.now());
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.time = ?1");
        query.setParameter(1,timeNow);
        return query.getResultList();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Event> filterByPatient(Integer id) {
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.patient.id= ?1", Event.class);
        query.setParameter(1,Integer.toString(id));
        return query.getResultList();
    }

    /**
     *
     * @param patientId
     */
    @Override
    public void deleteFromToday(Long patientId) {
        String date = LocalDate.now().toString();
        Query query = entityManager.createQuery("delete from Event e where e.date >=:date AND e.patient.id = :pId");
        query.setParameter("date","'"+date+"'").setParameter("pId",patientId).executeUpdate();
    }
}
