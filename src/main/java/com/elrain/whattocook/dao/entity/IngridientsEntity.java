package com.elrain.whattocook.dao.entity;

import javax.persistence.*;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "Ingridients")
@Table(name = "Ingridients", schema = "whattocook")
public class IngridientsEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idIngridient")
    private Integer idIngridient;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idGroup")
    private GroupsEntity group;

    public Integer getIdIngridient() {
        return idIngridient;
    }

    public void setIdIngridient(Integer idIngridients) {
        this.idIngridient = idIngridients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupsEntity getGroup() {
        return group;
    }

    public void setGroup(GroupsEntity group) {
        this.group = group;
    }
}
