package com.medapp.service.impl;

import com.medapp.dao.api.UserDAO;
import com.medapp.model.login.User;
import com.medapp.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void add(User user) {
        userDAO.register(user);
    }
}
