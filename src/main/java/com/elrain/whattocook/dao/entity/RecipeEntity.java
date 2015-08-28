package com.elrain.whattocook.dao.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by elrain on 24.07.15.
 */
@Entity(name = "Recipe")
@Table(name = "Recipe", schema = "whattocook")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRecipe")
    private Integer idRecipe;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "cookTime", nullable = false)
    private int cookTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idKitchenType")
    private KitchenTypeEntity kitchen;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDishType")
    private DishTypeEntity dishType;
    private String image;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AmountInRecipe", schema = "whattocook", joinColumns = {
            @JoinColumn(name = "idRecipe")}, inverseJoinColumns = {
            @JoinColumn(name = "idAmount")
    })
    private Set<AmountEntity> amounts = new HashSet<AmountEntity>();

    public Integer getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(Integer idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public KitchenTypeEntity getKitchen() {
        return kitchen;
    }

    public void setKitchen(KitchenTypeEntity kitchen) {
        this.kitchen = kitchen;
    }

    public DishTypeEntity getDishType() {
        return dishType;
    }

    public void setDishType(DishTypeEntity dishType) {
        this.dishType = dishType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<AmountEntity> getAmounts() {
        return amounts;
    }

    public void setAmounts(Set<AmountEntity> amounts) {
        this.amounts = amounts;
    }
}
