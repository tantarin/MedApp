package medapp.dao.impl;

import medapp.dao.api.AbstractDao;
import medapp.dao.api.AssignmentDAO;
import medapp.model.Assignment;
import medapp.model.Patient;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AssignmentDAOImpl extends AbstractDao implements AssignmentDAO {

    @Override
    public void add(Assignment assignment) {
        try{
        getEntityManager().merge(assignment);
        getEntityManager().persist(assignment);}
        catch (NullPointerException n){
           n.printStackTrace();}
        System.out.println("from ass dao hello");
    }

    @Override
    public List<Assignment> getAll(int id) {
        Query query = getEntityManager().createQuery("FROM Patient as p LEFT join fetch p.assignments where " +
                "p.id="+id);
        Patient patient = (Patient) query.getResultList();
        return new ArrayList<Assignment>(patient.getAssignments());
    }

    @Override
    public void update(Assignment assignment) {
        try {
            System.out.println("from dao:" + assignment.getName());
            getEntityManager().persist(assignment);
        }catch(NullPointerException e){
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public void delete(Long id) {
        getEntityManager().remove(getById(id));
    }

    @Override
    public Assignment getById(Long id) {
            return  (Assignment) getEntityManager().find(Assignment.class, id);
    }
}
