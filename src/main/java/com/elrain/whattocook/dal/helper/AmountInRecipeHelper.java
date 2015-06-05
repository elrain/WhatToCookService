package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.ManyToManyEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class AmountInRecipeHelper extends Accessor {

    private static final String ID = "idAmountInRecipe";
    private static final String ID_RECIPE = "idRecipe";
    private static final String ID_AMOUNT = "idAmount";
    private static final String TABLE = "AmountInRecipe";

    public AmountInRecipeHelper() throws Exception {
    }

    public List<ManyToManyEntity> get(){
        List<ManyToManyEntity> result = new ArrayList<ManyToManyEntity>();
        try{
            Statement st = this.connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT " + ID + ", " + ID_RECIPE + ", " + ID_AMOUNT + " FROM "
                    + TABLE + ";");
            while(resultSet.next()){
                ManyToManyEntity entity = new ManyToManyEntity(resultSet.getLong(ID), resultSet.getLong(ID_RECIPE),
                        resultSet.getLong(ID_AMOUNT));
                result.add(entity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
