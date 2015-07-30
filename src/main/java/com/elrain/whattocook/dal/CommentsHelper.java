package com.elrain.whattocook.dal;

import com.elrain.whattocook.dao2.entity.CommentsEntity;
import com.elrain.whattocook.dao2.entity.RecipeEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import com.elrain.whattocook.webutil.body.CommentBody;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by elrain on 30.07.15.
 */
public class CommentsHelper {

    private static final String TABLE = "Comments";

    public static List<CommentsEntity> getCommentsForRecipe(long recipeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM " + TABLE + " WHERE recipe = " + String.valueOf(recipeId)).list();
    }

    public static void insertNew(CommentBody comment) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            CommentsEntity entity = new CommentsEntity();
            entity.setIdUser(comment.getUserId());
            entity.setIdRecipe(comment.getRecipeId());
            entity.setText(comment.getText());
            entity.setTime(new Date());
            session.save(entity);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (null != session) session.close();
        }
    }
}
