package com.elrain.whattocook.dal;

import com.elrain.whattocook.dao2.entity.RecipeEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by elrain on 30.07.15.
 */
public class InitHelper {
    private static final String RECIPE_TABLE = "Recipe";

    public static List<RecipeEntity> init(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM " + RECIPE_TABLE + " ").list();
    }
}
