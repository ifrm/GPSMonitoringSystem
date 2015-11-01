package com.gps.service.position.impl;

import com.gps.persistence.dao.PositionDao;
import com.gps.persistence.dto.Position;
import com.gps.service.position.PositionService;
import com.gps.service.util.JsonToObjectConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author radu.miron
 * @since 10/8/13
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void savePosition(String jsonPosition) throws Exception {
        positionDao.savePosition(JsonToObjectConverters.convertJsonToPosition(jsonPosition));
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void deletePosition(int id) throws Exception {
        positionDao.deletePosition(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void updatePosition(int id, String jsonPosition) throws Exception {
        positionDao.updatePosition(id, JsonToObjectConverters.convertJsonToPosition(jsonPosition));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Position> getUserPositionsWithinInterval(int userId, Long startDate, Long endDate) throws Exception {
        return positionDao.getUserPositionsWithinInterval(userId, new Date(startDate), new Date(endDate));
    }
}
