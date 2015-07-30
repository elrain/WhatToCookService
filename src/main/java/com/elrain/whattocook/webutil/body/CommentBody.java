package com.elrain.whattocook.webutil.body;

/**
 * Created by elrain on 24.06.15.
 */
public class CommentBody {
    private String text;
    private int userId;
    private int recipeId;

    public CommentBody(String text, int userId, int recipeId) {
        this.text = text;
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public CommentBody() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
