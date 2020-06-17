/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.Core.Controller;
import com.esprit.models.Blog;
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
public class ServiceBlog {
    
    
    
     Connection cnx = DataSource.getInstance().getCnx();

    public void ajouterBlog(Blog b) {
        try {
            String requete = "INSERT INTO blog (title,content,image) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, b.getTitle());
            pst.setString(2, b.getContent());
            pst.setString(3, b.getImage());
            pst.executeUpdate();
            System.out.println("Blog ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

       public void supprimerBlog(Blog b) {
        try {
            String requete = "DELETE FROM blog WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, b.getId());
            pst.executeUpdate();
            System.out.println("Blog supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifierBlog(Blog b) {
        try {
            String requete = "UPDATE blog SET title=?,image=?,content=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1,b.getTitle());
            pst.setString(2,b.getImage());
            pst.setString(3,b.getContent());
            pst.setInt(4,b.getId());
            
       
            pst.executeUpdate();
            System.out.println("Blog modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Blog> afficherBlog() {
        List<Blog> blog_list = new ArrayList<>();
            System.out.println(Controller.getUserId());
        try {
            String requete = "SELECT * FROM blog";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                blog_list.add(new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDate(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return blog_list;
    }

    
}
