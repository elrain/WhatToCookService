package com.elrain.whattocook.webutil.response;

/**
 * Created by elrain on 19.06.15.
 */
public class UserInfo {
    private long idUserType;
    private String userTypeName;
    private long idUser;

    public UserInfo(long idUserType, String userTypeName, long idUser) {
        this.idUserType = idUserType;
        this.userTypeName = userTypeName;
        this.idUser = idUser;
    }

    public long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(long idUserType) {
        this.idUserType = idUserType;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}