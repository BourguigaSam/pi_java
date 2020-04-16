/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Produit;
import com.esprit.models.commande;
import com.esprit.utils.DataSource;
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
 * @author LENOVO
 */
public class ServiceCommande {
  
    //User currentUser=Authentification.user;
    public void valide_btn(commande a) throws SQLException
    {
        String query="update commande set etat=? where id=? ";
        PreparedStatement ps;
            ps = DataSource.getInstance().getCnx().prepareStatement(query);
           
            ps.setInt(1,1);
            ps.setInt(2,a.getId());
           
        ps.executeUpdate();

    }
    public void AjoutCommande(Produit pr,int idp) 
    {
        String query="insert into commande (nom,prix,stock,quantite,description,idp,etat,idc,idf,nomc) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = DataSource.getInstance().getCnx().prepareStatement(query);
            ps.setString(1, pr.getNom());
            ps.setDouble(2, pr.getPrix());
          
            ps.setInt(4, pr.getQuantity());
            //ps.setString(5, pr.getImage());
            ps.setString(5, pr.getDescription());
            //ps.setInt(8, pr.getAge());
            //ps.setString(9, pr.getGenre());
            ps.setInt(6, idp);
            ps.setInt(7, 0);
           //iduser
           //id user
            ps.setInt(8,2);
           //  ps.setInt(9, pr.getIdf());
             // nom user
                   ps.setString(10,"ala");
        ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    
     public List<commande> afficheCommande(int idf)
    {   List Allcommande = new ArrayList();
        try {  
           String query="select * FROM commande where idf="+idf+" AND etat=0 order by idc ASC";
           Statement st= DataSource.getInstance().getCnx().createStatement();

           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            
            commande pr = new commande();
            pr.setId(rest.getInt("id"));
            pr.setIdf(rest.getInt("idf"));
            pr.setIdc(rest.getInt("idc"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
           // pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            Allcommande.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return Allcommande;       
    
    }
    

    
}
