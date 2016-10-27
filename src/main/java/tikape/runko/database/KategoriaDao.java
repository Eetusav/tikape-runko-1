/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum.daot;

import com.mycompany.tikape.forum.Kategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Matti
 */
public class KategoriaDao implements Dao<Kategoria, Integer> {

    private Database database;

    @Override
    public Kategoria findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kategoria WHERE kategoria_id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer kategoria_id = rs.getInt("kategoria_id");
        String kat_nimi = rs.getString("kat_nimi");
        String kat_kuvaus = rs.getString("kat_kuvaus");

        Kategoria k = new Kategoria(kategoria_id, kat_nimi, kat_kuvaus);
        rs.close();
        stmt.close();
        connection.close();

        return k;

    }

    @Override
    public List<Kategoria> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kategoria");
        ResultSet rs = stmt.executeQuery();

        List<Kategoria> kategoriat = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("kategoria_id");
            String nimi = rs.getString("kat_nimi");
            String kat_kuvaus = rs.getString("kat_kuvaus");

            kategoriat.add(new Kategoria(id, nimi, kat_kuvaus));
        }
        rs.close();
        stmt.close();
        connection.close();
        return kategoriat;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kategoria WHERE kategoria_id = ?");
        stmt.setObject(1, key);
        ResultSet rs = stmt.executeQuery();
        rs.deleteRow();
        rs.close();
        stmt.close();
        connection.close();
    }

}
