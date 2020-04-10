/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Location;
import com.esprit.services.ServiceLocation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Admin_LocationController implements Initializable {

    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<Location> tableView;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> matricule;
    @FXML
    private TableColumn<?, ?> marque;
    @FXML
    private TableColumn<?, ?> model;
    @FXML
    private TableColumn<?, ?> category;
    @FXML
    private TableColumn<?, ?> puissance;
    @FXML
    private TableColumn<?, ?> dailyPrice;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField idT;
    @FXML
    private TextField matriculeT;
    @FXML
    private TextField marqueT;
    @FXML
    private TextField modelT;
    @FXML
    private TextField categoryT;
    @FXML
    private TextField puissanceT;
    @FXML
    private TextField dailyPriceT;
    @FXML
    private TextField typeT;
    @FXML
    private TextField imageT;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btn_image;
    ServiceLocation serviceLocation = new ServiceLocation();
    private File file;
    private FileInputStream fis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceLocation ser = new ServiceLocation();
        ArrayList<Location> liste = (ArrayList<Location>) ser.afficherLocation();
        ObservableList observableList = FXCollections.observableArrayList(liste);
        tableView.setItems(observableList);     // search.setVisible(false);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        puissance.setCellValueFactory(new PropertyValueFactory<>("puissance"));
        dailyPrice.setCellValueFactory(new PropertyValueFactory<>("dailyPrice"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        image.setCellValueFactory(new PropertyValueFactory<>("image_id"));

        btnSupprimer.setOnMouseClicked(x -> {
            Location cat = new Location();
            cat = (Location) tableView.getSelectionModel().getSelectedItem();

            if (cat == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alerte");
                alert.setHeaderText("Alerte");
                alert.setContentText("Il faut tout d'abord sélectionner une location");
                alert.show();
            } else {

                // get Selected Item
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir supprimer cette location?", ButtonType.YES, ButtonType.NO, null);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    //remove selected item from the table list
                    serviceLocation.supprimerLocation(cat);
                    //bonplanService.SupprimerCategorie(cat);
                    tableView.getItems().clear();

                    tableView.getItems().addAll(serviceLocation.afficherLocation());
                    ChargerLocation();
                }
            }
        });
        tableView.setOnMouseClicked(e -> {
            Location cat = new Location();
            cat = (Location) tableView.getSelectionModel().getSelectedItem();
            idT.setText(String.valueOf(cat.getId()));
            matriculeT.setText(cat.getMatricule());
            puissanceT.setText(cat.getPuissance());
            marqueT.setText(cat.getMarque());
            modelT.setText(cat.getModel());
            categoryT.setText(cat.getCategory());
            dailyPriceT.setText(String.valueOf(cat.getDailyPrice()));

            imageT.setText(cat.getImage_id());
            typeT.setText(cat.getType());

        });

        btnUpdate.setOnAction(e -> {

            Location cat = tableView.getSelectionModel().getSelectedItem();

            if (cat == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alerte");
                alert.setHeaderText("Alerte");
                alert.setContentText("Il faut tout d'abord sélectionner un location");
                alert.show();
            } else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir modifier ce location", ButtonType.YES, ButtonType.NO, null);
                alert.showAndWait();
                Statement statement = null;
                ResultSet resultSet = null;
                   Location ca = new Location();
                    ca.setId(Integer.parseInt(idT.getText()));
                    ca.setMatricule(matriculeT.getText());
                    ca.setPuissance(puissanceT.getText());
                    ca.setMarque(marqueT.getText());
                    ca.setModel(modelT.getText());
                    ca.setCategory(categoryT.getText());
                    ca.setDailyPrice(Double.parseDouble(dailyPriceT.getText()));

                    ca.setImage_id(imageT.getText());
                    ca.setType(typeT.getText());


                if (alert.getResult() == ButtonType.YES) {
                 
                    serviceLocation.modifier(ca);
                    ChargerLocation();

                }
            }

        });

        
       

    }

    public void ChargerLocation() {

        ArrayList<Location> listeLocation = (ArrayList<Location>) serviceLocation.afficherLocation();

        ObservableList observableList = FXCollections.observableArrayList(listeLocation);
        tableView.setItems(observableList);
        idT.setText("");
        matriculeT.setText("");
        puissanceT.setText("");
        marqueT.setText("");
        modelT.setText("");
        categoryT.setText("");
        dailyPriceT.setText("");
        imageT.setText("");
        typeT.setText("");

    }

    @FXML
    private void SearchByName(ActionEvent event) {
        ServiceLocation bs = new ServiceLocation();
        ArrayList AL = (ArrayList) bs.afficherLocation();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Location> filtred_c = new FilteredList<>(OReservation, e -> true);
        tf_recherche.setOnKeyReleased(e -> {
            tf_recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filtred_c.setPredicate((Predicate<? super Location>) p -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    //  String toLowerCaseNewValue = newValue.toLowerCase();
                    if ((p.getMatricule().contains(newValue))) {
                        return true;

                    }

                    return false;
                });
            });
        });
        tableView.setItems(filtred_c);

    }

    @FXML
    private void UpdateLocation(ActionEvent event) {

    }

    @FXML
    private void DeleteLocation(ActionEvent event) {
    }

    @FXML
    private void AddLocation(ActionEvent event) throws IOException {
        if (idT.getText().isEmpty() || matriculeT.getText().isEmpty()
                || marqueT.getText().isEmpty()
                || modelT.getText().isEmpty() || categoryT.getText().isEmpty()
                || puissanceT.getText().isEmpty() || dailyPriceT.getText().isEmpty() || typeT.getText().isEmpty() || imageT.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Il faut remplir les champs obligatoires ");
            alert.showAndWait();
        } else {
            Location l = new Location(Integer.valueOf(idT.getText()), matriculeT.getText(),
                    marqueT.getText(), modelT.getText(), categoryT.getText(), puissanceT.getText(), Double.valueOf(dailyPriceT.getText()), typeT.getText(), imageT.getText());
            serviceLocation.ajouterLocation(l);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nouvelle Location");
            alert.setHeaderText(null);
            alert.setContentText("Location  ajouté !!  ");
            alert.showAndWait();
            ChargerLocation();
        }
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
    private void location(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Location.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

}
