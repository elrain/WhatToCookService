package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.RecipeHelper;
import com.elrain.whattocook.dao.entity.RecipeEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import com.elrain.whattocook.util.PdfConverter;
import com.itextpdf.text.DocumentException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
