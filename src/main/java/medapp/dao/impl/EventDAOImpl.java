package medapp.dao.impl;

import medapp.dao.api.EventDAO;
import medapp.model.Event;
import org.springframework.stereotype.Component;
import javax.ejb.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Stateful
public class EventDAOImpl implements EventDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addEvent(Event event) {
        entityManager.persist(event);
    }

    @Override
    public void deleteByAssignmentId(Long assignmentId){
        Query query = entityManager.createQuery("delete from Event e where e.assignment.id= :aId");
        query.setParameter("aId", assignmentId).executeUpdate();
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
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(localDate);
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.date = ?1");
        query.setParameter(1,date);
        return query.getResultList();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Event> filterByHour() {
        LocalTime localTime = LocalTime.now();
        LocalTime plusHour = localTime.plusHours(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatterDate.format(localDate);
        String timeNow = formatter.format(localTime);
        String timePlusHour = formatter.format(plusHour);
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.time >= ?1 AND e.time <= ?2 and e.date = ?3");
        query.setParameter(1,timeNow).setParameter(2,timePlusHour).setParameter(3,date);
        return query.getResultList();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Event> filterByPatient(String lastName) {
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.patientName= ?1");
        query.setParameter(1, lastName);
        return query.getResultList();
    }

    @Override
    public void update(Event event) {
        entityManager.persist(event);
    }

    @Override
    public List<Event> getByAssignmentId(Long assId) {
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.assignment.id= ?1");
        query.setParameter(1, assId);
        return query.getResultList();
    }

}
