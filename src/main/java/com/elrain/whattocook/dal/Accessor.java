package com.elrain.whattocook.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by elrain on 05.06.15.
 */
public class Accessor {

    private static Accessor mInstance;
    protected Connection connection;
    private Statement stat;

    public Accessor() throws Exception {
        this.getClass().forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/whattocook?useUnicode=true&characterEncoding=utf8";
        String user = "whattocook1";
        String password = "police1";

        if (null == connection)
            connection = DriverManager.getConnection(url, user, password);
    }

    public void closeConnection()
            throws SQLException {
        if (connection != null) {
            stat.close();
            connection.close();
        }
    }
}