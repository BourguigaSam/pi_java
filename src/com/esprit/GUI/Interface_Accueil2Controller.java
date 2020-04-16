/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Interface_Accueil2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Circle btnClose;
    @FXML
    private Button chat;
    @FXML
    private ImageView iView;
    @FXML
    private Label variable;
    @FXML
    private Button blog;
   
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
       
    @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }
    // Redirect buttons
    
 
    @FXML
    private void shop(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Shop.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();     
    }

    @FXML
    private void event(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_event.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }

    @FXML
    private void blog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Blog.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    private void location(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Location.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }
    @FXML
    private void chat(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Chat.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }

@FXML
     private void mousepressedslogout(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_connexion1.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
    


   
    
}
