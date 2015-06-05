package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.IngridientsEntity;
import com.elrain.whattocook.dao.NamedEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class IngridientsHelper extends Accessor {
    private static final String NAME = "name";
    private static final String ID = "idIngridients";
    private static final String ID_GROUPS = "idGroups";
    private static final String TABLE = "Ingridients";

    public IngridientsHelper() throws Exception {
    }

    public List<IngridientsEntity> get() {
        List<IngridientsEntity> result = new ArrayList<IngridientsEntity>();
        try {
            Statement st = this.connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT " + ID + ", " + NAME + ", " + ID_GROUPS + " FROM " + TABLE + ";");
            while (resultSet.next()) {
                IngridientsEntity entity = new IngridientsEntity(resultSet.getLong(ID), resultSet.getString(NAME),
                        resultSet.getLong(ID_GROUPS));
                result.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
