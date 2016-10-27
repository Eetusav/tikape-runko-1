/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Matti
 */
public class Vastaukset {
    private int vastaus_id;
    private String vastaus;
    private Timestamp vastaus_aika;
    private Kayttaja vastaus_user;
    private Aihe vastaus_aihe;
    
    public Vastaukset(int vastaus_id, String vastaus, Timestamp vastausaika){
        this.vastaus_id = vastaus_id;
        this.vastaus = vastaus;
        this.vastaus_aika = vastausaika;
    }
    public int getId(){
        return this.vastaus_id;
    }
    public String getVastaus(){
        return this.vastaus;
    }
    public Timestamp getPvm(){
        return this.vastaus_aika;
    }
    public void setId(int id){
        this.vastaus_id = id;
    }
    public void setVastaus(String vastaus){
        this.vastaus = vastaus;
    }
    public void setKayttaja(Kayttaja kayttaja){
        this.vastaus_user = kayttaja;
    }
    public void setAihe(Aihe a){
        this.vastaus_aihe = a;
    }
}
