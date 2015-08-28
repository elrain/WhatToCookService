package com.elrain.whattocook.dao.entity;

import javax.persistence.*;

/**
 * Created by elrain on 23.07.15.
 */
@Entity(name = "Amount")
@Table(name = "Amount", schema = "whattocook")
public class AmountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAmount")
    private Integer idAmount;
    private Integer count;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idIngridient")
    private IngridientsEntity ingridient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAmountType")
    private AmountTypeEntity amountType;

    public Integer getIdAmount() {
        return idAmount;
    }

    public void setIdAmount(Integer idAmount) {
        this.idAmount = idAmount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public IngridientsEntity getIngridient() {
        return ingridient;
    }

    public void setIngridient(IngridientsEntity ingridient) {
        this.ingridient = ingridient;
    }

    public AmountTypeEntity getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountTypeEntity amountType) {
        this.amountType = amountType;
    }
}
