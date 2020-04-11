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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
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
     @FXML
    private Circle btnClose;


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

/* btnUpdate .setOnMouseClicked(x -> {
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

            if (alert.getResult() == ButtonType.YES) {
                //remove selected item from the table list
                serviceEvenement.modifier(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
        
            tableView.getItems().addAll(serviceEvenement.afficherEvenement());
            ChargerEvenement();
            }
        }
        });*/

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
                 ca.setPrix(Integer.parseInt(prixT.getText()));
                     ca.setDateDebut(java.sql.Date.valueOf(dateT.getValue()));
             ca.setDatefin(java.sql.Date.valueOf(dateFT.getValue()));
             serviceEvenement.modifier(ca);
             ChargerEvenement();
            
                 
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

    }
     @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
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
    





   
    
    @FXML
    private void AddEvent(ActionEvent event) throws IOException  {
           if (idT.getText().isEmpty() /*|| nomT.getText().isEmpty() 
                ||  nbreT.getText().isEmpty()
                || lieuxT.getText().isEmpty() ||  prixT.getText().isEmpty()
                 || typeT.getText().isEmpty()  */ ) {          
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
             int s = Integer.parseInt(idT.getText());
              int v = Integer.parseInt(idT.getText());
              double m = Double.parseDouble(prixT.getText());
            Evenement e = new Evenement( s,nomT.getText(),dtdebut,v
                    , lieuxT.getText(), m, typeT.getText(), dtfin);
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