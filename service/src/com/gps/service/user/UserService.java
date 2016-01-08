package com.gps.service.user;

import com.gps.persistence.dto.User;

import java.util.List;

/**
 * Created by Ionatan on 05.01.2016.
 */
public interface UserService {

    List<User> findAll()throws Exception;
}
