/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Location;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UI_LocationController implements Initializable {

    @FXML
    private Circle btnClose;
    @FXML
    private Button next;
    @FXML
    private Label matricule;
    @FXML
    private Label marque;
    @FXML
    private Label dailyPrice;
    @FXML
    private Label matricule1;
    @FXML
    private Label marque1;
    @FXML
    private Label dailyPrice1;
    @FXML
    private Label matricule2;
    @FXML
    private Label marque2;
    @FXML
    private Label dailyPrice2;
    @FXML
    private Label matricule3;
    @FXML
    private Label marque3;
    @FXML
    private Label dailyPrice3;
    @FXML
    private Label matricule4;
    @FXML
    private Label marque4;
    @FXML
    private Label dailyPrice4;
    @FXML
    private Label matricule5;
    @FXML
    private Label marque5;
    @FXML
    private Label dailyPrice5;
    @FXML 
    private Button see;
      @FXML 
    private Button see1;
      @FXML 
    private Button see2;
      @FXML 
    private Button see3;
      @FXML 
    private Button see4;
      @FXML 
    private Button see5;
    
  private Connection con = DataSource.getInstance().getCnx();
 ResultSet rs;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
         rs = con.createStatement().executeQuery("select * from location ");
            afficherListe();
        } catch (SQLException ex) {
            Logger.getLogger(UI_LocationController.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        
        
    }    
    
     public void afficherListe() throws SQLException{
        rs.first();
        matricule.setText(rs.getString("matricule"));
         marque.setText(rs.getString("marque"));
                  dailyPrice.setText(rs.getString("daily_price"));
//System.out.println(rs);
                  see.setOnMouseClicked(x->{
            try {
                rs.first();
            } catch (SQLException ex) {
                Logger.getLogger(UI_LocationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Location_ReadMore.fxml"));
                 Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) x.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
   });
                  
         rs.next();
 matricule1.setText(rs.getString("matricule"));
         marque1.setText(rs.getString("marque"));
                  dailyPrice1.setText(rs.getString("daily_price"));
        
       rs.next();
 matricule2.setText(rs.getString("matricule"));
         marque2.setText(rs.getString("marque"));
                  dailyPrice3.setText(rs.getString("daily_price"));
        
      rs.next();
 matricule3.setText(rs.getString("matricule"));
         marque3.setText(rs.getString("marque"));
                  dailyPrice3.setText(rs.getString("daily_price"));
        
                   rs.next();
 matricule4.setText(rs.getString("matricule"));
         marque4.setText(rs.getString("marque"));
                  dailyPrice4.setText(rs.getString("daily_price"));
        
      rs.next();
 matricule5.setText(rs.getString("matricule"));
         marque5.setText(rs.getString("marque"));
                  dailyPrice5.setText(rs.getString("daily_price"));
        
                  
       
     }
    
  @FXML  
 public void afficherListe1() throws SQLException{
        rs.next();
        matricule.setText(rs.getString("matricule"));
         marque.setText(rs.getString("marque"));
                  dailyPrice.setText(rs.getString("daily_price"));

         rs.next();
 matricule1.setText(rs.getString("matricule"));
         marque1.setText(rs.getString("marque"));
                  dailyPrice1.setText(rs.getString("daily_price"));
        
       rs.next();
 matricule2.setText(rs.getString("matricule"));
         marque2.setText(rs.getString("marque"));
                  dailyPrice3.setText(rs.getString("daily_price"));
        
      rs.next();
 matricule3.setText(rs.getString("matricule"));
         marque3.setText(rs.getString("marque"));
                  dailyPrice3.setText(rs.getString("daily_price"));
        
                   rs.next();
 matricule4.setText(rs.getString("matricule"));
         marque4.setText(rs.getString("marque"));
                  dailyPrice4.setText(rs.getString("daily_price"));
        
      rs.next();
 matricule5.setText(rs.getString("matricule"));
         marque5.setText(rs.getString("marque"));
                  dailyPrice5.setText(rs.getString("daily_price"));
        
                  
       
     }
    
    
     
     @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }
    @FXML
    private void backhome(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();     
    }
     @FXML
    private void mousepressedhome(MouseEvent event) throws IOException{
        
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
    @FXML
    private void mousepressedinbox(MouseEvent event) throws IOException{
        
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Chat.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
    @FXML
     private void mousepressedstore(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Shop.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
 
     @FXML
     private void mousepressedsevent(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_event.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
     @FXML
     private void mousepressedrent(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Location.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
     @FXML
     private void mousepressedblog(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Blog.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
}
