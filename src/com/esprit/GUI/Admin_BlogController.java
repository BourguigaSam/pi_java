/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Blog;
import com.esprit.services.ServiceBlog;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Admin_BlogController implements Initializable {

    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<Blog> tableView;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> content;
    @FXML
    private TableColumn<?, ?> nbre;
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
    private Button btnUpdate;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField titleT;
    @FXML
    private TextField imageT;
    @FXML
    private TextField contentT;
    @FXML
    private Button btnAdd;
     @FXML
    private Circle btnClose;

ServiceBlog serviceBlog = new ServiceBlog();
  private File file;
    private FileInputStream fis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            ChargerBlog();

   ServiceBlog ser = new ServiceBlog();
        ArrayList<Blog> liste = (ArrayList<Blog>) ser.afficherBlog();
        ObservableList observableList = FXCollections.observableArrayList(liste);
       tableView.setItems(observableList);     // search.setVisible(false);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
         content.setCellValueFactory(new PropertyValueFactory<>("content"));
        nbre.setCellValueFactory(new PropertyValueFactory<>("repliesnumber"));
        likes.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        categoory.setCellValueFactory(new PropertyValueFactory<>("dailyPrice"));
       accept.setCellValueFactory(new PropertyValueFactory<>("accept"));
      image.setCellValueFactory(new PropertyValueFactory<>("image"));


      btnSupprimer .setOnMouseClicked(x -> {
 Blog cat = new Blog();
cat = (Blog) tableView.getSelectionModel().getSelectedItem();

        if (cat== null) {
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
                serviceBlog.supprimerBlog(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
        
            tableView.getItems().addAll(serviceBlog.afficherBlog());
            ChargerBlog();
            }
        }
        });
       tableView.setOnMouseClicked(e->{
      Blog bl = new Blog();
bl = (Blog) tableView.getSelectionModel().getSelectedItem();
id.setText(String.valueOf(bl.getId()));
                 imageT.setText(bl.getImage());
                 contentT.setText(bl.getContent());
                 titleT.setText(bl.getTitle());
                 
                 
     
 });
       

      
      
      
      
      
      Stage stage = new Stage();
        btnAdd.setOnAction(e -> {
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
                    Logger.getLogger(Admin_BlogController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    //     Image image=  new Image(file.toURI().toString());
                    URL url1 = file.toURI().toURL();
                    System.out.println(new Image(url1.toExternalForm()));
                    //image_post.setImage(new Image(url1.toExternalForm()));
                } catch (MalformedURLException ex) {
                    
                    Logger.getLogger(Admin_BlogController.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            };
            
        });
      btnUpdate .setOnAction(e-> {
 Blog cat = new Blog();
cat = (Blog) tableView.getSelectionModel().getSelectedItem();

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner un blog");
            alert.show();
        } else { 
            

                 
                 
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir modifier cet evenement", ButtonType.YES, ButtonType.NO, null);
                 alert.showAndWait();
                 Statement statement = null;
                 ResultSet resultSet = null;
                
               Blog ca= new Blog();
     ca.setId(Integer.parseInt(id.getText()));
                 ca.setContent(contentT.getText());
                 ca.setImage(imageT.getText());
                 ca.setTitle(titleT.getText());
                 
            
            
                 
                 if (alert.getResult() == ButtonType.YES) {
                     
                     
                     
                     //remove selected item from the table list
                                  serviceBlog.modifierBlog(ca);

                     //bonplanService.SupprimerCategorie(cat);
                    
                     ChargerBlog();
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
    public void ChargerBlog() {
        
        ServiceBlog serviceBlog = new ServiceBlog();
        ArrayList<Blog> listeBlog = (ArrayList<Blog>) serviceBlog.afficherBlog();

        ObservableList observableList = FXCollections.observableArrayList(listeBlog);
        tableView.setItems(observableList);
titleT.setText("");
imageT.setText("");
contentT.setText("");

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
        
          ServiceBlog bs = new ServiceBlog();
        ArrayList AL = (ArrayList) bs.afficherBlog();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Blog> filtred_c = new FilteredList<>(OReservation, e -> true);
        tf_recherche.setOnKeyReleased(e -> {
            tf_recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filtred_c.setPredicate((Predicate<? super Blog>) p -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                  //  String toLowerCaseNewValue = newValue.toLowerCase();
                    if ((p.getTitle().contains(newValue)) ) {
                        return true;

                    }

                    return false;
                });
            });
        });
        tableView.setItems(filtred_c);

    
        
        
    }
    
     @FXML
    private void AddLocation(ActionEvent event) throws IOException  {
           if (titleT.getText().isEmpty() || contentT.getText().isEmpty() 
                ||  imageT.getText().isEmpty()
                ) {          
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Il faut remplir les champs obligatoires ");
            alert.showAndWait();
        }
        else
        {
                Blog b = new Blog( titleT.getText(),contentT.getText()
                    , imageT.getText());
            serviceBlog.ajouterBlog(b);
            
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nouveau Blog");
            alert.setHeaderText(null);
            alert.setContentText("Blog  ajouté !! ");
            alert.showAndWait();
        ChargerBlog();
    }
    }
    
    
    
    
}
