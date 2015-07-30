package com.elrain.whattocook.dao2.entity;

import javax.persistence.*;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "DishType")
@Table(name = "DishType", schema = "whattocook")
public class DishTypeEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iDdishType")
    private Integer iDdishType;
    private String name;

    public Integer getiDdishType() {
        return iDdishType;
    }

    public void setiDdishType(Integer iDdishType) {
        this.iDdishType = iDdishType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
