/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Produit;
import com.esprit.services.ServiceProduit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Admin_ShopController implements Initializable {

    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<Produit> tableView;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> quantity;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private TableColumn<?, ?> category;
    @FXML
    private TableColumn<?, ?> region;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField idT;
    @FXML
    private TextField nomT;
    @FXML
    private TextField descriptionT;
    @FXML
    private TextField prixT;
    @FXML
    private TextField quantityT;
    @FXML
    private DatePicker dateT;
    @FXML
    private TextField categoryT ;
    @FXML
    private TextField regionT;
    @FXML
    private TextField imageT;
    @FXML
    private Button btn_image;
    @FXML
    private Button btnAdd;
    
     private File file;
    private FileInputStream fis;
private ServiceProduit serviceProduit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     ChargerShop();

   ServiceProduit ser = new ServiceProduit();
        ArrayList<Produit> liste = (ArrayList<Produit>) ser.afficherProduit();
        ObservableList observableList = FXCollections.observableArrayList(liste);
       tableView.setItems(observableList);     // search.setVisible(false);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
       // p.setCellValueFactory(new PropertyValueFactory<>("p"));
      // category.setCellValueFactory(new PropertyValueFactory<>("category"));
     // region.setCellValueFactory(new PropertyValueFactory<>("region"));
   //  image.setCellValueFactory(new PropertyValueFactory<>("image"));
     

      btnSupprimer .setOnMouseClicked(x -> {
 Produit cat = new Produit();
cat = (Produit) tableView.getSelectionModel().getSelectedItem();

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un produit");
            alert.show();
        } else {

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir supprimer ce produit?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //remove selected item from the table list
                serviceProduit.supprimerProduit(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
        
            tableView.getItems().addAll(serviceProduit.afficherProduit());
            ChargerShop();
            }
        }
        });

      //  -_-  woooh
    
      
      
      
      Stage stage = new Stage();
        btn_image.setOnAction(e -> {
            stage.setTitle("File Chooser ");
            
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open image File");
            
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                imageT.setText(file.getAbsolutePath());
                System.out.println(file.getAbsolutePath());
                imageT.setText("");
                
                try {
                     
                
                    
                    fis = new FileInputStream(file);// file is selected using filechooser which is in last tutorial
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Admin_LocationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    //     Image image=  new Image(file.toURI().toString());
                    URL url1 = file.toURI().toURL();
                    System.out.println(new Image(url1.toExternalForm()));
                    //image_post.setImage(new Image(url1.toExternalForm()));
                } catch (MalformedURLException ex) {
                    
                    Logger.getLogger(Admin_LocationController.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            };
            
        });
        
    
 
 




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
    
          ServiceProduit bs = new ServiceProduit();
        ArrayList AL = (ArrayList) bs.afficherProduit();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Produit> filtred_c = new FilteredList<>(OReservation, e -> true);
        tf_recherche.setOnKeyReleased(e -> {
            tf_recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filtred_c.setPredicate((Predicate<? super Produit>) p -> {
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
    private void UpdateProduit(ActionEvent event) {
    }

    @FXML
    private void AddProduit(ActionEvent event) {
    
      if (idT.getText().isEmpty() || nomT.getText().isEmpty() 
                ||  descriptionT.getText().isEmpty()||  prixT.getText().isEmpty()
              ||  quantityT.getText().isEmpty()||  imageT.getText().isEmpty()
                ) {          
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Il faut remplir les champs obligatoires ");
            alert.showAndWait();
        }
        else
        {
     
         LocalDate localDateDebut = dateT.getValue();
           Instant instant = Instant.from(localDateDebut.atStartOfDay(ZoneId.systemDefault()));
           java.util.Date date = Date.from(instant);
            java.sql.Date dte = new java.sql.Date(date.getTime());
        int s = Integer.parseInt(idT.getText());
              int v = Integer.parseInt(quantityT.getText());

        ServiceProduit serviceProduit2 =new ServiceProduit();

      Produit p = new Produit(s,nomT.getText()
                    , descriptionT.getText(),Double.valueOf(prixT.getText()),v,imageT.getText(),dte);
            serviceProduit2.ajouterProduit(p);
          
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nouveau Produit");
            alert.setHeaderText(null);
            alert.setContentText("produit ajouté !! ");
            alert.showAndWait();
        ChargerShop();
       }
     
    }

    private void ChargerShop() {
 ServiceProduit serviceBlog = new ServiceProduit();
        ArrayList<Produit> listeProduit = (ArrayList<Produit>) serviceBlog.afficherProduit();
        ObservableList observableList = FXCollections.observableArrayList(listeProduit);
        tableView.setItems(observableList);

    }
    private void setdate(ActionEvent event) {
        DatePicker maxDate = new DatePicker();
    
LocalDate localDate = dateT.getValue();

   maxDate.setValue(localDate);

final Callback<DatePicker, DateCell> dayCellFactoryfin;
dayCellFactoryfin = (final DatePicker datePicker) -> new DateCell() {
    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (item.isBefore(maxDate.getValue())) { //Disable all dates after required date
            setDisable(true);
            setStyle("-fx-background-color: #7f7a7a;"); //To set background on different color
        }
    }
};

dateT.setDayCellFactory(dayCellFactoryfin);
        
    }
    
}
