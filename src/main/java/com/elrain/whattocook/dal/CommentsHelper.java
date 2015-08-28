package com.elrain.whattocook.dal;

import com.elrain.whattocook.dao.entity.CommentsEntity;
import com.elrain.whattocook.dao.entity.UsersEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import com.elrain.whattocook.webutil.body.CommentBody;
import com.elrain.whattocook.webutil.response.CommentsResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by elrain on 30.07.15.
 */
public class CommentsHelper {

    public static List<CommentsResponse> getCommentsForRecipe(long recipeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = session.createQuery("SELECT c.text, c.time, c.idComments, c.user.name FROM Comments c WHERE c.idRecipe = " + String.valueOf(recipeId)).list();
        List<CommentsResponse> result = new ArrayList<CommentsResponse>();
        for(Object[] o : list){
            CommentsResponse cr = new CommentsResponse();
            cr.setCommentId((Integer) o[2]);
            cr.setText((String) o[0]);
            cr.setTime((Date) o[1]);
            cr.setUserName((String) o[3]);
            result.add(cr);
        }
        return result;
    }

    public static void insertNew(CommentBody comment) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            UsersEntity user = (UsersEntity) session.createQuery("FROM Users u WHERE u.idUsers = "
                    + String.valueOf(comment.getUserId())).uniqueResult();
            CommentsEntity entity = new CommentsEntity();
            entity.setUser(user);
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
