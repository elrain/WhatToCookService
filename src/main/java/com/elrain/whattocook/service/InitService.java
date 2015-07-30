package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.InitHelper;
import com.elrain.whattocook.dao2.entity.RecipeEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
@Path("/init")
public class InitService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response initData() {
        try {
            List<RecipeEntity> entities = InitHelper.init();
            return Response.ok(entities, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
