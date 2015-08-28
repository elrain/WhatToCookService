package com.elrain.whattocook.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "Comments")
@Table(name = "Comments", schema = "whattocook")
public class CommentsEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idComments")
    private Integer idComments;
    @Column(name = "text", nullable = false)
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    private int idRecipe;
    @OneToOne
    @JoinColumn(name = "idUser")
    private UsersEntity user;

    public Integer getIdComments() {
        return idComments;
    }

    public void setIdComments(Integer idComments) {
        this.idComments = idComments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
