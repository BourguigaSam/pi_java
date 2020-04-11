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
public class Evenement {
private int id ;
private int id_guide ;
private int id_user ;
private String nom ;
private String nomImage ;
private Date dateDebut ;
private int nbre_participants ;
private String lieu;
private double prix;
private String type;
private Date datefin;

public Evenement(){
    
}
public Evenement(int id,int id_guide,int id_user,String nom,String nomImage,Date dateDebut,int nbre_participants,String lieu,double prix,String type,Date datefin){
this.id=id;
this.id_guide=id_guide;
this.id_user=id_user;
this.nom=nom;
this.nomImage=nomImage;
this.dateDebut=dateDebut;
this.datefin=datefin;
this.nbre_participants=nbre_participants;
this.lieu=lieu;
this.prix=prix;
this.type=type;
this.datefin=datefin;
    
}

public Evenement(int id_guide,int id_user,String nom,String nomImage,Date dateDebut,int nbre_participants,String lieu,double prix,String type,Date datefin){
this.id_guide=id_guide;
this.id_user=id_user;
this.nom=nom;
this.nomImage=nomImage;
this.dateDebut=dateDebut;
this.datefin=datefin;
this.nbre_participants=nbre_participants;
this.lieu=lieu;
this.prix=prix;
this.type=type;
this.datefin=datefin;
    
}

public Evenement(int id,String nom,Date dateDebut,int nbre_participants,String lieu,double prix,String type,Date datefin){
this.id=id;
this.nom=nom;
this.dateDebut=dateDebut;
this.nbre_participants=nbre_participants;
this.lieu=lieu;
this.prix=prix;
this.type=type;
this.datefin=datefin;
    
}
public Evenement(String nom,Date dateDebut,int nbre_participants,String lieu,double prix,String type,Date datefin){
this.nom=nom;
this.dateDebut=dateDebut;
this.nbre_participants=nbre_participants;
this.lieu=lieu;
this.prix=prix;
this.type=type;
this.datefin=datefin;
    
}

   public Evenement(int id,String nom,int nbre_participants,String lieu,double prix,String type){
this.id=id;
       this.nom=nom;
//this.dateDebut=dateDebut;
this.nbre_participants=nbre_participants;
this.lieu=lieu;
this.prix=prix;
this.type=type;
//this.datefin=datefin;
    
}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_guide() {
        return id_guide;
    }


    public void setId_guide(int id_guide) {
        this.id_guide = id_guide;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getNbre_participants() {
        return nbre_participants;
    }

    public void setNbre_participants(int nbre_participants) {
        this.nbre_participants = nbre_participants;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }




    @Override
    public String toString() {
        return "Evenement{" + "id_guide=" + id_guide + ", id_user=" + id_user + ", nom=" + nom + ", nomImage=" + nomImage + ", dateDebut=" + dateDebut + ", nbre_participants=" + nbre_participants + ", lieu=" + lieu + ", prix=" + prix + ", type=" + type + ", datefin=" + datefin + '}';
    }
    
    
    





    
}
