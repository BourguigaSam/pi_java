/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Evenement;
import com.esprit.models.Participation;
import com.esprit.services.ServiceParticipation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class Admin_ParticipationController implements Initializable {

    @FXML
    private TextField tf_recherche1;
    @FXML
    private TableView<Participation> tableView1;
    
    @FXML
    private Button btnSupprimer1;
    @FXML
    private Label var1;
    @FXML
  
    private Button valider;
    ServiceParticipation serviceParticipation = new ServiceParticipation();
    @FXML
    private TableColumn<?, ?> user;
    @FXML
    private TableColumn<?, ?> id1;
    @FXML
    private TableColumn<?, ?> Evenement;
    @FXML
    private TableColumn<?, ?> validation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceParticipation sp = new ServiceParticipation();
        ArrayList<Participation> liste = (ArrayList<Participation>) sp.AfficherParticipation();
        ObservableList observableList = FXCollections.observableArrayList(liste);
       tableView1.setItems(observableList);     
        id1.setCellValueFactory(new PropertyValueFactory<>("id"));
        user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Evenement.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        validation.setCellValueFactory(new PropertyValueFactory<>("validite"));
        
      
        
        valider.setOnAction(e->{
            
        Participation cat= new Participation();
            cat = (Participation) tableView1.getSelectionModel().getSelectedItem();
            

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner une participation");
            alert.show();
        } else { if(cat.getValidite().equals("validé")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("cette participation est deja validé");
            alert.show();
            
        }else{

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir valider cette participation ?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                  //remove selected item from the table list
                serviceParticipation.validerParticipation(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView1.getItems().clear();
                 chargerParticipation();
                 
        
                
            
            }  
                }
        }
              
            
        });
        btnSupprimer1.setOnAction(e->{
             Participation cat= new Participation();
            cat = (Participation) tableView1.getSelectionModel().getSelectedItem();

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
                serviceParticipation.SupprimerParticipation(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView1.getItems().clear();
                 chargerParticipation();
                 
        
                
            
                
                }
        }
        });
        
        // TODO
    }
public void chargerParticipation(){
     ServiceParticipation sp = new ServiceParticipation();
        ArrayList<Participation> liste = (ArrayList<Participation>) sp.AfficherParticipation();
        ObservableList observableList = FXCollections.observableArrayList(liste);
       tableView1.setItems(observableList);     
        id1.setCellValueFactory(new PropertyValueFactory<>("id"));
        user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Evenement.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        validation.setCellValueFactory(new PropertyValueFactory<>("validite"));
    
};    
 @FXML
    private void shop(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Shop.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();     
    }

    @FXML
    private void event(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Event.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }

    @FXML
    private void blog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Blog.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    }
    @FXML
    private void users(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Personne.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    }

   @FXML
    private void location(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Location.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }

    @FXML
    private void SearchByName(ActionEvent event) {
    }
    
}
