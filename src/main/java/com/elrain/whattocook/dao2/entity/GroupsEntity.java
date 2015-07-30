package com.elrain.whattocook.dao2.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by elrain on 21.07.15.
 */
@Entity(name = "Groups")
@Table(name = "Groups", schema = "whattocook")
public class GroupsEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idGroups")
    private Integer idGroup;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AvailAmountType", schema = "whattocook", joinColumns = {
            @JoinColumn(name = "idGroups")},
            inverseJoinColumns = {
            @JoinColumn(name = "idAmountType")
    })
    private Set<AmountTypeEntity> amountTypes = new HashSet<AmountTypeEntity>();

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AmountTypeEntity> getAmountTypes() {
        return amountTypes;
    }

    public void setAmountTypes(Set<AmountTypeEntity> amountTypes) {
        this.amountTypes = amountTypes;
    }
}
