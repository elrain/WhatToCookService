package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.AmountEntity;
import com.elrain.whattocook.dao.RecipeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class RecipeHelper extends Accessor {

    private static final String ID = "idRecipe";
    private static final String ID_KITCHEN_TYPE = "idKitchenType";
    private static final String ID_DISH_TYPE = "idDishType";
    private static final String COOK_TIME = "cookTime";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String TABLE = "Recipe";

    public RecipeHelper() throws Exception {
    }

    public List<RecipeEntity> get() {
        List<RecipeEntity> result = new ArrayList<RecipeEntity>();
        try {
            Statement st = this.connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT " + ID + ", " + NAME + ", " + ID_KITCHEN_TYPE + "" +
                    ", " + ID_DISH_TYPE + ", " + DESCRIPTION + ", "+COOK_TIME+" FROM " + TABLE + ";");
            while (resultSet.next()) {
                RecipeEntity entity = new RecipeEntity(resultSet.getLong(ID), resultSet.getString(NAME),
                        resultSet.getString(DESCRIPTION), resultSet.getInt(COOK_TIME), resultSet.getLong(ID_KITCHEN_TYPE),
                        resultSet.getLong(ID_DISH_TYPE));
                result.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
