package com.elrain.whattocook.service;

import com.elrain.whattocook.dal.helper.*;
import com.elrain.whattocook.dao.*;
import com.elrain.whattocook.webutil.response.InitData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
@Path("/init")
public class InitService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public InitData initData() {
        try {
            List<NamedEntity> groups = new GroupHelper().get();

            List<NamedEntity> kitchenTypes = new KitchenTypeHelper().get();
            List<NamedEntity> dishTypes = new DishTypeHelper().get();
            List<NamedEntity> amountTypes = new AmountTypeHelper().get();
            List<IngridientsEntity> ingridients = new IngridientsHelper().get();
            List<ManyToManyEntity> amountTypesRules = new AvailAmountTypeHelper().get();
            List<ManyToManyEntity> amountsInRecipes = new AmountInRecipeHelper().get();
            List<AmountEntity> amounts = new AmountHelper().get();
            List<RecipeEntity> recipes = new RecipeHelper().get();

            return new InitData(groups, kitchenTypes, dishTypes, amountTypes, ingridients, amountTypesRules,
                    amountsInRecipes, amounts, recipes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
