/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum;

/**
 *
 * @author Matti
 */
public class Kategoria {
    private int kategoria_id;
    private String kat_nimi;
    private String kat_kuvaus;
    
    public Kategoria(int id, String nimi, String kuvaus){
        this.kategoria_id = id;
        this.kat_nimi = nimi;
        this.kat_kuvaus = kuvaus;
    }
     public int getId(){
        return this.kategoria_id;
    }
    public String getNimi(){
        return this.kat_nimi;
    }
    public void setId(int param){
        this.kategoria_id = param;
    }
    public void setNimi(String nimi){
        this.kat_nimi = nimi;
    }
}
