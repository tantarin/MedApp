package com.medapp.dao.api;

import org.springframework.security.core.userdetails.User;

public interface UserDAO {

    User findByUsername(String username);
}
