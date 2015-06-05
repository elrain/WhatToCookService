package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.NamedEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class DishTypeHelper extends Accessor {


    private static final String NAME = "name";
    private static final String ID = "iDdishType";
    private static final String TABLE = "DishType";

    public DishTypeHelper() throws Exception {
    }

    public List<NamedEntity> get(){
        List<NamedEntity> result = new ArrayList<NamedEntity>();
        try{
            Statement st = this.connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT " + ID + ", " + NAME + " FROM " + TABLE + ";");
            while(resultSet.next()){
                NamedEntity no = new NamedEntity();
                no.setId(resultSet.getLong(ID));
                no.setName(resultSet.getString(NAME));
                result.add(no);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
