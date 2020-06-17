/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Personne;

/**
 *
 * @author ASUS
 */
public class Session {
   // private int id;
    private String username;
    private String password;
    private Personne user;
private static Session session;
   
    public Session() {
    }
  public static Session getInstance()
    {
        if(session == null) session = new Session();
        return session;
    }
    
        public static Personne ConnectedUser = new Personne();

    public Personne getUser() {
        return user;
    }

    public void setUser(Personne user) {
        this.user = user;
    }

    

 
     
  
   
    

  
        
    
   
    
}
