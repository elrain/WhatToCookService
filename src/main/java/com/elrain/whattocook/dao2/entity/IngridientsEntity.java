package com.elrain.whattocook.dao2.entity;

import javax.persistence.*;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "Ingridients")
@Table(name = "Ingridients", schema = "whattocook")
public class IngridientsEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idIngridients")
    private Integer idIngridients;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idGroups")
    private GroupsEntity group;

    public Integer getIdIngridients() {
        return idIngridients;
    }

    public void setIdIngridients(Integer idIngridients) {
        this.idIngridients = idIngridients;
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
