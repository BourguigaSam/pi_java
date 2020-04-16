/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

/**
 *
 * @author Ahmed
 */
public class Participation {
    private int id;
    private int id_user;
    private int id_event;
    private String validite;

    public Participation() {
    }

    public Participation(int id, int id_user, int id_event, String validite) {
        this.id = id;
        this.id_user = id_user;
        this.id_event = id_event;
        this.validite = validite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getValidite() {
        return validite;
    }

    public void setValidite(String validite) {
        this.validite = validite;
    }

    @Override
    public String toString() {
        return "Participation{" + "id=" + id + ", id_user=" + id_user + ", id_event=" + id_event + ", validite=" + validite + '}';
    }
    
    
}
