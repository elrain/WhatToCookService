package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.AmountEntity;
import com.elrain.whattocook.dao.NamedEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class AmountHelper extends Accessor {

    private static final String ID = "idAmount";
    private static final String ID_INGRIDIENT = "idIngridient";
    private static final String ID_AMOUNT_TYPE = "idAmountType";
    private static final String COUNT = "count";
    private static final String TABLE = "Amount";

    public AmountHelper() throws Exception {
    }

    public List<AmountEntity> get(){
        List<AmountEntity> result = new ArrayList<AmountEntity>();
        try{
            Statement st = this.connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT " + ID + ", " + COUNT + ", " + ID_INGRIDIENT + "" +
                    ", " + ID_AMOUNT_TYPE + " FROM " + TABLE + ";");
            while(resultSet.next()){
                AmountEntity entity = new AmountEntity(resultSet.getLong(ID), resultSet.getInt(COUNT),
                        resultSet.getLong(ID_INGRIDIENT), resultSet.getLong(ID_AMOUNT_TYPE));
                result.add(entity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
