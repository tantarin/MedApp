package com.medapp.dao.api;

import com.medapp.model.login.Login;
import com.medapp.model.login.User;


public interface UserDAO {
    void register(User user);
    User validateUser(Login login);
}
