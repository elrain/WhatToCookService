package com.elrain.whattocook.webutil.response;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by elrain on 06.08.15.
 */
public class CommentsResponse {

    private int commentId;
    private String text;
    private Date time;
    private String userName;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
