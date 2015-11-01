package com.gps.service.position;

import com.gps.persistence.dto.Position;

import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 10/8/13
 */
public interface PositionService {
    void savePosition(String jsonPosition) throws Exception;

    void deletePosition(int id) throws Exception;

    void updatePosition(int id, String jsonPosition) throws Exception;

    List<Position> getUserPositionsWithinInterval(int userId, Long startDate, Long endDate) throws Exception;

}

