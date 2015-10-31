package com.gps.rest;

import com.gps.persistence.dto.Position;
import com.gps.rest.util.WsConstants;
import com.gps.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author radu.miron
 * @since 10/8/13
 */
@Component
@Path("/position")
public class PositionGateway {
    @Autowired
    private PositionService positionService;

    @GET
    @Path("/ping")
    public Response hello() {
        String result = "I'm alive!";
        return Response.status(200).entity(result).build();
    }

    @POST
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response savePosition(String jsonPosition) {
        try {
            positionService.savePosition(jsonPosition);
            return Response.status(200).entity(WsConstants.SUCCESS_STATUS).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(422).entity(WsConstants.FAIL_STATUS).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deletePosition(@PathParam("id") Integer id) {
        try {
            positionService.deletePosition(id);
            return Response.status(200).entity(WsConstants.SUCCESS_STATUS).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(422).entity(WsConstants.FAIL_STATUS).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updatePosition(@PathParam("id") Integer id, String jsonPosition) {
        try {
            positionService.updatePosition(id, jsonPosition);
            return Response.status(200).entity(WsConstants.SUCCESS_STATUS).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(422).entity(WsConstants.FAIL_STATUS).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserPositions(@QueryParam("userId") Integer userId, @QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate) {
        try {
            List<Position> pos = positionService.getUserPosition(userId, startDate, endDate);
            ObjectMapper mapper = new ObjectMapper();
            return Response.ok(mapper.writeValueAsString(pos)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(422).entity(WsConstants.FAIL_STATUS).build();

        }

    }


}