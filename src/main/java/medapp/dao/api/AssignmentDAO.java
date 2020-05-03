package medapp.dao.api;

import medapp.exceptions.DaoException;
import medapp.model.Assignment;

import java.util.List;


public interface AssignmentDAO {

    Assignment add(Assignment assignment) throws DaoException;
    List<Assignment> getAll(Long id);
    Assignment getById(Long id);
    void update(Assignment assignment);
    void delete(Long id);
}
