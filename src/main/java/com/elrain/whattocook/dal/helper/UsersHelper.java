package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.UserInfoEntity;
import com.elrain.whattocook.webutil.body.UserBody;

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
    private static final String ADD_NEW_USER = "addNewUser";

    public UsersHelper() throws Exception {
    }

    public UserInfoEntity getUserInfo(UserBody body) {
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("CALL " + GET_USER_INFO + "('" + body.getName() + "', '" + body.getPassword() + "');");
            if (rs.next()) {
                long idUser = rs.getLong(ID_USER);
                long idUserType = rs.getLong(ID_USER_TYPE);
                String userTypeName = rs.getString(USER_TYPE_NAME);
                UserInfoEntity entity = new UserInfoEntity(idUserType, userTypeName, idUser);
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addNewUser(UserBody user) throws SQLException {
        Statement st = this.connection.createStatement();
        int n = st.executeUpdate("CALL " + ADD_NEW_USER + "('" + user.getName() + "', '" + user.getPassword() + "')");
    }
}
