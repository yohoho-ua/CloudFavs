package dao;


import mysql.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class GenericDaoMethods {
    public static void genericDelete(int id, String tableName) {
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.execute("DELETE FROM " + tableName + " WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void genericGetByPK(int id, String tableName) {
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.execute("SELECT FROM " + tableName + " WHERE id=" + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
