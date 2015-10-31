package com.gps.persistence.util;

import com.gps.persistence.dto.Position;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ionatan on 11/1/2015.
 * This is a mapper class
 */
public class PositionRowMapper implements RowMapper<Position> {

    @Override
    public Position mapRow(ResultSet resultSet, int i) throws SQLException {
        Position pos = new Position();
        pos.setLatitude(resultSet.getString(PersistenceConstants.LATITUDE));
        pos.setLongitude(resultSet.getString(PersistenceConstants.LONGITUDE));
        pos.setUserId(resultSet.getInt(PersistenceConstants.USER_ID));
        pos.setDate(resultSet.getDate(PersistenceConstants.DATE));
        return pos;
    }
}
