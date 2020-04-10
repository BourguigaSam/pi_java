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
public class Blog {
    private int id;
    private String title; 
    private String content;
    private String image;
    private int repliesnumber; 
    private int likesnumber;
    private Date dateCreation;
    private int idauthor;
    private int categorie;
    private int accept;

    public Blog(){
        
    }
    
    public Blog(int id, String title, String content, String image, int repliesnumber, int likesnumber, Date dateCreation, int idauthor, int categorie, int accept) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.repliesnumber = repliesnumber;
        this.likesnumber = likesnumber;
        this.dateCreation = dateCreation;
        this.idauthor = idauthor;
        this.categorie = categorie;
        this.accept = accept;
    }
    
    
    public Blog( String title, String content, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRepliesnumber() {
        return repliesnumber;
    }

    public void setRepliesnumber(int repliesnumber) {
        this.repliesnumber = repliesnumber;
    }

    public int getLikesnumber() {
        return likesnumber;
    }

    public void setLikesnumber(int likesnumber) {
        this.likesnumber = likesnumber;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getIdauthor() {
        return idauthor;
    }

    public void setIdauthor(int idauthor) {
        this.idauthor = idauthor;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    @Override
    public String toString() {
        return "Blog{" + "title=" + title + ", content=" + content + ", image=" + image + ", repliesnumber=" + repliesnumber + ", likesnumber=" + likesnumber + ", dateCreation=" + dateCreation + ", idauthor=" + idauthor + ", categorie=" + categorie + ", accept=" + accept + '}';
    }
    
    
    
    
}
