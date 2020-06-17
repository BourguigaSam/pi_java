/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.models.Location;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UI_LocationController implements Initializable {

    @FXML
    private Circle btnClose;
    @FXML
    private Button next;
    @FXML
    private Label matricule;
    @FXML
    private Label marque;
    @FXML
    private Label dailyPrice;
    @FXML
    Label matricule1;
    @FXML
    private Label marque1;
    @FXML
    private Label dailyPrice1;
    @FXML
    private Label matricule2;
    @FXML
    private Label marque2;
    @FXML
    private Label dailyPrice2;
    @FXML
    private Label matricule3;
    @FXML
    private Label marque3;
    @FXML
    private Label dailyPrice3;
    @FXML
    private Label matricule4;
    @FXML
    private Label marque4;
    @FXML
    private Label dailyPrice4;
    @FXML
    private Label matricule5;
    @FXML
    private Label marque5;
    @FXML
    private Label dailyPrice5;
    @FXML
    private Button see6;
    @FXML
    private Button see1;
    @FXML
    private Button see2;
    @FXML
    private Button see3;
    @FXML
    private Button see4;
    @FXML
    private Button see5;
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
    public static int id1;
    public static String matricx;
    public static String marquex;
    public static String modelx;
    public static String categoryx;
    public static String puissancex;
    public static double dailyPx;
    public static Image imagexx;
    
    public static ArrayList<Location> locationList = new ArrayList();
    public static int index = 0;
    public static boolean fromBack = false;
    public static String matricx1;
    public static String marquex1;
    public static String modelx1;
    public static String categoryx1;
    public static String puissancex1;
    public static double dailyPx1;
    public static Image imagexx1;

    private Connection con = DataSource.getInstance().getCnx();
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            rs = con.createStatement().executeQuery("select * from location ");
            if (index == 0) {
                rs.first();
            }
            afficherListe();
            
        } catch (SQLException ex) {
            Logger.getLogger(UI_LocationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        public void afficherListe() throws SQLException { 
             for(int i = 0; i < 6 ; i++) {
             rs.next();
            Location myLocation = new Location(rs.getString("matricule"),rs.getString("marque"),rs.getString("model"),rs.getString("category"),rs.getString("puissance")
          ,rs.getDouble("daily_price"),rs.getString("image_id"));
  locationList.add(myLocation);
            }
         
        afficherListe1(locationList);

    }
       public void afficherBackListe() {
           index -= 6;
            afficherListe1(locationList);
        }
    
    
     public void afficherListe1(ArrayList<Location> locationList) {
        System.out.println(index);
        Image imagex1 = new Image("image/" + locationList.get(index).getImage_id());
        image1.setImage(imagex1);
        matricule.setText(locationList.get(index).getMatricule());
        marque.setText(locationList.get(index).getMarque());
        dailyPrice.setText(String.valueOf(locationList.get(index).getDailyPrice()));
        see1.setOnMouseClicked(x -> {
            
            Location_ReadMoreController.location = locationList.get(index - 6);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Location_ReadMore.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) x.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        index++;
        Image imagex2 = new Image("image/" + locationList.get(index).getImage_id());
          image2.setImage(imagex2);
        matricule1.setText(locationList.get(index).getMatricule());
        marque1.setText(locationList.get(index).getMarque());
        dailyPrice1.setText(String.valueOf(locationList.get(index).getDailyPrice()));
        System.out.println(index);
        see2.setOnMouseClicked(x -> {
            
            Location_ReadMoreController.location = locationList.get(index - 5);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Location_ReadMore.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) x.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        index++;            
        Image imagex3 = new Image("image/" + locationList.get(index).getImage_id());
        System.out.println("image/" + locationList.get(index).getImage_id());
        image3.setImage(imagex3);
        matricule2.setText(locationList.get(index).getMatricule());
        marque2.setText(locationList.get(index).getMarque());
        dailyPrice2.setText(String.valueOf(locationList.get(index).getDailyPrice()));
        System.out.println(index);
        see3.setOnMouseClicked(x -> {
            
            Location_ReadMoreController.location = locationList.get(index - 4);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Location_ReadMore.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) x.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        index++;
        Image imagex4 = new Image("image/" + locationList.get(index).getImage_id());
        System.out.println("image/" + locationList.get(index).getImage_id());
        image4.setImage(imagex4);
        matricule3.setText(locationList.get(index).getMatricule());
        marque3.setText(locationList.get(index).getMarque());
        dailyPrice3.setText(String.valueOf(locationList.get(index).getDailyPrice()));
        System.out.println(index);
        see4.setOnMouseClicked(x -> {
            
            Location_ReadMoreController.location = locationList.get(index - 3 );
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Location_ReadMore.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) x.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        index++;
        Image imagex5 = new Image("image/" + locationList.get(index).getImage_id());
        image5.setImage(imagex5);
        matricule4.setText(locationList.get(index).getMatricule());
        marque4.setText(locationList.get(index).getMarque());
        dailyPrice4.setText(String.valueOf(locationList.get(index).getDailyPrice()));
        System.out.println(index);
        see5.setOnMouseClicked(x -> {
            
            Location_ReadMoreController.location = locationList.get(index - 2);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Location_ReadMore.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) x.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        index++;
        Image imagex6 = new Image("image/" + locationList.get(index).getImage_id());
        image6.setImage(imagex6);
        matricule5.setText(locationList.get(index).getMatricule());
        marque5.setText(locationList.get(index).getMarque());
        dailyPrice5.setText(String.valueOf(locationList.get(index).getDailyPrice()));
        see6.setOnMouseClicked(x -> {
            
            Location_ReadMoreController.location = locationList.get(index - 1);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Location_ReadMore.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) x.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fromBack = false;
        index++;
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
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Shop.fxml"));

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
