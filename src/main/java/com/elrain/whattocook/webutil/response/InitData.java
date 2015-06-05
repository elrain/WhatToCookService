package com.elrain.whattocook.webutil.response;

import com.elrain.whattocook.dao.*;

import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class InitData {
    private List<NamedEntity> groups;
    private List<NamedEntity> kitchenTypes;
    private List<NamedEntity> dishTypes;
    private List<NamedEntity> amountTypes;
    private List<IngridientsEntity> ingridients;
    private List<ManyToManyEntity> amountTypesRules;
    private List<ManyToManyEntity> amountsInRecipes;
    private List<AmountEntity> amounts;
    private List<RecipeEntity> recipes;

    public InitData(List<NamedEntity> groups, List<NamedEntity> kitchenTypes, List<NamedEntity> dishTypes,
                    List<NamedEntity> amountTypes, List<IngridientsEntity> ingridients,
                    List<ManyToManyEntity> amountTypesRules, List<ManyToManyEntity> amountsInRecipes,
                    List<AmountEntity> amounts, List<RecipeEntity> recipes) {
        this.groups = groups;
        this.kitchenTypes = kitchenTypes;
        this.dishTypes = dishTypes;
        this.amountTypes = amountTypes;
        this.ingridients = ingridients;
        this.amountTypesRules = amountTypesRules;
        this.amountsInRecipes = amountsInRecipes;
        this.amounts = amounts;
        this.recipes = recipes;
    }

    public List<NamedEntity> getGroups() {
        return groups;
    }

    public List<NamedEntity> getKitchenTypes() {
        return kitchenTypes;
    }

    public List<NamedEntity> getDishTypes() {
        return dishTypes;
    }

    public List<NamedEntity> getAmountTypes() {
        return amountTypes;
    }

    public List<IngridientsEntity> getIngridients() {
        return ingridients;
    }

    public List<ManyToManyEntity> getAmountTypesRules() {
        return amountTypesRules;
    }

    public List<ManyToManyEntity> getAmountsInRecipes() {
        return amountsInRecipes;
    }

    public List<AmountEntity> getAmounts() {
        return amounts;
    }

    public List<RecipeEntity> getRecipes() {
        return recipes;
    }
}
