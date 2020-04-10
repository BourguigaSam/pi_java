/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

/**
 *
 * @author LENOVO
 */
public class Orders {
private int id ;
private Personne personne;
private String state;
private String country ;
private String zipcode;
private String etat;
private int phone;
private float price;
private Produit produit;

public Orders(){
    
}
public Orders(int id,Personne personne,String state,String country,String zipcode,String etat,int phone,float price,Produit produit){
this.id=id;
this.personne=personne;
this.state=state;
this.country=country;
this.zipcode=zipcode;
this.etat=etat;
this.phone=phone;
this.price=price;
this.produit=produit;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Orders{" + "personne=" + personne + ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + ", etat=" + etat + ", phone=" + phone + ", price=" + price + ", produit=" + produit + '}';
    }







}
