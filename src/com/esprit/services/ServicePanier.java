/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Panier;
import com.esprit.models.Personne;
import com.esprit.models.Produit;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class ServicePanier {


    Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Panier pan) {
        try {
            String requete = "INSERT INTO panier (user,produit_id,quantite,prix,date_p) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setObject(1, pan.getPersonne());
            pst.setObject(2, pan.getProduit());
            pst.setInt(1, pan.getQuantity());
            pst.setFloat(1, pan.getPrix());
            pst.setDate(1, pan.getDate_p());
            pst.executeUpdate();
            System.out.println("Panier !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimer(Panier pan) {
        try {
            String requete = "DELETE FROM panier WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, pan.getId());
            pst.executeUpdate();
            System.out.println("Panier supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifier(Panier pan) {
        try {
            String requete = "UPDATE panier SET user=?,produit_id=?,quantity=?,prix=?,date_p=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, pan.getId());
            pst.setObject(1, pan.getPersonne());
            pst.setObject(2, pan.getProduit());
            pst.setInt(4, pan.getQuantity());
            pst.setFloat(5, pan.getPrix());
            pst.setDate(6, pan.getDate_p());
            pst.executeUpdate();
            System.out.println("Panier modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public List<Panier> afficher() {
        List<Panier> panier_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM panier";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                panier_list.add(new Panier(rs.getInt(1),(Personne) rs.getObject(2),(Produit) rs.getObject(3), rs.getInt(4),rs.getFloat(5),rs.getDate(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return panier_list;
    }




    
}
