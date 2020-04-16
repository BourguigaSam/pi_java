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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ServiceContrat {



  Connection cnx = DataSource.getInstance().getCnx();

    public void ajouterContrat(Contrat c) {
        try {
            String requete = "INSERT INTO `contract`(`location`, `owner`, `barcode`, `date_debut_location`, `date_fin_location`, `date`, `type`, `acceptcontract`, `phonenumber`)VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
              pst.setInt(1,c.getLocation());
              pst.setInt(2,c.getOwner());
              pst.setString(3,c.getBarcode());
              pst.setDate(4,c.getDate_debut_location());
              pst.setDate(5,c.getDate_fin_location());
         
              pst.setDate(6,c.getDate());
              pst.setString(7,c.getType());
              pst.setInt(8,c.getAcceptContract());
              pst.setInt(9,c.getPhoneNumber());
              
              
            pst.executeUpdate();
            System.out.println("Contrat ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void supprimerContrat(Contrat c) {
        try {
            String requete = "DELETE FROM contract WHERE id=?";
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
            String requete = "UPDATE contract SET `location`=?, `owner`=?, `barcode`=?, `date_debut_location`=?, `date_fin_location`=?, `date`=?, `type`=?, `acceptcontract`=?, `phonenumber`=?WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
             pst.setInt(1,c.getLocation());
              pst.setInt(2,c.getOwner());
              pst.setString(3,c.getBarcode());
              pst.setDate(4,c.getDate_debut_location());
              pst.setDate(5,c.getDate_fin_location());
         
              pst.setDate(6,c.getDate());
              pst.setString(7,c.getType());
              pst.setInt(8,c.getAcceptContract());
              pst.setInt(9,c.getPhoneNumber());
              pst.setInt(10,c.getId());
            pst.executeUpdate();
            System.out.println("Contrat modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    

    public List<Contrat> afficherContrat() {
        List<Contrat> contrat_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM contract";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Contrat c =new Contrat();
                c.setId(rs.getInt("id"));

               c.setLocation(rs.getInt("location"));
              c.setOwner(rs.getInt("owner"));
            c.setBarcode(rs.getString("barcode"));
             c.setDate_debut_location(rs.getDate("date_debut_location"));
             c.setDate_fin_location(rs.getDate("date_fin_location"));
         
              c.setDate(rs.getDate("date"));
            c.setType(rs.getString("type"));
            c.setAcceptContract(rs.getInt("acceptcontract"));
             c.setPhoneNumber(rs.getInt("phonenumber"));
              contrat_list.add(c);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return contrat_list;
    }
    public void ValiderContrat(Contrat c){
  
      try {
                 String requet = "UPDATE contract SET acceptcontract=? WHERE id=?";
            PreparedStatement pst=cnx.prepareStatement(requet);
               pst.setInt(1, 1);
            pst.setInt(2, c.getId());
               pst.executeUpdate();
            System.out.println("Contrat validé !");
         
      } catch (SQLException ex) {
          Logger.getLogger(ServiceContrat.class.getName()).log(Level.SEVERE, null, ex);
      }
         
        
    }







    
}
