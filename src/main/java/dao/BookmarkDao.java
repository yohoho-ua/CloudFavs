package dao;

import domain.Bookmark;
import mysql.ConnectionProvider;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.GenericDaoMethods.genericDelete;


public class BookmarkDao implements GenericDao {
    @Override
    public void create(Serializable object) {
        Bookmark tempBookmark = (Bookmark) object;
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("INSERT INTO bookmarks (id, owner_id, title, create_time, update_time, url, preview, description, catalog_id) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            processPreparedStatement(preparedStatement, tempBookmark);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Serializable getByPK(int id) {
        Bookmark tempBookmark = new Bookmark();
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bookmarks WHERE id=?")
        ) {
            preparedStatement.setString(1, id + "");
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    tempBookmark = parseRS(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempBookmark;
    }

    @Override
    public void update(Serializable object) {
        Bookmark tempBookmark = (Bookmark) object;
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("UPDATE bookmarks SET id=?, owner_id=?, title=?, create_time=?, update_time=?, url=?, preview=?, description=?, catalog_id=?" +
                             " WHERE id=" + tempBookmark.getId())
        ) {
            processPreparedStatement(preparedStatement, tempBookmark);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        genericDelete(id, "bookmarks");
    }

    @Override
    public List<Bookmark> getAll() {
        ArrayList<Bookmark> bmList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM bookmarks")
        ) {
            while (rs.next()) {

                Bookmark tempBookmark = parseRS(rs);
                bmList.add(tempBookmark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bmList;
    }


    public ArrayList<Bookmark> getByCatalog(int cat_id) {
        ArrayList<Bookmark> bmList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM bookmarks WHERE catalog_id=" + cat_id)
        ) {
            while (rs.next()) {

                Bookmark tempBookmark = parseRS(rs);
                bmList.add(tempBookmark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bmList;
    }

    private Bookmark parseRS(ResultSet rs) {
        Bookmark tempBookmark = new Bookmark();
        try {
            tempBookmark.setId(rs.getInt("id"));
            tempBookmark.setOwner_id(rs.getInt("owner_id"));
            tempBookmark.setTitle(rs.getString("title"));
            tempBookmark.setDate_created(rs.getTimestamp("create_time"));
            tempBookmark.setDate_updated(rs.getTimestamp("update_time"));
            tempBookmark.setUrl(rs.getString("url"));
            tempBookmark.setPreview(rs.getString("preview"));
            tempBookmark.setDescription(rs.getString("description"));
            tempBookmark.setCatalog_id(rs.getInt("catalog_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempBookmark;
    }

    private void processPreparedStatement(PreparedStatement preparedStatement, Bookmark tempBookmark) {
        try {
            preparedStatement.setInt(1, tempBookmark.getId());
            preparedStatement.setInt(2, tempBookmark.getOwner_id());
            preparedStatement.setString(3, tempBookmark.getTitle());
            preparedStatement.setTimestamp(4, new Timestamp (tempBookmark.getDate_created().getTime()));
//            preparedStatement.setDate(5, new Date(tempBookmark.getDate_created().getTime()));
            preparedStatement.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
            preparedStatement.setString(6, tempBookmark.getUrl());
            preparedStatement.setString(7, tempBookmark.getPreview());
            preparedStatement.setString(8, tempBookmark.getDescription());
            preparedStatement.setInt(9, tempBookmark.getCatalog_id());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}