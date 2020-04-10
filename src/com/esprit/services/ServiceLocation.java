/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

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
public class ServiceLocation {
    
        Connection cnx = DataSource.getInstance().getCnx();

        public void ajouterLocation(Location location){
              try {
            String requete = "INSERT INTO location (matricule,marque,model,category,puissance,daily_price,type,image_id) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, location.getMatricule());
            pst.setString(2, location.getMarque());
            pst.setString(3, location.getModel());
            pst.setString(4, location.getCategory());
            pst.setString(5, location.getPuissance());
            pst.setDouble(6, location.getDailyPrice());
          pst.setString(7, location.getType());
              pst.setString(8, location.getImage_id());
            pst.executeUpdate();
            
            System.out.println("Location ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
            
        public void supprimerLocation(Location location) {
        try {
            String requete = "DELETE FROM Location WHERE matricule=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, location.getMatricule());
            pst.executeUpdate();
            System.out.println("Location supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

        public void modifier(Location loc) {
        try {
            String requete = "UPDATE `location` SET `matricule`=?,`marque`=?,`model`=?,`category`=?,`puissance`=?,`daily_price`=?,`type`=?,`image_id`=? WHERE `id`=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
              pst.setString(1,loc.getMatricule());
            pst.setString(2, loc.getMarque());
            pst.setString(3, loc.getModel());
            pst.setString(4, loc.getCategory());
            pst.setString(5, loc.getPuissance());
            pst.setDouble(6, loc.getDailyPrice());
             pst.setString(7, loc.getType());
              pst.setString(8, loc.getImage_id());
              pst.setInt(9,loc.getId());
            pst.executeUpdate();
            System.out.println("Location modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

     
        
        public List<Location> afficherLocation() {
        List<Location> location_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM location";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                location_list.add(new Location(rs.getInt("id"),rs.getString("matricule"),rs.getString("marque"),rs.getString("model"),rs.getString("category"),rs.getString("puissance"),rs.getDouble("daily_price"),rs.getString("type"),rs.getString("image_id")));
                
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return location_list;
    }    
        
           
        
        }
    

