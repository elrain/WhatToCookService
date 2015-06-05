package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.NamedEntity;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 05.06.15.
 */
public class GroupHelper extends Accessor {


    private static final String NAME = "name";
    private static final String ID = "idGroups";
    private static final String TABLE = "Groups";

    public GroupHelper() throws Exception {
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
