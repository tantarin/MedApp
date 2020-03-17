package medapp.dao.api;

import medapp.model.Assignment;

import java.util.List;


public interface AssignmentDAO {

    void add(Assignment assignment);
    List<Assignment> getAll(int id);
    Assignment getById(int id);
}
