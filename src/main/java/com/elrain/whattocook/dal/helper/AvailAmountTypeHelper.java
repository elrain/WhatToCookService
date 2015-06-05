package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.AmountEntity;
import com.elrain.whattocook.dao.ManyToManyEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class AvailAmountTypeHelper extends Accessor {

    private static final String ID = "idAvailAmountType";
    private static final String ID_GROUPS = "idGroups";
    private static final String ID_AMOUNT_TYPE = "idAmountType";
    private static final String TABLE = "AvailAmountType";

    public AvailAmountTypeHelper() throws Exception {
    }

    public List<ManyToManyEntity> get(){
        List<ManyToManyEntity> result = new ArrayList<ManyToManyEntity>();
        try{
            Statement st = this.connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT " + ID + ", " + ID_GROUPS + ", " + ID_AMOUNT_TYPE + " FROM "
                    + TABLE + ";");
            while(resultSet.next()){
                ManyToManyEntity entity = new ManyToManyEntity(resultSet.getLong(ID), resultSet.getLong(ID_GROUPS),
                        resultSet.getLong(ID_AMOUNT_TYPE));
                result.add(entity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
