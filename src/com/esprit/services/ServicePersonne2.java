/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Personne;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aissa
 */
public class ServicePersonne2 implements IService<Personne> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouterPersonne(Personne t) {
        try {
            String requete = "INSERT INTO fos_user (username,email,password) VALUES ('" + t.getUsername() + "','" + t.getEmail() + "','" + t.getPassword() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerPersonne(Personne t) {
        try {
            String requete = "DELETE FROM personne WHERE id=" + t.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierPersonne(Personne t) {
        try {
            String requete = "UPDATE fos_user SET username='" + t.getUsername() + "',email='" + t.getEmail() + "'  ,password='" + t.getPassword() + "'  WHERE id=" + t.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Personne> afficherPersonne() {
        List<Personne> person_list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM fos_user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                person_list.add(new Personne(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return person_list;
    }
}
