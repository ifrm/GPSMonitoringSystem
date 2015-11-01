package com.gps.persistence.dao.impl;

import com.gps.persistence.dao.PositionDao;
import com.gps.persistence.dto.Position;
import com.gps.persistence.util.PersistenceConstants;
import com.gps.persistence.util.PositionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author radu.miron
 * @since 10/8/13
 */
@Repository
public class PositionDaoImpl implements PositionDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public PositionDaoImpl() {
        System.out.println("PDI created!");
    }

    @Override
    public void savePosition(Position position) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO " + PersistenceConstants.POSITION_TABLE);
        sql.append(" ( " + PersistenceConstants.USER_ID + ", " + PersistenceConstants.LATITUDE + ", ");
        sql.append(PersistenceConstants.LONGITUDE + ", " + PersistenceConstants.DATE + ") ");
        sql.append("VALUES (:userId, :latitude, :longitude, :date);");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", position.getUserId());
        params.put("latitude", position.getLatitude());
        params.put("longitude", position.getLongitude());
        params.put("date", position.getDate());

        try {
            jdbcTemplate.update(sql.toString(), params);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletePosition(int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM " + PersistenceConstants.POSITION_TABLE + " WHERE ");
        sql.append(PersistenceConstants.ID + " = :id");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        try {
            jdbcTemplate.update(sql.toString(), params);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void updatePosition(int id, Position position) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + PersistenceConstants.POSITION_TABLE);
        sql.append(" SET " + PersistenceConstants.USER_ID + "= :userId, " + PersistenceConstants.LATITUDE + "= :latitude, ");
        sql.append(PersistenceConstants.LONGITUDE + "=:longitude, " + PersistenceConstants.DATE + "=:date");
        sql.append(" WHERE " + PersistenceConstants.ID + " =:id");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", position.getUserId());
        params.put("latitude", position.getLatitude());
        params.put("longitude", position.getLongitude());
        params.put("date", position.getDate());
        params.put("id", id);

        try {
            jdbcTemplate.update(sql.toString(), params);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Position> getUserPositionsWithinInterval(int userId, Date startDate, Date endDate) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT " + PersistenceConstants.USER_ID + "," + PersistenceConstants.LATITUDE + ",");
        sql.append(PersistenceConstants.LONGITUDE + "," + PersistenceConstants.DATE);
        sql.append(" FROM " + PersistenceConstants.POSITION_TABLE);
        sql.append(" WHERE " + PersistenceConstants.USER_ID + "=:userId" + " AND ");
        sql.append(PersistenceConstants.DATE + " BETWEEN :startDate AND :endDate");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        List<Position> result;
        try {
            result = jdbcTemplate.query(sql.toString(), params, new PositionRowMapper());
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
