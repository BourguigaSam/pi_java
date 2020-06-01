/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Contrat;
import com.esprit.models.Participation;
import com.esprit.services.ServiceContrat;
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
public class Admin_ContratsController implements Initializable {

    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> location;
    @FXML
    private TableColumn<?, ?> owner;
    @FXML
    private TableColumn<?, ?> Barcode;
    @FXML
    private TableColumn<?, ?> dateDebut;
    @FXML
    private TableColumn<?, ?> dateF;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> validité;
    @FXML
    private TableColumn<?, ?> num;
    @FXML
    private Button valider;
    @FXML
    private Button btnSupprimer;
    ServiceContrat sc = new ServiceContrat();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ArrayList<Contrat> liste = (ArrayList<Contrat>) sc.afficherContrat();
        ObservableList observableList = FXCollections.observableArrayList(liste);
        tableView.setItems(observableList);
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        Barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dateDebut.setCellValueFactory(new PropertyValueFactory<>("date_debut_location"));
        dateF.setCellValueFactory(new PropertyValueFactory<>("date_fin_location"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        validité.setCellValueFactory(new PropertyValueFactory<>("AcceptContract"));
       num.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
       valider.setOnAction(e->{
           Contrat cat= new Contrat();
            cat = (Contrat) tableView.getSelectionModel().getSelectedItem();
            

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un contrat");
            alert.show();
        } else { if(cat.getAcceptContract()==1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("ce contrat est deja validé");
            alert.show();
            
        }else{

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir valider ce contrat ?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                  //remove selected item from the table list
                sc.ValiderContrat(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
                 
                 ChargerContracts();
        
                
            
            }  
                }
        }
          
       });
        btnSupprimer.setOnAction(e->{
             Contrat cat= new Contrat();
            cat = (Contrat) tableView.getSelectionModel().getSelectedItem();
            

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un contrat");
            alert.show();
        } else {

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir supprimer ce contrat ?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                  //remove selected item from the table list
                sc.supprimerContrat(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
                 
                 ChargerContracts();
                 
        
                
            
            }  
             }
          
        });
    }
public void ChargerContracts(){
     ArrayList<Contrat> liste = (ArrayList<Contrat>) sc.afficherContrat();
        ObservableList observableList = FXCollections.observableArrayList(liste);
        tableView.setItems(observableList);
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        Barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dateDebut.setCellValueFactory(new PropertyValueFactory<>("date_debut_location"));
        dateF.setCellValueFactory(new PropertyValueFactory<>("date_fin_location"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        validité.setCellValueFactory(new PropertyValueFactory<>("AcceptContract"));
       num.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
}    
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
