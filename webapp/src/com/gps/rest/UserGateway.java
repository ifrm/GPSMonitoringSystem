package com.gps.rest;

import com.gps.persistence.dto.Position;
import com.gps.persistence.dto.User;
import com.gps.rest.util.WsConstants;
import com.gps.service.user.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Ionatan on 05.01.2016.
 */
@Component
@Path("/users")
public class UserGateway {

    @Autowired
    UserService userService;
    @GET
    public Response getAllUsers(){
        try {
            List<User> users = userService.findAll();
            ObjectMapper mapper = new ObjectMapper();
            return Response.status(200).entity(mapper.writeValueAsString(users)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(422).entity(WsConstants.FAIL_STATUS).build();

        }

    }
}
