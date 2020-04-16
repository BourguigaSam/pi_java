/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author aissa
 */
public class Personne {

    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private int enabled;
    private String salt;
    private String password;
    private Date last_login;
    private String confirmation_token;
    private Date password_requested_at;
    private String roles ;
    private String image_id;
   
    private String login_rec;
    private String mess;
    private Timestamp curdate;

    
     public Personne(int id, String username, String login_rec, String mess, Timestamp curdate) {
        this.id = id;
         this.username = username;
        this.curdate = curdate;
        this.mess = mess;
        this.login_rec = login_rec;
    }

    
    public Timestamp getCurdate() {
        return curdate;
    }

    public void setCurdate(Timestamp curdate) {
        this.curdate = curdate;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getLogin_rec() {
        return login_rec;
    }

    public void setLogin_rec(String login_rec) {
        this.login_rec = login_rec;
    }

    
    
    public Personne(int id, String username, String username_canonical, String email, String email_canonical, int enabled, String salt, String password, Date last_login, String confirmation_token, Date password_requested_at, String roles, String image_id) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
        this.image_id = image_id;
    }

    public Personne(String username,String username_canonical,String email,String email_canonical,String password){
        this.username=username;
        this.username_canonical=username_canonical;
        this.email=email;
        this.email_canonical=email_canonical;
        this.password=password;
    }
    
     public Personne(String username,String username_canonical,String email,String email_canonical,String password,String roles){
        this.username=username;
        this.username_canonical=username_canonical;
        this.email=email;
        this.email_canonical=email_canonical;
        this.password=password;
        this.roles = roles;

    }
     public Personne(int id, String username, String email, int enabled, String password, Date last_login,String roles, String image_id) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.last_login = last_login;
       this.roles=roles;
        this.image_id = image_id;
    }

    

        public Personne(){
    }

   
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    @Override
    public String toString() {
        return "Personne{" + "username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", last_login=" + last_login + ", confirmation_token=" + confirmation_token + ", password_requested_at=" + password_requested_at + ", roles=" + roles + ", image_id=" + image_id + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
        
    
}
