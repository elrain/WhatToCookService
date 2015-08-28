package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.CommentsHelper;
import com.elrain.whattocook.webutil.body.CommentBody;
import com.elrain.whattocook.webutil.response.CommentsResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by elrain on 24.06.15.
 */
@Path("/comments")
public class CommentsService {

    @GET
    @Path("{recipeId}")
    public Response getComments(@PathParam("recipeId") long id) {
        try {
            List<CommentsResponse> entities = CommentsHelper.getCommentsForRecipe(id);
            return Response.ok(entities, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.noContent().build();
    }

    @PUT
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(CommentBody comment) {
        try {
            CommentsHelper.insertNew(comment);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
