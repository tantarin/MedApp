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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class EventDAOImpl implements EventDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEvent(Event event) {
        entityManager.persist(event);
    }

    //delete Event by assignment id
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
        System.out.println("from filter by date");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(localDate);
        System.out.println("date now"+date);
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.date = ?1");
        query.setParameter(1,date);
    //    System.out.println(Arrays.toString(query.getResultList().toArray()));
        return query.getResultList();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Event> filterByHour() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeNow = formatter.format(localTime);
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.time = ?1");
        query.setParameter(1,timeNow);
        return query.getResultList();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Event> filterByPatient(String lastName) {
        Query query = entityManager.createQuery("select e FROM Event e WHERE e.patientName= ?1", Event.class);
        query.setParameter(1, lastName);
        return query.getResultList();
    }
}
