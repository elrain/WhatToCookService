package com.elrain.whattocook.dao.entity;

import javax.persistence.*;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "DishType")
@Table(name = "DishType", schema = "whattocook")
public class DishTypeEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDishType")
    private Integer idDishType;
    private String name;

    public Integer getIdDishType() {
        return idDishType;
    }

    public void setIdDishType(Integer idDishType) {
        this.idDishType = idDishType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
