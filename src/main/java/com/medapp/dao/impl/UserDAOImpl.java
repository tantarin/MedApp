package com.medapp.dao.impl;

import com.medapp.dao.api.UserDAO;
import com.medapp.model.login.Login;
import com.medapp.model.login.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void register(User user) {
        entityManager.persist(user);
    }

    @Override
    public User validateUser(Login login) {
        return null;
    }
}
