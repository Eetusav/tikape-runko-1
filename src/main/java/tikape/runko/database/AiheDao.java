/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum.daot;

import com.mycompany.tikape.forum.Aihe;
import com.mycompany.tikape.forum.Kategoria;
import com.mycompany.tikape.forum.Kayttaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matti
 */
public class AiheDao implements Dao<Aihe, Integer> {

    private Database database;
    private Dao<Kayttaja, Integer> userDao;
    private Dao<Kategoria, Integer> katDao;

    @Override
    public Aihe findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Aihe WHERE aihe_id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        Integer aihe_id = Integer.parseInt(rs.getString("aihe_id"));
        String aihe_nimi = rs.getString("aihe_nimi");
        Timestamp pvm = rs.getTimestamp("aihe_pvm");
        int kat_id = rs.getInt("aihe_kat");
        int user_id = rs.getInt("aihe_user");

        Aihe a = new Aihe(aihe_id, aihe_nimi, pvm);
        a.setKategoria(this.katDao.findOne(kat_id));
        a.setKayttaja(this.userDao.findOne(user_id));

        rs.close();
        stmt.close();
        connection.close();

        return a;
    }

    @Override
    public List<Aihe> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Aihe");

        ResultSet rs = stmt.executeQuery();
        List<Aihe> aiheet = new ArrayList<>();
        while (rs.next()) {
            int aihe_id = rs.getInt("aihe_id");
            String aihe_nimi = rs.getString("aihe_nimi");
            Timestamp aihe_pvm = rs.getTimestamp("aihe_pvm");
            Aihe a = new Aihe(aihe_id, aihe_nimi, aihe_pvm);
            int kat_id = rs.getInt("aihe_kat");
            int user_id = rs.getInt("aihe_user");
            a.setKategoria(this.katDao.findOne(kat_id));
            a.setKayttaja(this.userDao.findOne(user_id));
            aiheet.add(a);
        }
        rs.close();
        stmt.close();
        connection.close();

        return aiheet;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Aihe WHERE aihe_id = ?");
        stmt.setObject(1, key);
        ResultSet rs = stmt.executeQuery();
        rs.deleteRow();
        rs.close();
        stmt.close();
        connection.close();
    }

}
