/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.services.ServiceEvenement;
import com.esprit.utils.DataSource;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UI_eventController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
   @FXML
    private AnchorPane anch;
    @FXML
    private Label nom;
    @FXML
    private ImageView image;
    @FXML
    private Label date;
    @FXML
    private Label lieu;
    @FXML
    private Label prix;
    private final ServiceEvenement es = new ServiceEvenement();
    private Connection con = DataSource.getInstance().getCnx();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 try {
            afficherliste();
        } catch (SQLException ex) {
            Logger.getLogger(UI_eventController.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
         public void afficherliste() throws SQLException {
                 ScrollPane sp = new ScrollPane();

        ResultSet rs = con.createStatement().executeQuery("select * from evenement ");
    rs.last();
        int x = rs.getRow();
        rs.first();

      for (int i = 0; i < x; i++) {

                AnchorPane anchor = new AnchorPane();
        Label nom =new Label();
                nom.setText(rs.getString("nom"));  
                        Label date =new Label();

          date.setText(rs.getString("dateDebut"));
                  Label lieu =new Label();

         lieu.setText(rs.getString("lieu"));
                 Label prix =new Label();

          prix.setText(rs.getString("prix"));
  anchor.getChildren().addAll(nom,date,lieu,prix);

        sp.setContent(anchor);

//anchorpane.getChildren().add(anch);

   rs.next();
                     }

    nom.setText(rs.getString("nom"));  
          date.setText(rs.getString("dateDebut"));
         lieu.setText(rs.getString("lieu"));
          prix.setText(rs.getString("prix"));
            
            
        }    
}
        
   
    
    
        

    
    

