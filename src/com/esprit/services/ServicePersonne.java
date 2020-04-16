/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Personne;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aissa
 */
public class ServicePersonne implements IService<Personne> {

    Connection cnx = DataSource.getInstance().getCnx();
    private Statement ste;

    @Override
    public void ajouterPersonne(Personne t) {
        try {
            String requete = "INSERT INTO fos_user (username,username_canonical,email,email_canonical,password,roles) VALUES (?,?,?,?,?,'a:0:{}')";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getUsername_canonical());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getEmail_canonical());
            pst.setString(5, t.getPassword());
            pst.executeUpdate();
            System.out.println("Personne ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerPersonne(Personne t) {
        try {
            String requete = "DELETE FROM fos_user WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Personne supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierPersonne(Personne t) {
        try {
            String requete = "UPDATE fos_user SET username=?,email=?,password=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getEmail());
            pst.setString(3, t.getPassword());
            pst.executeUpdate();
            System.out.println("Personne modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Personne> afficherPersonne() {
        List<Personne> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM fos_user";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Personne(rs.getInt("id"), rs.getString("username"), rs.getString("email"),rs.getInt("enabled"),rs.getString("password"),rs.getDate("last_login"),rs.getString("roles"),rs.getString("image_id")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
    
     public Personne getUserByuserName(String username) {
        try {
            String req = "select * from fos_user where username=?";
            Personne u = null;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                u = new Personne(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString("roles"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }




 public Personne getUserById(int id) {
        try {
            String req = "select * from fos_user where id=?";
            Personne u =new Personne();
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                u = new Personne(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     public List<Personne> getAllUsers() {
        String req = "SELECT * FROM fos_user where roles NOT LIKE '%ROLE_SUPER_ADMIN%'";
        List<Personne> users = new ArrayList<>();
        try {
            Statement ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);            
            while (rs.next()){
                users.add(new Personne(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getInt("enabled"),rs.getString("password"), rs.getDate("last_Login"),rs.getString("roles"),  rs.getString("image_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }
     
     
     public int getVerif(String username) {
        //String pass = null;
        int pass = 0;
        try {
            String sql = "select * from fos_user where username='" + username + "';";

            Statement ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);

            if (rs.next()) {
                pass = rs.getInt("id");

            } else {
                pass = 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pass;

    }
     
     public List<Personne> displayMessage() {
     //   String r = "Association";
        List<Personne> myList = new ArrayList<>();

        try {
            String requete = "select distinct login_envoi from message_asso_famille ";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                Personne p = new Personne();
                // p.setId_p(rs.getInt("id_p"));
                p.setUsername(rs.getString("login_envoi"));
//                p.setPrenom_ff(rs.getString("prenom_db"));
//                p.setEmail_ff(rs.getString("email_db"));
//                p.setAdd_ff(rs.getString("add_db"));

                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;

    }
     
     
     
     
     
     
     public void ajouterFamille_mess(Personne fa) {
        String requete = "INSERT INTO message_asso_famille (id_message, login_envoi,login_recep,message,date  ) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, fa.getId());

            pst.setString(2, fa.getUsername());
            pst.setString(3, fa.getLogin_rec());

            pst.setString(4, fa.getMess());

            pst.setTimestamp(5, fa.getCurdate());
          //  pst.setString(6, fa.getRoles());
           // pst.setInt(7, fa.getId_recep());

            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
    }

     

     
    
     
     
     
     
     
      public ResultSet getAllUsersRS() {
        String req = "SELECT * FROM fos_user where roles NOT LIKE '%ROLE_SUPER_ADMIN%'";
        ResultSet rs = null;
        try {
            
            rs = ste.executeQuery(req);                        
        } catch (SQLException ex) {
            Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     

}
