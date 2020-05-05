package com.medapp.dao.api;

import com.medapp.model.Assignment;

import java.util.List;


public interface AssignmentDAO {

    Assignment add(Assignment assignment);
    List<Assignment> getAll(Long id);
    Assignment getById(Long id);
    void update(Assignment assignment);
    void delete(Long id);
}
