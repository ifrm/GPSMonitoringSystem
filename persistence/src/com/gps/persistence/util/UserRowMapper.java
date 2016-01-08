package com.gps.persistence.util;

import com.gps.persistence.dto.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ionatan on 05.01.2016.
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setId(resultSet.getInt(PersistenceConstants.ID));
        user.setEmail(resultSet.getString(PersistenceConstants.EMAIL));
        user.setName(resultSet.getString(PersistenceConstants.NAME));
        user.setRole(resultSet.getString(PersistenceConstants.ROLE));
        return user;

    }
}
