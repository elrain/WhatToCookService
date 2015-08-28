package com.elrain.whattocook.dal;

import com.elrain.whattocook.dao.entity.IngridientsEntity;
import com.elrain.whattocook.dao.entity.RecipeEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by elrain on 03.08.15.
 */
public class RecipeHelper {

    public static String getRecipesImage(int recipeId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("SELECT r.image FROM Recipe r WHERE r.idRecipe = :recipeId");
        q.setParameter("recipeId", recipeId);
        String path = (String) q.uniqueResult();
        return path;
    }

    public static RecipeEntity getRecipeById(int recipeId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (RecipeEntity) session.createQuery("SELECT r FROM Recipe r " +
                "WHERE r.idRecipe = " + recipeId).uniqueResult();
    }
}
