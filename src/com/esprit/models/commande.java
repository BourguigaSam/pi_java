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
public class commande {
   private int id ;
    private int idf;
    private int idc;
    private int prix;
    private int stock;
    private int quantite;
    private int rating;
    private int age;
    private String nom;
    private String image;
    private String categorie;
    private String description;
    private String genre;

    private int valide=0;

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    
    
    public commande() {
    }

    public commande(int id, int idf,int idc, int prix, int stock, int quantite, int rating, int age, String nom, String image, String categorie, String description, String genre,int valide) {
        this.id = id;
        this.idf = idf;
        this.idc = idc;
        this.prix = prix;
        this.stock = stock;
        this.quantite = quantite;
        this.rating = rating;
        this.age = age;
        this.nom = nom;
        this.image = image;
        this.categorie = categorie;
        this.description = description;
        this.genre = genre;
        this.valide = valide;
    }
    
    @Override
    public String toString() {
        return "commande{" + "id=" + id + ", idf=" + idf + ", idc=" + idc + ", prix=" + prix + ", stock=" + stock + ", quantite=" + quantite + ", rating=" + rating + ", age=" + age + ", nom=" + nom + ", image=" + image + ", categorie=" + categorie + ", description=" + description + ", genre=" + genre + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

     
}
