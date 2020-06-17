/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

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
public class ServiceProduit {

    Connection cnx = DataSource.getInstance().getCnx();

    public void ajouterProduit(Produit produit) {
        try {
            String requete = "INSERT INTO produit (nom,description,prix,quantity,image_id) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, produit.getNom());
            pst.setString(2, produit.getDescription());
            pst.setDouble(3, produit.getPrix());
            pst.setInt(4, produit.getQuantity());
            pst.setString(5, produit.getImage());

            pst.executeUpdate();
            System.out.println("Produit ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerProduit(Produit prod) {
        try {
            String requete = "DELETE FROM produit WHERE`id`=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, prod.getId());
            pst.executeUpdate();
            System.out.println("Produit supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifierProduit(Produit prod) {
        try {
            String requete = "UPDATE produit SET `nom`=?,`description`=?,`prix`=?,`quantity`=?,`date`=?,`image_id`=? WHERE `id`=?";
            PreparedStatement pst = cnx.prepareStatement(requete);

            pst.setString(1, prod.getNom());
            pst.setString(2, prod.getDescription());
            pst.setDouble(3, prod.getPrix());
            pst.setInt(4, prod.getQuantity());
            pst.setDate(5, prod.getDate());
            pst.setString(6, prod.getImage());
           
            pst.setInt(7, prod.getId());
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
                Produit_list.add(new Produit(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getFloat("prix"), rs.getInt("quantity"), rs.getString("image_id"), rs.getDate("date")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Produit_list;
    }
      public int afficherNombreProduit() {
      int a=0;
        try {
            String requete = "SELECT count(*) FROM produit";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
a=rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return a;
    }

}
