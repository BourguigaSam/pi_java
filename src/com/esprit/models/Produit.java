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
public class Produit {
 
    private int id ;
    private String nom;
    private String description; 
    private double prix;
    private int quantity; 
    private Date date; 
    private Personne p;
    private int category;
    private int region ; 
    private String image;
    
    public Produit(){}   
    
    public Produit(int id,String nom,String description,double prix,int quantity,Date date,int category,int region,String image){
        this.id=id;
        this.nom=nom;
        this.description=description;
        this.prix=prix;
        this.quantity=quantity;
        this.date=date;
       // this.p=p;
        this.category=category;
        this.region=region;
        this.image=image;

    }   
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    public Produit(String nom,String description,double prix,int quantity,Date date,Personne p,int category,int region,String image){
        this.nom=nom;
        this.description=description;
        this.prix=prix;
        this.quantity=quantity;
        this.date=date;
        this.p=p;
        this.category=category;
        this.region=region;
        this.image=image;

    }
   
    
     public Produit(int id ,String nom,String description,double prix,int quantity,String image,Date date){
       this.id=id;
         this.nom=nom;
        this.description=description;
        this.prix=prix;
        this.quantity=quantity;
   this.image=image;
        this.date=date;
        
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Personne getP() {
        return p;
    }

    public void setP(Personne p) {
        this.p = p;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Produit{" + "nom=" + nom + ", description=" + description + ", prix=" + prix + ", quantity=" + quantity + ", date=" + date + ", p=" + p + ", category=" + category + ", region=" + region + '}';
    }
    
    
    
    

    
}
