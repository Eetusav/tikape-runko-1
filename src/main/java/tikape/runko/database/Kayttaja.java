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
public class Kayttaja {
    private int user_id;
    private String user_nimi;
    
    public Kayttaja(int user_id, String user_nimi){
        this.user_id = user_id;
        this.user_nimi = user_nimi;
    }
    public int getId(){
        return this.user_id;
    }
    public String getNimi(){
        return this.user_nimi;
    }
    public void setId(int param){
        this.user_id = param;
    }
    public void setNimi(String nimi){
        this.user_nimi = nimi;
    }
}
