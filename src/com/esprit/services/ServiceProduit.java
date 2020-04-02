/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Personne;
import com.esprit.models.Produit;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ServiceProduit {
    
        Connection cnx = DataSource.getInstance().getCnx();

    
       public void ajouterProduit(Produit produit) {
        try {
            String requete = "INSERT INTO produit (id,nom,description,prix,quantity,image_id,date) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, produit.getId());
            pst.setString(2, produit.getNom());
            pst.setString(3, produit.getDescription());
            pst.setDouble(4, produit.getPrix());
            pst.setInt(5, produit.getQuantity());
          //  pst.setObject(7, produit.getP());
            //pst.setInt(7, produit.getCategory());
            //pst.setInt(8, produit.getRegion());
         pst.setString(6,produit.getImage());
         pst.setDate(7, produit.getDate());
         
           pst.executeUpdate();
            System.out.println("Produit ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

       
        public void supprimerProduit(Produit produit) {
        try {
            String requete = "DELETE FROM produit WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, produit.getId());
            pst.executeUpdate();
            System.out.println("Produit supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void modifierProduit(Produit produit) {
        try {
            String requete = "UPDATE produit SET nom=?,description=?,prix=?,quantity=?,date=?,image_id=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, produit.getId());
            pst.setString(2, produit.getNom());
            pst.setString(3, produit.getDescription());
            pst.setDouble(4,produit.getPrix());
            pst.setInt(5, produit.getQuantity());
            pst.setDate(6, produit.getDate());
//            pst.setObject(7, produit.getP());
          //  pst.setInt(7,produit.getCategory());
           // pst.setInt(8,produit.getRegion());
            pst.setString(7, produit.getImage());
            pst.executeUpdate();
            System.out.println("Prduit modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public List<Produit> afficherProduit() {
        List<Produit> Produit_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM produit";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produit_list.add(new Produit(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getFloat("prix"),rs.getInt("quantity"),  rs.getString("image_id"),rs.getDate("date")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Produit_list;
    }
 
    
    
    
    
    
    
}
