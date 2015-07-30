package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.webutil.response.UserInfo;
import com.elrain.whattocook.util.Crypting;
import com.elrain.whattocook.webutil.body.UserBody;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by elrain on 19.06.15.
 */
public class UsersHelper extends Accessor {

    private static final String GET_USER_INFO = "getUserInfo";
    private static final String ID_USER_TYPE = "idUserType";
    private static final String USER_TYPE_NAME = "name";
    public static final String USER_NAME = "name";
    private static final String ID_USER = "idUsers";
    private static final String USER_PASSWORD = "password";
    private static final String ADD_NEW_USER = "addNewUser";

    public UsersHelper() throws Exception {
    }

    public UserInfo getUserInfo(UserBody body) throws SQLException, GeneralSecurityException, IOException {
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery("CALL " + GET_USER_INFO + "('" + body.getName() + "');");
        if (rs.next()) {
            if (Crypting.checkPassword(body.getPassword(), rs.getString(USER_PASSWORD))) {
                long idUser = rs.getLong(ID_USER);
                long idUserType = rs.getLong(ID_USER_TYPE);
                String userTypeName = rs.getString(USER_TYPE_NAME);
                UserInfo entity = new UserInfo(idUserType, userTypeName, idUser);
                return entity;
            }
        }
        return null;
    }

    public void addNewUser(UserBody user) throws SQLException {
        Statement st = this.connection.createStatement();
        int n = st.executeUpdate("CALL " + ADD_NEW_USER + "('" + user.getName() + "', '" + Crypting.encrypt(user.getPassword()) + "')");
    }


}
