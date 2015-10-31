package com.gps.persistence.dao;

import com.gps.persistence.dto.Position;

import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 10/8/13
 */
public interface PositionDao {

    void savePosition(Position position) throws Exception;

    void deletePosition(int id) throws Exception;

    void updatePosition(int id, Position position) throws Exception;

    public List<Position> getUserPositions(int userId, Date startDate, Date endDate) throws Exception;

}
