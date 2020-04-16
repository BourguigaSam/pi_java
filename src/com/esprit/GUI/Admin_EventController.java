/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.models.Evenement;
import com.esprit.services.ServiceEvenement;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Predicate;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    @FXML
    private TextField idT;
    @FXML
    private TextField nomT;
    @FXML
    private DatePicker dateT;
    @FXML
    private TextField nbreT;
    @FXML
    private TextField lieuxT;
    @FXML
    private TextField prixT;
    @FXML
    private TextField typeT;
    @FXML
    private DatePicker dateFT;
    ServiceEvenement serviceEvenement = new ServiceEvenement();
    @FXML
    private Label var;
    @FXML
    private Button btnAdd1;

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
 tableView.setOnMouseClicked(e->{
      Evenement cat = new Evenement();
cat = (Evenement) tableView.getSelectionModel().getSelectedItem();
idT.setText(String.valueOf(cat.getId()));
                 nomT.setText(cat.getNom());
                 nbreT.setText(String.valueOf(cat.getNbre_participants()));
                 lieuxT.setText(cat.getLieu());
                 prixT.setText(String.valueOf(cat.getPrix()));
                 typeT.setText(cat.getType());
                 
     
 });


     tableView.setOnMouseClicked(e->{
      Evenement cat = new Evenement();
cat = (Evenement) tableView.getSelectionModel().getSelectedItem();
idT.setText(String.valueOf(cat.getId()));
                 nomT.setText(cat.getNom());
                 nbreT.setText(String.valueOf(cat.getNbre_participants()));
                 lieuxT.setText(cat.getLieu());
                 prixT.setText(String.valueOf(cat.getPrix()));
                 typeT.setText(cat.getType());
                 
     
 });

 btnUpdate .setOnAction(e-> {
 Evenement cat = new Evenement();
cat = (Evenement) tableView.getSelectionModel().getSelectedItem();

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un evenement");
            alert.show();
        } else { 
            

                 
                 
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir modifier cet evenement", ButtonType.YES, ButtonType.NO, null);
                 alert.showAndWait();
                 Statement statement = null;
                 ResultSet resultSet = null;
                
               Evenement ca= new Evenement();
     ca.setId(Integer.parseInt(idT.getText()));
                 ca.setNom(nomT.getText());
                 ca.setLieu(lieuxT.getText());
                 ca.setType(typeT.getText());
                 ca.setNbre_participants(Integer.parseInt(nbreT.getText()));
                 ca.setPrix(Double.parseDouble(prixT.getText()));
                     ca.setDateDebut(java.sql.Date.valueOf(dateT.getValue()));
             ca.setDatefin(java.sql.Date.valueOf(dateFT.getValue()));
           
            
                 
                 if (alert.getResult() == ButtonType.YES) {
                     
                     
                     
                     //remove selected item from the table list
                     serviceEvenement.modifier(ca);
                     //bonplanService.SupprimerCategorie(cat);
                    
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
       idT.setText("");
            nomT.setText("");
            nbreT.setText("");
            lieuxT.setText("");
            prixT.setText("");
            typeT.setText("");
            dateFT.setValue(null);
            dateT.setValue(null);
           
            
        

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
    private void AddEvent(ActionEvent event) {
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
            e.setId_user(Controller.getUserId());
            serviceEvenement.ajouterEvenement(e);
            
            ChargerEvenement();
            
            
            
           
  
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

    @FXML
    private void Participation(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Participation.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
    }


    
}