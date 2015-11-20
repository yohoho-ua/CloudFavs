package dao;

import domain.Catalog;
import mysql.ConnectionProvider;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zim on 19.11.2015.
 */
public class CatalogDao implements GenericDao {
    @Override
    public void create(Serializable object) {

    }

    @Override
    public Serializable getByPK(int key) {
        return null;
    }

    @Override
    public void update(Serializable object) {

    }

    @Override
    public void delete(int id ) {

    }

    @Override
    public List<Catalog> getAll() {
        ArrayList <Catalog> catList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM CATALOGS")
        ) {
            while (rs.next()) {
                Catalog tempCatalog = new Catalog();
                tempCatalog.setId(rs.getInt("id"));
                tempCatalog.setName(rs.getString("name"));
                catList.add(tempCatalog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catList;
    }
}
