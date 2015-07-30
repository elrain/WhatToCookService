package com.elrain.whattocook.dal;

import com.elrain.whattocook.dao2.entity.AmountEntity;
import com.elrain.whattocook.dao2.entity.UsersEntity;
import com.elrain.whattocook.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by elrain on 21.07.15.
 */
public class UsersHelper {

    private static final String TABLE = "UsersEntity";
    private static final String STORED_GET_USER_INFO = "getUserInfo";
    private static final String STORED_ADD_NEW_USER = "addNewUser";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    public static final String EXISTS = "exists";
    private static final String COULD_NOT_INSERT = "could not insert:";

    public static UsersEntity getUserInfo(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UsersEntity user = (UsersEntity) session.getNamedQuery(STORED_GET_USER_INFO).setParameter(NAME, userName).uniqueResult();
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
            if(e.getMessage().contains(COULD_NOT_INSERT)) throw new IllegalArgumentException(EXISTS);
        } finally {
            if (null != session) session.close();
        }
    }

}
