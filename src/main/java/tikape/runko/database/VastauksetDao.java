/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum.daot;

import com.mycompany.tikape.forum.Aihe;
import com.mycompany.tikape.forum.Kayttaja;
import com.mycompany.tikape.forum.Vastaukset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getInt;

/**
 *
 * @author Matti
 */
public class VastauksetDao implements Dao<Vastaukset, Integer> {

    private Database database;
    private Dao<Aihe, Integer> aiheDao;
    private Dao<Kayttaja, Integer> kayttajaDao;

    @Override
    public Vastaukset findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Vastaus WHERE vastaus_id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        Integer vastaus_id = getInt(rs.getString("vastaus_id"));
        String vastaus = rs.getString("vastaus");
        Timestamp vastaus_aika = rs.getTimestamp("vastaus_aika");

        int kirjoittaja = rs.getInt("vastaus_user");
        int aihe = rs.getInt("vastaus_aihe");
        Vastaukset v = new Vastaukset(vastaus_id, vastaus, vastaus_aika);

        rs.close();
        stmt.close();
        connection.close();

        v.setAihe(this.aiheDao.findOne(aihe));
        v.setKayttaja(this.kayttajaDao.findOne(kirjoittaja));

        return v;
    }

    @Override
    public List<Vastaukset> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Vastaukset");

        ResultSet rs = stmt.executeQuery();
        List<Vastaukset> vastaukset = new ArrayList<>();
        while (rs.next()) {
            int aihe_id = rs.getInt("vastaus_aihe");
            int kayttaja = rs.getInt("vastaus_user");

            int vastaus_id = rs.getInt("vastaus_id");
            String vastaus = rs.getString("vastaus");
            Timestamp vastaus_aika = rs.getTimestamp("vastaus_aika");
            Vastaukset v = new Vastaukset(vastaus_id, vastaus, vastaus_aika);
            v.setAihe(this.aiheDao.findOne(aihe_id));
            v.setKayttaja(this.kayttajaDao.findOne(kayttaja));
            vastaukset.add(v);

        }
        rs.close();
        stmt.close();
        connection.close();

        return vastaukset;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Vastaukset WHERE vastaus_id = ?");
        stmt.setObject(1, key);
        ResultSet rs = stmt.executeQuery();
        rs.deleteRow();
        rs.close();
        stmt.close();
        connection.close();
    }

}
