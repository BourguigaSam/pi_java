/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Personne;
import com.esprit.services.ServicePersonne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Admin_PersonneController implements Initializable {

    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<Personne> userTable;
    @FXML
 
    private TableColumn<?, ?> username;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> enabled;

    @FXML
    private TableColumn<?, ?> last;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private Button btnSupprimer;
     @FXML
    private Circle btnClose;

   private ObservableList<Personne> masterData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicePersonne ser = new ServicePersonne();
        ArrayList<Personne> liste = (ArrayList<Personne>) ser.getAllUsers();
        ObservableList observableList = FXCollections.observableArrayList(liste);
        userTable.setItems(observableList);
      //  masterData.addAll(users);
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        enabled.setCellValueFactory(new PropertyValueFactory<>("enabled"));
       last.setCellValueFactory(new PropertyValueFactory<>("last_login"));
       image.setCellValueFactory(new PropertyValueFactory<>("image_id"));
      //  userTable.getItems().setAll(masterData);

         btnSupprimer .setOnMouseClicked(x -> {
 Personne p = new Personne();
p = userTable.getSelectionModel().getSelectedItem();

        if (p== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un utilisateur");
            alert.show();
        } else {

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir supprimer cet utilisateur?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //remove selected item from the table list
                ser.supprimerPersonne(p);
                //bonplanService.SupprimerCategorie(p);
                 userTable.getItems().clear();
        
            userTable.getItems().addAll(ser.afficherPersonne());
            ChargerPersonne();
            
            
            
            }
        }
        });
 
        
        // TODO
    }    
       public void ChargerPersonne() {
            ServicePersonne ser = new ServicePersonne();
        ArrayList<Personne> liste = (ArrayList<Personne>) ser.afficherPersonne();
        ObservableList observableList = FXCollections.observableArrayList(liste);
        userTable.setItems(observableList);
            
        }

 @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }
    @FXML
    private void SearchByName(ActionEvent event) {
          ServicePersonne bs = new ServicePersonne();
        ArrayList AL = (ArrayList) bs.afficherPersonne();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Personne> filtred_c = new FilteredList<>(OReservation, e -> true);
        tf_recherche.setOnKeyReleased(e -> {
            tf_recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filtred_c.setPredicate((Predicate<? super Personne>) p -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                  //  String toLowerCaseNewValue = newValue.toLowerCase();
                    if ((p.getUsername().contains(newValue)) ) {
                        return true;

                    }

                    return false;
                });
            });
        });
        userTable.setItems(filtred_c);
    }
        
    @FXML
    private void shop(ActionEvent event) throws IOException {
 /*   Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Shop.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); */
    
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
    private void dashboard(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Dashboard.fxml"));

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
   
       
    }