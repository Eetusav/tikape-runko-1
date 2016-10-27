/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum;

import java.sql.Timestamp;
import java.util.*;

/**
 *
 * @author Matti
 */
public class Aihe {

    private int aihe_id;
    private String aihe_nimi;
    private Timestamp aihe_pvm;
    private Kayttaja aihe_user;
    private Kategoria aihe_kat;

    public Aihe(int id, String nimi, Timestamp pvm) {
        this.aihe_id = id;
        this.aihe_nimi = nimi;
        this.aihe_pvm = pvm;
    }

    public int getId() {
        return this.aihe_id;
    }

    public String getNimi() {
        return this.aihe_nimi;
    }

    public Timestamp getPvm() {
        return this.aihe_pvm;
    }

    public void setId(int id) {
        this.aihe_id = id;
    }

    public void setNimi(String nimi) {
        this.aihe_nimi = nimi;
    }

    public void setKayttaja(Kayttaja k) {
        this.aihe_user = k;
    }

    public void setKategoria(Kategoria a) {
        this.aihe_kat = a;
    }
}
