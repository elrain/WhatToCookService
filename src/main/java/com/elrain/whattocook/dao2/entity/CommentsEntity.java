package com.elrain.whattocook.dao2.entity;

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
    private int idUser;

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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }
}
