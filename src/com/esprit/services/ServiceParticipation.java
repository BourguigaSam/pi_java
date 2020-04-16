/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.Core.Controller;
import com.esprit.models.Evenement;
import com.esprit.models.Panier;
import com.esprit.models.Participation;
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
 * @author Ahmed
 */
public class ServiceParticipation {

    public ServiceParticipation() {
    }
    ;
    Connection c = DataSource.getInstance().getCnx();

    public void ajouterParticipation(Participation p) {
        String requete = "INSERT INTO `participation`(`id_user`, `id_evenement`, `validation`) VALUES (?,?,?)";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ps.setInt(1,Controller.getUserId());
            ps.setInt(2, p.getId_event());
            ps.setString(3,"en cours");
           

            ps.executeUpdate();
             System.out.println("Participation ajoutée !");
             participer(p);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void validerParticipation(Participation p) {
        String requete = "UPDATE `participation` SET `validation`=? WHERE `id`=?";
        try {
            PreparedStatement pt = c.prepareStatement(requete);
            pt.setString(1, "validé");
            pt.setInt(2, p.getId());
            pt.executeUpdate();
             System.out.println("Participation validée !");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void SupprimerParticipation(Participation p) {
        String requete = "DELETE FROM `participation` WHERE `id`=?";
        try {
            PreparedStatement pt = c.prepareStatement(requete);
            pt.setInt(1, p.getId());
            pt.executeUpdate();
             System.out.println("participation supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Participation> AfficherParticipation() {
        List AllParticipation = new ArrayList();
        try {
            String query = "select * from participation";
            Statement st = DataSource.getInstance().getCnx().createStatement();
            ResultSet rest = st.executeQuery(query);
            while (rest.next()) {
                Participation pr = new Participation();

                pr.setId(rest.getInt("id"));
                pr.setId_user(rest.getInt("id_user"));
                pr.setId_event(rest.getInt("id_evenement"));
                pr.setValidite(rest.getString("validation"));

                AllParticipation.add(pr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

        return AllParticipation;

    }

    public List<Participation> AfficherParticipationByUser(int idUser) {
        List AllParticipation = new ArrayList();
        try {
            String query = "select * from participation where id_user=?";
            PreparedStatement ste = c.prepareStatement(query);
            ste.setInt(1, idUser);
            ResultSet rest = ste.executeQuery();
            while (rest.next()) {
                Participation pr = new Participation();

                pr.setId(rest.getInt("id"));
                pr.setId_user(rest.getInt("id_user"));
                pr.setId_event(rest.getInt("id_evenement"));
                pr.setValidite(rest.getString("validation"));

                AllParticipation.add(pr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

        return AllParticipation;

    }
    public Participation AfficherParticipationById(int id) {
        Participation pr = new Participation();
        try {
            String query = "select * from participation where id=?";
            PreparedStatement ste = c.prepareStatement(query);
            ste.setInt(1, id);
            ResultSet rest = ste.executeQuery();
            while (rest.next()) {
             

                pr.setId(rest.getInt("id"));
                pr.setId_user(rest.getInt("id_user"));
                pr.setId_event(rest.getInt("id_evenement"));
                pr.setValidite(rest.getString("validation"));

                
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pr;

    }
   public void participer(Participation p) throws SQLException{
       
        ServiceEvenement es = new ServiceEvenement();
        Evenement ev = es.AfficherEventById(p.getId_event());
        es.Participer(ev);
    }
}
