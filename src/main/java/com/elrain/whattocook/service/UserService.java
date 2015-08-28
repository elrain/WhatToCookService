package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.UsersHelper;
import com.elrain.whattocook.dao.entity.UsersEntity;
import com.elrain.whattocook.util.Crypting;
import com.elrain.whattocook.webutil.body.UserBody;
import com.elrain.whattocook.webutil.response.UserInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.GeneralSecurityException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by elrain on 19.06.15.
 */

@Path("/user")
public class UserService {

    @POST
    @Path("/login")
    public Response getUserInfo(UserBody userBody) {
        UserInfo entity = null;

        UsersEntity user = UsersHelper.getUserInfo(userBody.getName());
        try {
            if (Crypting.checkPassword(userBody.getPassword(), user.getPassword())) {
                entity = new UserInfo(user.getUserType().getIdUserType(), user.getUserType().getName(), user.getIdUsers());
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null == entity ? Response.status(Response.Status.UNAUTHORIZED).build() :
                Response.ok(entity, APPLICATION_JSON).build();
    }

    @PUT
    @Path("/register")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response addNewUser(UserBody user) {
        try {
            UsersHelper.addNewUser(user.getName(), Crypting.encrypt(Crypting.decrypt(user.getPassword())));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
