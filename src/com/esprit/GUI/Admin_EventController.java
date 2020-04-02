/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Evenement;
import com.esprit.services.ServiceEvenement;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Admin_EventController implements Initializable {

    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<Evenement> tableView;
    @FXML
    private TableColumn<?, ?> id;
        @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> debut;
    @FXML
    private TableColumn<?, ?> nbre;
        @FXML
    private TableColumn<?, ?> lieux;
       @FXML
        private TableColumn<?, ?> prix;
       @FXML
      private TableColumn<?, ?> type;
       @FXML
       private TableColumn<?, ?> fin;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSupprimer;
    private TextField idT;
    private TextField nomT;
    private DatePicker dateT;
    private TextField nbreT;
    private TextField lieuxT;
    private TextField prixT;
    private TextField typeT;
    private DatePicker dateFT;
ServiceEvenement serviceEvenement = new ServiceEvenement();
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> likes;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> categoory;
    @FXML
    private TableColumn<?, ?> accept;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private Button btnSupprimer1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   ChargerEvenement();

        ServiceEvenement ser = new ServiceEvenement();
        ArrayList<Evenement> liste = (ArrayList<Evenement>) ser.afficherEvenement();
        ObservableList observableList = FXCollections.observableArrayList(liste);
       tableView.setItems(observableList);     // search.setVisible(false);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
       nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        debut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        nbre.setCellValueFactory(new PropertyValueFactory<>("nbre_participants"));
        lieux.setCellValueFactory(new PropertyValueFactory<>("lieu"));
       prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
      fin.setCellValueFactory(new PropertyValueFactory<>("datefin"));

 btnSupprimer .setOnMouseClicked(x -> {
 Evenement cat = new Evenement();
cat = (Evenement) tableView.getSelectionModel().getSelectedItem();

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un evenement");
            alert.show();
        } else {

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir supprimer cet evenement?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //remove selected item from the table list
                serviceEvenement.supprimer(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
        
            tableView.getItems().addAll(serviceEvenement.afficherEvenement());
            ChargerEvenement();
            }
        }
        });

 btnUpdate .setOnMouseClicked(x -> {
 Evenement cat = new Evenement();
cat = (Evenement) tableView.getSelectionModel().getSelectedItem();

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un evenement");
            alert.show();
        } else {

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir modifier cet evenement", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();
     try {
         Statement statement = null;
        ResultSet resultSet = null;
   
         idT.setText(resultSet.getString("id"));
           nomT.setText(resultSet.getString("nom"));

                nbreT.setText(resultSet.getString("nbre_participants"));
                lieuxT.setText(resultSet.getString("lieu"));
                prixT.setText(resultSet.getString("prix"));
                nbreT.setText(resultSet.getString("type"));
            
     } catch (SQLException ex) {
         Logger.getLogger(Admin_EventController.class.getName()).log(Level.SEVERE, null, ex);
     }
              
            
            if (alert.getResult() == ButtonType.YES) {
                
                

                //remove selected item from the table list
                serviceEvenement.modifier(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
        
            tableView.getItems().addAll(serviceEvenement.afficherEvenement());
            ChargerEvenement();
            }
        }
        });

     }    

    
     public void ChargerEvenement() {
        
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ArrayList<Evenement> listeEvenement = (ArrayList<Evenement>) serviceEvenement.afficherEvenement();

        ObservableList observableList = FXCollections.observableArrayList(listeEvenement);
        tableView.setItems(observableList);

    }
    
    @FXML
    private void shop(ActionEvent event) {
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
    private void SearchByName(ActionEvent event) {
          ServiceEvenement bs = new ServiceEvenement();
        ArrayList AL = (ArrayList) bs.afficherEvenement();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Evenement> filtred_c = new FilteredList<>(OReservation, e -> true);
        tf_recherche.setOnKeyReleased(e -> {
            tf_recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filtred_c.setPredicate((Predicate<? super Evenement>) p -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                  //  String toLowerCaseNewValue = newValue.toLowerCase();
                    if ((p.getNom().contains(newValue)) ) {
                        return true;

                    }

                    return false;
                });
            });
        });
        tableView.setItems(filtred_c);
    }
    

 @FXML
    private void modifier(ActionEvent event) {

        Evenement maisons_hotes = new Evenement();

        maisons_hotes = tableView.getSelectionModel().getSelectedItem();

        if (maisons_hotes == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Veillez Choisir une maison d'hôte");
            alert.show();
        } else {

            System.out.println(maisons_hotes);
            /**
             * ********************
             */
            id.setVisible(true);
            nom.setVisible(true);
            debut.setVisible(true);
            nbre.setVisible(true);
            lieux.setVisible(true);
            prix.setVisible(true);
            type.setVisible(true);
            fin.setVisible(true);
          
            /**
             * ******************
             */
            
       idT.setText(Integer.toString(maisons_hotes.getId()));
            nomT.setText(maisons_hotes.getNom());
           // dateT.setDate(maisons_hotes.getDateDebut());
            nbreT.setText(Integer.toString(maisons_hotes.getNbre_participants()));
            lieuxT.setText(maisons_hotes.getLieu());
            prixT.setText(Double.toString(maisons_hotes.getPrix()));
            typeT.setText(maisons_hotes.getType());
        //    dateFT.setText(maisons_hotes.getAdresse());

        }

    }




   
    
    @FXML
    private void AddEvent(ActionEvent event) throws IOException  {
           if (idT.getText().isEmpty() || nomT.getText().isEmpty() 
                ||  nbreT.getText().isEmpty()
                || lieuxT.getText().isEmpty() ||  prixT.getText().isEmpty()
                 || typeT.getText().isEmpty()   ) {          
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Il faut remplir les champs obligatoires ");
            alert.showAndWait();
        }
        else
        {
                   //datedebut
        LocalDate localDateDebut = dateT.getValue();
            Instant instant = Instant.from(localDateDebut.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date date = Date.from(instant);
            java.sql.Date dtdebut = new java.sql.Date(date.getTime());
             //datefin
             LocalDate localDateFin = dateFT.getValue();
            Instant instant1 = Instant.from(localDateFin.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date datefin = Date.from(instant1);
            java.sql.Date dtfin = new java.sql.Date(datefin.getTime());
            Evenement e = new Evenement( Integer.valueOf(idT.getText()),nomT.getText(),dtdebut,Integer.valueOf(nbreT.getText())
                    , lieuxT.getText(), Double.valueOf(prixT.getText()), typeT.getText(), dtfin);
            serviceEvenement.ajouterEvenement(e);
            
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nouveau Evenement");
            alert.setHeaderText(null);
            alert.setContentText("Evenement  ajouté !!  ");
            alert.showAndWait();
        ChargerEvenement();
    }
    }
    
    
    
    private void setdatedebut(ActionEvent event) {
        DatePicker maxDatefin = new DatePicker();
    
LocalDate localDatedebut = dateT.getValue();

   maxDatefin.setValue(localDatedebut);

final Callback<DatePicker, DateCell> dayCellFactoryfin;
dayCellFactoryfin = (final DatePicker datePicker) -> new DateCell() {
    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (item.isBefore(maxDatefin.getValue())) { //Disable all dates after required date
            setDisable(true);
            setStyle("-fx-background-color: #7f7a7a;"); //To set background on different color
        }
    }
};

dateFT.setDayCellFactory(dayCellFactoryfin);
        
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