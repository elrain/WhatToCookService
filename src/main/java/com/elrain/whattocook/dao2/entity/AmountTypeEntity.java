package com.elrain.whattocook.dao2.entity;

import javax.persistence.*;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "AmountType")
@Table(name = "AmountType", schema = "whattocook")
public class AmountTypeEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAmountType")
    private Integer idAmountType;
    private String name;

    public Integer getIdAmountType() {
        return idAmountType;
    }

    public void setIdAmountType(Integer idAmountType) {
        this.idAmountType = idAmountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
