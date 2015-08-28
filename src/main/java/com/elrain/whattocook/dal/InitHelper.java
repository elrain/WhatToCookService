package com.elrain.whattocook.dal;

import com.elrain.whattocook.dao.entity.RecipeEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import com.elrain.whattocook.util.ImageUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by elrain on 30.07.15.
 */
public class InitHelper {
    public static List<RecipeEntity> init() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<RecipeEntity> recipes = (List<RecipeEntity>)session.createQuery("SELECT r FROM Recipe r").setMaxResults(2).list();
        for(RecipeEntity re : recipes)
            re.setImage(ImageUtil.encodeToString(re.getImage()));
        return recipes;
    }
}
