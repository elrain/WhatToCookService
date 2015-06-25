package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.helper.CommentsHelper;
import com.elrain.whattocook.dao.CommentsEntity;
import com.elrain.whattocook.dao.RecipeEntity;
import com.elrain.whattocook.webutil.body.CommentBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by elrain on 24.06.15.
 */
@Path("/comments")
public class CommentsService {

    @GET
    @Path("{id}")
    public Response getComments(@PathParam("id") long id) {
        try {
            CommentsHelper helper = new CommentsHelper();
            List<CommentsEntity> entities = helper.getComments(id);
            return Response.ok(entities, MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.noContent().build();
    }

    @PUT
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(CommentBody comment){
        try{
            CommentsHelper helper = new CommentsHelper();
            helper.addComment(comment);
            return Response.ok().build();
        } catch (SQLException e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e){
            e.printStackTrace();
        }
        return Response.noContent().build();
    }

}
