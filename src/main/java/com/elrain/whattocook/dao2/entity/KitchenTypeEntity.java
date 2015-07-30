package com.elrain.whattocook.dao2.entity;

import javax.persistence.*;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "KitchenType")
@Table(name = "KitchenType", schema = "whattocook")
public class KitchenTypeEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idKitchenType")
    private Integer idKitchenType;
    private String name;

    public Integer getIdKitchenType() {
        return idKitchenType;
    }

    public void setIdKitchenType(Integer idKitchenType) {
        this.idKitchenType = idKitchenType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
