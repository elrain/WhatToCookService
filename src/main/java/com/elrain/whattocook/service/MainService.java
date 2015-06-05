package com.elrain.whattocook.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by elrain on 05.06.15.
 */

@Path("/ping")
public class MainService {

    @GET
    public Response getGroups() {
        return Response.status(200).entity("PING!!!").build();
    }
}
