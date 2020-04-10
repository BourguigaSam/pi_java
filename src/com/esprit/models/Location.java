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
public class Location {

private int  id ;
private String matricule ;
private String marque;
private String model;
private String category;
private String puissance;
private double dailyPrice;
private String type;
private String image_id;

public Location(){}

public Location(int id,String matricule,String marque,String model,String category,String puissance,double dailyPrice,String type,String image_id){
this.id=id;
this.matricule=matricule;
this.marque=marque;
this.model=model;
this.category=category;
this.puissance=puissance;
this.dailyPrice=dailyPrice;
this.type=type;
this.image_id=image_id;

}
public Location(String matricule,String marque,String model,String category,String puissance,double dailyPrice,String type,String image_id){
this.matricule=matricule;
this.marque=marque;
this.model=model;
this.category=category;
this.puissance=puissance;
this.dailyPrice=dailyPrice;  
this.type=type;
this.image_id=image_id;
}
public Location(String matricule,String marque,String model,String category,String puissance,double dailyPrice){
this.matricule=matricule;
this.marque=marque;
this.model=model;
this.category=category;
this.puissance=puissance;
this.dailyPrice=dailyPrice;  
}
   

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    @Override
    public String toString() {
        return "Location{" + "matricule=" + matricule + ", marque=" + marque + ", model=" + model + ", category=" + category + ", puissance=" + puissance + ", dailyPrice=" + dailyPrice + '}';
    }

    public void getDailyPrice(double parseDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

}
