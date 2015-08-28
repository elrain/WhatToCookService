package com.elrain.whattocook.service;

import com.elrain.whattocook.dao.entity.AmountEntity;
import com.elrain.whattocook.dao.entity.IngridientsEntity;
import com.elrain.whattocook.dao.entity.RecipeEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import com.elrain.whattocook.util.ImageUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 03.08.15.
 */
@Path("/recipe")
public class RecipesService {

    @GET()
    @Path("/search")
    public Response getRecipesByIngridients(@QueryParam("ingridient") List<String> ingridients) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("SELECT r FROM Recipe r" +
                "    LEFT JOIN r.amounts a LEFT JOIN a.ingridient as i WHERE i.name IN (:names) " +
                "GROUP BY r.idRecipe");
        q.setParameterList("names", ingridients);
        List<RecipeEntity> entities = q.list();
        if (entities.size() == 0)
            return Response.noContent().build();
        List<RecipeEntity> resultList = new ArrayList<RecipeEntity>();
        for (RecipeEntity re : entities)
            re.setImage(ImageUtil.encodeToString(re.getImage()));
        for (RecipeEntity re : entities) {
            int ingridientCount = re.getAmounts().size();
            int matches = 0;
            for (AmountEntity ae : re.getAmounts()) {
                IngridientsEntity ie = ae.getIngridient();
                for (String s : ingridients)
                    if (ie.getName().equalsIgnoreCase(s)) {
                        ++matches;
                        break;
                    }
            }
            if (matches + 1 == ingridientCount || matches == ingridientCount)
                resultList.add(re);
        }
        return Response.ok(resultList, MediaType.APPLICATION_JSON).build();
    }
}
