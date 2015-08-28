package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.RecipeHelper;
import com.elrain.whattocook.dao.entity.RecipeEntity;
import com.elrain.whattocook.util.PdfConverter;
import com.itextpdf.text.DocumentException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by elrain on 10.08.15.
 */
@Path("/file")
public class FileService {


    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String ATTACHMENT_FILENAME = "attachment; filename=";
    public static final String ATTACHMENT = "attachment; ";

    @GET
    @Path("/image/{recipeId}")
    @Produces("image/jpg")
    public Response getImageForRecipe(@PathParam("recipeId") int recipeId) {
        String path = RecipeHelper.getRecipesImage(recipeId);
        File image = new File(path);
        String fileName = path.substring(path.lastIndexOf('/') + 1, path.length());
        return createResponse(image, ATTACHMENT + fileName);
    }

    @GET
    @Path("/pdf/{recipeId}")
    @Produces("application/pdf")
    public Response getPdf(@PathParam("recipeId") int recipeId) {

        RecipeEntity re = RecipeHelper.getRecipeById(recipeId);

        File dirs = new File(PdfConverter.PDFS_PATH + recipeId);
        if (!dirs.exists()) {
            dirs.mkdirs();
            return getResponse(re);
        } else {
            File pdf = new File(PdfConverter.PDFS_PATH + recipeId + PdfConverter.PATH_DIVIDER + re.getName() + PdfConverter.PDF);
            if (pdf.exists()) {
                return createResponse(pdf, ATTACHMENT_FILENAME + pdf.getName());
            } else {
                return getResponse(re);
            }
        }
    }

    private Response getResponse(RecipeEntity re) {
        File f = getFile(re);
        if (null == f) return Response.serverError().build();
        else return createResponse(f, ATTACHMENT_FILENAME + f.getName());
    }

    private Response createResponse(File pdf, String o) {
        Response.ResponseBuilder response = Response.ok(pdf);
        response.header(CONTENT_DISPOSITION, o);
        return response.build();
    }

    private File getFile(RecipeEntity re) {
        try {
            PdfConverter.savePdf(re);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return new File(PdfConverter.PDFS_PATH + re.getIdRecipe() + PdfConverter.PATH_DIVIDER + re.getName() + PdfConverter.PDF);
    }
}
