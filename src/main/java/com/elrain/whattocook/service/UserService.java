package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.helper.UsersHelper;
import com.elrain.whattocook.dao.UserInfoEntity;
import com.elrain.whattocook.exceptions.IntegerException;
import com.elrain.whattocook.webutil.body.UserBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by elrain on 19.06.15.
 */

@Path("/user")
public class UserService {

    @POST
    @Path("/login")
    public Response getUserInfo(UserBody userBody) {
        UserInfoEntity entity = null;
        try {
            entity = new UsersHelper().getUserInfo(userBody);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null == entity ? Response.status(Response.Status.UNAUTHORIZED).build() :
                Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewUser(UserBody user) {
        try {
            UsersHelper helper = new UsersHelper();
            helper.addNewUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(new IntegerException(e.getErrorCode())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.noContent().build();
        }
        return Response.ok().build();
    }
}
