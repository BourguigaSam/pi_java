/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Orders;
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
public class ServiceOrders {
    
        Connection cnx = DataSource.getInstance().getCnx();

    
    public void ajouterOrdre(Orders o) {
        try {
            String requete = "INSERT INTO orders (id,personne,state,country,zipcode,etat,phone,price,produit) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, o.getId());
            pst.setObject(2, o.getPersonne());
            pst.setString(3, o.getState());
            pst.setString(4,o.getCountry());
            pst.setString(5, o.getZipcode());
            pst.setString(6,o.getEtat());
            pst.setInt(7,o.getPhone());
            pst.setFloat(8,o.getPrice());
            pst.setObject(9,o.getProduit());
            pst.executeUpdate();
            System.out.println("Ordre ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerOrdre(Orders o) {
        try {
            String requete = "DELETE FROM orders WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, o.getId());
            pst.executeUpdate();
            System.out.println("Ordre supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
   public void modifierOrdre(Orders o) {
        try {
            String requete = "UPDATE orders SET personne=?,state=?,country=?,zipcode=?,etat=?,phone=?,price=?,produit=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, o.getId());
            pst.setObject(2, o.getPersonne());
            pst.setString(3, o.getState());
            pst.setString(4, o.getCountry());
            pst.setString(5, o.getZipcode());
            pst.setString(6, o.getEtat());
            pst.setInt(7, o.getPhone());
            pst.setFloat(8, o.getPrice());
            pst.setObject(9, o.getProduit());
            pst.executeUpdate();
            System.out.println("Ordere modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public List<Orders> afficherOrdre() {
        List<Orders> orders_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM orders";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                orders_list.add(new Orders(rs.getInt(1),(Personne) rs.getObject(2), rs.getString(3), rs.getString(4), rs.getString(5) , rs.getString(6), rs.getInt(7),rs.getFloat(8),(Produit) rs.getObject(9)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return orders_list;
    }

    
    
    
}
