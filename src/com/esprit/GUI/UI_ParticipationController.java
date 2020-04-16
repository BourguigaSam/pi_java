/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.models.Evenement;
import com.esprit.models.Participation;
import com.esprit.services.ServiceEvenement;
import com.esprit.services.ServiceParticipation;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class UI_ParticipationController implements Initializable {

    @FXML
    private ImageView home;
    @FXML
    private ListView<Participation> ListP;
    @FXML
    private Label Event;
    @FXML
    private Label Validation;
    @FXML
    private Button btnDelete;
    ServiceParticipation sp= new ServiceParticipation();
    ServiceEvenement se= new ServiceEvenement();
    @FXML
    private ImageView MyParticipation;
    @FXML
    private Circle btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Participation> liste = (ArrayList<Participation>) sp.AfficherParticipationByUser(Controller.getUserId());
        ObservableList observableList = FXCollections.observableArrayList(liste);
       ListP.setItems(observableList); 
       home.setOnMouseClicked(e->{
           Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));
                 Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       });
        
           ListP.setOnMouseClicked(e->{
      Participation cat = new Participation();
cat = (Participation) ListP.getSelectionModel().getSelectedItem();
        int ide = cat.getId_event();
       ObservableList<Evenement>  data = FXCollections.observableArrayList(se.afficherEvenement());
String Evenement ="";
        for (Evenement d : data) {
            if(d.getId()==cat.getId_event()){
                Evenement=String.valueOf(d.getId()+"   " +d.getNom());
        
            }
            
        }
                
       Event.setText(Evenement);
       Validation.setText(cat.getValidite());
                 
     
 });
         btnDelete.setOnAction(e->{
               
          
           Participation cat= new Participation();
            cat = (Participation) ListP.getSelectionModel().getSelectedItem();

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner une participation");
            alert.show();
        } else {

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir supprimer cette participation ?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                  //remove selected item from the table list
                sp.SupprimerParticipation(cat);
                //bonplanService.SupprimerCategorie(cat);
                 ListP.getItems().clear();
                 
                 
        
                
            
                
                }
        }
            }); 
    }    
  
    @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
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
