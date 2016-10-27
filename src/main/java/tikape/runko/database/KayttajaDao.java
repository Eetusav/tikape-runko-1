/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum.daot;

import com.mycompany.tikape.forum.Kayttaja;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Matti
 */
import java.util.*;
import java.sql.*;

public class KayttajaDao implements Dao<Kayttaja, Integer> {

    private Database database;

    public KayttajaDao(Database database) {
        this.database = database;
    }

    @Override
    public Kayttaja findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kayttaja WHERE user_id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        Integer user_id = Integer.parseInt(rs.getString("user_id"));
        String user_nimi = rs.getString("user_nimi");

        Kayttaja k = new Kayttaja(user_id, user_nimi);

        rs.close();
        stmt.close();
        connection.close();

        return k;
    }

    @Override
    public List<Kayttaja> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kayttaja");

        ResultSet rs = stmt.executeQuery();
        List<Kayttaja> kayttajat = new ArrayList<>();
        while (rs.next()) {
            int user_id = rs.getInt("user_id");
            String user_nimi = rs.getString("user_nimi");
            kayttajat.add(new Kayttaja(user_id, user_nimi));
        }
        rs.close();
        stmt.close();
        connection.close();

        return kayttajat;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kayttaja WHERE user_id = ?");
        stmt.setObject(1, key);
        ResultSet rs = stmt.executeQuery();
        rs.deleteRow();
        rs.close();
        stmt.close();
        connection.close();
    }

}
