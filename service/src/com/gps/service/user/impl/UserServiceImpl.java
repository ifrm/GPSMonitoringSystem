package com.gps.service.user.impl;

import com.gps.persistence.dao.UserDAO;
import com.gps.persistence.dto.User;
import com.gps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ionatan on 05.01.2016.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> findAll() throws Exception {
        return userDAO.findAll();
    }
}
