/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.GUI.Session;
import com.esprit.models.Panier;
import com.esprit.models.Personne;
import com.esprit.models.Produit;
import com.esprit.services.ServicePanier;
import com.esprit.utils.DataSource;
import com.twilio.exception.AuthenticationException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UI_ShopController implements Initializable {

    @FXML
    private Circle btnClose;
    @FXML
    private Button next;
    @FXML
    private Label nom;
    @FXML
    private Label price;
    @FXML
    private Button buy;
    @FXML
    private Label nom1;
    @FXML
    private Label price1;
    @FXML
    private Button buy1;
    @FXML
    private Label nom2;
    @FXML
    private Label price2;
    @FXML
    private Button buy2;
    @FXML
    private Label nom3;
    @FXML
    private Label price3;
    @FXML
    private Button buy3;
    @FXML
    private Label nom4;
    @FXML
    private Label price4;
    @FXML
    private Button buy4;
    @FXML
    private Label nom5;
    @FXML
    private Label price5;
    @FXML
    private Button buy5;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    private Connection con = DataSource.getInstance().getCnx();
    ResultSet rs;
    public static Personne ConnectedUser = new Personne();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            rs = con.createStatement().executeQuery("select * from produit ");
            afficherListe();
        } catch (SQLException ex) {
            Logger.getLogger(UI_LocationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afficherListe() throws SQLException {
        rs.first();
        Image imagex1 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image1.setImage(imagex1);
        nom.setText(rs.getString("nom"));
        price.setText(rs.getString("prix"));

        rs.next();
         Image imagex2 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image2.setImage(imagex2);
        nom1.setText(rs.getString("nom"));
        price1.setText(rs.getString("prix"));

        rs.next();
        Image imagex3 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image3.setImage(imagex3);
        nom2.setText(rs.getString("nom"));
        price2.setText(rs.getString("prix"));

        rs.next();
        Image imagex4 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image4.setImage(imagex4);
        nom3.setText(rs.getString("nom"));
        price3.setText(rs.getString("prix"));

        rs.next();
        Image imagex5 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image5.setImage(imagex5);
        nom4.setText(rs.getString("nom"));
        price4.setText(rs.getString("prix"));

        rs.next();
        Image imagex6 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image6.setImage(imagex6);
        nom5.setText(rs.getString("nom"));
        price5.setText(rs.getString("prix"));

    }

    @FXML
    public void afficherListe1() throws SQLException {
        rs.next();
        System.out.println(rs.getString("image_id"));
        Image imagex1 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image1.setImage(imagex1);
        nom.setText(rs.getString("nom"));
        price.setText(rs.getString("prix"));

        rs.next();
        Image imagex2 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image2.setImage(imagex2);
        nom1.setText(rs.getString("nom"));
        price1.setText(rs.getString("prix"));

        rs.next();
        Image imagex3 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image3.setImage(imagex3);
        nom2.setText(rs.getString("nom"));
        price2.setText(rs.getString("prix"));

        rs.next();
        Image imagex4 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image4.setImage(imagex4);
        nom3.setText(rs.getString("nom"));
        price3.setText(rs.getString("prix"));

        rs.next();
        Image imagex5 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image5.setImage(imagex5);
        nom4.setText(rs.getString("nom"));
        price4.setText(rs.getString("prix"));

        rs.next();
        Image imagex6 = new Image("image/" + rs.getString("image_id"));
        System.out.println("image/" + rs.getString("image_id"));
        image6.setImage(imagex6);
        nom5.setText(rs.getString("nom"));
        price5.setText(rs.getString("prix"));

    }

    @FXML
    private void handleMouseEvenet(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }

    @FXML
    private void backhome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void mousepressedhome(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void mousepressedinbox(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Chat.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void mousepressedstore(MouseEvent event) throws IOException {
        // change it to store interface
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Chat.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void mousepressedsevent(MouseEvent event) throws IOException {
        // change it to store interface
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_event.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void mousepressedrent(MouseEvent event) throws IOException {
        // change it to store interface
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Location.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void mousepressedblog(MouseEvent event) throws IOException {
        // change it to store interface
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Blog.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void addtopanier(ActionEvent event) throws IOException, SQLException {
    
            Button btn = (Button) event.getSource();
            String id = btn.getId();
            System.out.println(id);
            
            if (id.equals("buy"))
                
            {
                
                System.out.println(Controller.getUserId());
                System.out.println(price);
                System.out.println(nom);
                
            }
            else if (id.equals("buy1"))
                  {
                      System.out.println(nom);
                      System.out.println(price);
                      System.out.println(ConnectedUser);
            }
            else if (id.equals("buy2"))
                  {
            }
            else if (id.equals("buy3"))
                  {
            }
            else if (id.equals("buy4"))
                  {
            }
            else if (id.equals("buy5"))
                  {
            }
            else 
                  {
            }
     
    }

}
