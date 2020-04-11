/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Contrat;
import com.esprit.models.Location;
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
public class ServiceContrat {



  Connection cnx = DataSource.getInstance().getCnx();

    public void ajouterContrat(Contrat c) {
        try {
            String requete = "INSERT INTO personne (id,owner,date_debut_location,date_fin_location,date,type,location,barcode) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.setInt (2, c.getOwner());
            pst.setDate (3, c.getDate_debut_location());
            pst.setDate (4, c.getDate_fin_location());
            pst.setDate (5, c.getDate());
            pst.setString(6,c.getType());
            pst.setObject(7,c.getLocation());
            pst.setString(8, c.getBarcode());           
            pst.executeUpdate();
            System.out.println("Contrat ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void supprimerContrat(Contrat c) {
        try {
            String requete = "DELETE FROM contrar WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.executeUpdate();
            System.out.println("Contrat supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void modifierContrat(Contrat c) {
        try {
            String requete = "UPDATE contrat SET id=?,owner=?,date_debut_locatin=?,date_fin_location=?,date=?,type=?,location=?,barcode=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.setInt(2, c.getOwner());
            pst.setDate(3, c.getDate_debut_location());
            pst.setDate(4, c.getDate_fin_location());
            pst.setDate(5, c.getDate());
            pst.setString(6, c.getType());
            pst.setObject(7, c.getLocation());
            pst.setString(8, c.getBarcode());
            pst.executeUpdate();
            System.out.println("Contrat modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Contrat> afficherContrat() {
        List<Contrat> contrat_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM contrat";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                contrat_list.add(new Contrat(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4),rs.getDate(5),rs.getString(6),(Location)rs.getObject(7),rs.getString(8)));
                contrat_list.add(new Contrat());
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return contrat_list;
    }







    
}
