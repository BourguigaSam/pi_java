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
public class Panier {
private int id;
private Personne personne ;
private Produit produit ;
private int quantity;
private float prix;
private Date date_p;

    
public Panier(){}
public Panier(int id,Personne personne,Produit produit,int quantity,float prix,Date date_p){
    this.id=id;
    this.personne=personne;
    this.produit=produit;
    this.quantity=quantity;
    this.prix=prix;
    this.date_p=date_p;
}
public Panier(Personne personne,Produit produit,int quantity,float prix,Date date_p){
    this.personne=personne;
    this.produit=produit;
    this.quantity=quantity;
    this.prix=prix;
    this.date_p=date_p;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate_p() {
        return date_p;
    }

    public void setDate_p(Date date_p) {
        this.date_p = date_p;
    }

    @Override
    public String toString() {
        return "Panier{" + "personne=" + personne + ", produit=" + produit + ", quantity=" + quantity + ", prix=" + prix + ", date_p=" + date_p + '}';
    }
    



}
