package com.elrain.whattocook.dal.helper;

import com.elrain.whattocook.dal.Accessor;
import com.elrain.whattocook.dao.CommentsEntity;
import com.elrain.whattocook.webutil.body.CommentBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 24.06.15.
 */
public class CommentsHelper extends Accessor {
    private static final String GET_COMMENTS_FOR_RECIPE = "getCommentsForRecipe";
    private static final String ID_COMMENTS = "idComments";
    private static final String TEXT = "text";
    private static final String TIME = "time";
    private static final String NAME = "name";
    private static final String ADD_COMMENT = "addComment";

    public CommentsHelper() throws Exception {
    }

    public List<CommentsEntity> getComments(long recipeId) throws SQLException {
        List<CommentsEntity> result = new ArrayList<CommentsEntity>();
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery("CALL " + GET_COMMENTS_FOR_RECIPE + "(" + String.valueOf(recipeId) + ");");
        while (rs.next()) {
            CommentsEntity ce = new CommentsEntity(rs.getLong(ID_COMMENTS), rs.getString(TEXT), rs.getString(TIME),
                    rs.getString(UsersHelper.USER_NAME));
            result.add(ce);
        }
        return result;
    }

    public void addComment(CommentBody comment) throws SQLException {
        Statement st = this.connection.createStatement();
        int n = st.executeUpdate("CALL " + ADD_COMMENT + "(" + comment.getUserId() + "," + comment.getRecipeId() + ",'"
                + comment.getText() + "');");
    }
}
