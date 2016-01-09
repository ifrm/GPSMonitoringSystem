package com.gps.persistence.dao;

import com.gps.persistence.dto.User;

import java.util.List;

/**
 * Created by Ionatan on 05.01.2016.
 */
public interface UserDAO {
    List<User> findAll() throws Exception;

    boolean longin(String userName,String password) throws Exception;
}
