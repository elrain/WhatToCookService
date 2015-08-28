package com.elrain.whattocook.dao.entity;

import javax.persistence.*;

/**
 * Created by elrain on 21.07.15.
 */
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getUserInfo",
                query = "CALL getUserInfo(:name)",
                resultClass = UsersEntity.class
        )
})
@Entity(name = "Users")
@Table(name = "Users", schema = "whattocook")
public class UsersEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsers")
    private Integer idUsers;
    @Column(name = "name", unique = true, nullable = false, length = 20)
    private String name;
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUserType")
    private UserTypeEntity idUserType;

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTypeEntity getUserType() {
        return idUserType;
    }

    public void setUserType(UserTypeEntity idUserType) {
        this.idUserType = idUserType;
    }
}
