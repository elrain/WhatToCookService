package com.elrain.whattocook.dal;

import com.elrain.whattocook.dao.entity.UsersEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by elrain on 21.07.15.
 */
public class UsersHelper {

    private static final String STORED_GET_USER_INFO = "getUserInfo";
    public static final String EXISTS = "exists";
    private static final String COULD_NOT_INSERT = "could not insert:";

    public static UsersEntity getUserInfo(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.getNamedQuery(STORED_GET_USER_INFO).setParameter("name", userName);
        UsersEntity user = (UsersEntity) q.uniqueResult();
        return user;
    }

    public static void addNewUser(String name, String password) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            UsersEntity users = new UsersEntity();
            users.setName(name);
            users.setPassword(password);
            session.save(users);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            if (e.getMessage().contains(COULD_NOT_INSERT)) throw new IllegalArgumentException(EXISTS);
        } finally {
            if (null != session) session.close();
        }
    }

}
