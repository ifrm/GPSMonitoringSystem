package com.gps.persistence.dao.impl;

import com.gps.persistence.dao.UserDAO;
import com.gps.persistence.dto.Position;
import com.gps.persistence.dto.User;
import com.gps.persistence.util.PersistenceConstants;
import com.gps.persistence.util.PositionRowMapper;
import com.gps.persistence.util.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ionatan on 05.01.2016.
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT " + PersistenceConstants.ID + "," + PersistenceConstants.EMAIL + ",");
        sql.append(PersistenceConstants.NAME + "," + PersistenceConstants.ROLE);
        sql.append(" FROM " + PersistenceConstants.USER_TABLE);

        List<User> result;
        try {
            result = jdbcTemplate.query(sql.toString(), new UserRowMapper());
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public boolean longin(String userName, String password) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) ");
        sql.append(" FROM " + PersistenceConstants.USER_TABLE);
        sql.append(" WHERE " + PersistenceConstants.EMAIL + "=:userName and " + PersistenceConstants.PASSWORD + "=:password");


        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("password", password);
        int result;
        try {
            result = jdbcTemplate.queryForInt(sql.toString(), params);
        } catch (Exception e) {
            throw e;
        }
        if (result == 1)
            return true;
        else
            return false;
    }
}
