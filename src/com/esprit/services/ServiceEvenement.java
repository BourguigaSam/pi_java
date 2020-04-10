/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Evenement;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class ServiceEvenement {

        Connection cnx = DataSource.getInstance().getCnx();


public void ajouterEvenement(Evenement e) {
        try {
            String requete = "INSERT INTO evenement (id,nom,dateDebut,nbre_participants,lieu,prix,type,datefin) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, e.getId());
            pst.setString(2, e.getNom());
            pst.setDate(3, e.getDateDebut());
            pst.setInt(4, e.getNbre_participants());
            pst.setString(5, e.getLieu());
            pst.setDouble(6, e.getPrix());
            pst.setString(7, e.getType());
            pst.setDate(8, e.getDatefin());          
            pst.executeUpdate();
            System.out.println("Evenement ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void supprimer(Evenement e) {
        try {
            String requete = "DELETE FROM evenement WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, e.getId());
            pst.executeUpdate();
            System.out.println("Evenement supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void modifier(Evenement e) {
        try {
            String requete = "UPDATE evenement SET nom=?,dateDebut=?,nbre_participants=?,lieu=?,prix=?,type=?,datefin=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, e.getNom());
            pst.setDate(2, e.getDateDebut());
            pst.setInt(3, e.getNbre_participants());
            pst.setString(4, e.getLieu());
            pst.setDouble(5, e.getPrix());
            pst.setString(6, e.getType());
            pst.setDate(7, e.getDatefin());
      


            pst.executeUpdate();
            System.out.println("Evenement modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Evenement> afficherEvenement() {
        List<Evenement> evenement_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM evenement";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
        evenement_list.add(new Evenement(rs.getInt("id"), rs.getString("nom"), rs.getDate("dateDebut"), rs.getInt("nbre_participants"),rs.getString("lieu"), rs.getDouble("prix"),rs.getString("type"), rs.getDate("datefin")));
 
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return evenement_list;
    }


public ObservableList<Evenement> getEv1() {
     
        List<Evenement> evenement_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM evenement";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
        evenement_list.add(new Evenement(rs.getInt("id"), rs.getString("nom"), rs.getDate("dateDebut"), rs.getInt("nbre_participants"),rs.getString("lieu"), rs.getDouble("prix"),rs.getString("type"), rs.getDate("datefin")));
 
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return (ObservableList<Evenement>) evenement_list;
    }


 public void updateEvenement(Evenement e, int id) {

        try {
            String query = "Update evenement set nomEvenement = ?,type=?,description=?,dateDebut=?,dateFin=?,prix=?,adr=?,nbreplace=? where id = " + id;
            PreparedStatement prs = cnx.prepareStatement(query);

            prs.setString(1, e.getNom());
            prs.setDate(2, e.getDateDebut());
            prs.setInt(3, e.getNbre_participants());
            prs.setString(4, e.getLieu());
            prs.setDouble(5, e.getPrix());
            prs.setString(6, e.getType());
            prs.setDate(7, e.getDatefin());
      
            prs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    }


    

