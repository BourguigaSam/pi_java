/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UI_BlogController implements Initializable {

    @FXML
    private Circle btnClose;
    @FXML
    private Button next;
    @FXML
    private ImageView image;
    @FXML
    private Label title;
    @FXML
    private Label text;
    private Connection con = DataSource.getInstance().getCnx();
    ResultSet rs;
    @FXML
    private ImageView image1;
    @FXML
    private Label title1;
    @FXML
    private Label text1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            rs = con.createStatement().executeQuery("select * from blog ");
            afficherListe();
        } catch (SQLException ex) {
            // System.out.println("dddd");
            Logger.getLogger(UI_eventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afficherListe() throws SQLException {
        rs.first();
                    System.out.println(Controller.getUserId());

        Image imagex = new Image("image/" + rs.getString("image"));
        image.setImage(imagex);
        title.setText(rs.getString("title"));
        text.setText(rs.getString("content"));
        rs.next();
        Image imagex2 = new Image("image/" + rs.getString("image"));
        System.out.println("image/" + rs.getString("image"));
        image1.setImage(imagex2);
        title1.setText(rs.getString("title"));
        text1.setText(rs.getString("content"));

    }

    @FXML
    public void afficherListe1() throws SQLException {
        rs.next();
        Image imagex = new Image("image/" + rs.getString("image"));
        System.out.println("image/" + rs.getString("image"));
        image.setImage(imagex);
        title.setText(rs.getString("title"));
        text.setText(rs.getString("content"));
        rs.next();
        Image imagex2 = new Image("image/" + rs.getString("image"));
        System.out.println("image/" + rs.getString("image"));
        image1.setImage(imagex2);
        title1.setText(rs.getString("title"));
        text1.setText(rs.getString("content"));

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
}
