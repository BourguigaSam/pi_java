/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Contrat {
private int id; 
private int owner;
private Date date_debut_location;
private Date date_fin_location;
private Date date;
private String type; 
private int location ;
private String barcode;
private int AcceptContract;
private int phoneNumber;

public Contrat(){
    
}

    public Contrat(int id, int owner, Date date_debut_location, Date date_fin_location, Date date, String type, int location, String barcode, int AcceptContract, int phoneNumber) {
        this.id = id;
        this.owner = owner;
        this.date_debut_location = date_debut_location;
        this.date_fin_location = date_fin_location;
        this.date = date;
        this.type = type;
        this.location = location;
        this.barcode = barcode;
        this.AcceptContract = AcceptContract;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public Date getDate_debut_location() {
        return date_debut_location;
    }

    public void setDate_debut_location(Date date_debut_location) {
        this.date_debut_location = date_debut_location;
    }

    public Date getDate_fin_location() {
        return date_fin_location;
    }

    public void setDate_fin_location(Date date_fin_location) {
        this.date_fin_location = date_fin_location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getAcceptContract() {
        return AcceptContract;
    }

    public void setAcceptContract(int AcceptContract) {
        this.AcceptContract = AcceptContract;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contrat{" + "id=" + id + ", owner=" + owner + ", date_debut_location=" + date_debut_location + ", date_fin_location=" + date_fin_location + ", date=" + date + ", type=" + type + ", location=" + location + ", barcode=" + barcode + ", AcceptContract=" + AcceptContract + ", phoneNumber=" + phoneNumber + '}';
    }


    
}
