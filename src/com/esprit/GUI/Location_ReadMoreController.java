/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;
import static java.time.temporal.ChronoUnit.SECONDS;

import static com.esprit.GUI.UI_LocationController.imagexx;
import static com.esprit.GUI.UI_LocationController.imagexx1;
import com.esprit.models.Location;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.ZoneId;
import java.util.ResourceBundle;
import static java.util.concurrent.TimeUnit.DAYS;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import static org.joda.time.format.ISODateTimeFormat.date;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Location_ReadMoreController implements Initializable {

    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private Label price;
    @FXML
    private Label matricule;
    @FXML
    private Label marque;
    @FXML
    private Label model;
    @FXML
    private Label category;
    @FXML
    private Label puissance;
    @FXML
    private Label dailyP;
    @FXML
    private Button calculer;
    ResultSet rs;
    @FXML
    private ImageView image;
    @FXML
    private Circle btnClose;
    public static Location location;
    //   private final int taz =  UI_LocationController.id1;
    private  String matriculex = UI_LocationController.matricx;
    private  String marquex = UI_LocationController.marquex;
    private  String modelx = UI_LocationController.modelx;
    private  String categoryx = UI_LocationController.categoryx;
    private  String puissancex = UI_LocationController.puissancex;
    private  double dailyPx = UI_LocationController.dailyPx;
    private  String matriculex1 = UI_LocationController.matricx1;
    private  String marquex1 = UI_LocationController.marquex1;
    private  String modelx1 = UI_LocationController.modelx1;
    private  String categoryx1 = UI_LocationController.categoryx1;
    private  String puissancex1 = UI_LocationController.puissancex1;
    private  double dailyPx1 = UI_LocationController.dailyPx1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(Location_ReadMoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMouseEvenet(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }

    public void afficher() throws SQLException {
        // UI_LocationController.matricule1 = rs.getString("matricule");

          
        matricule.setText(location.getMatricule());
        marque.setText(location.getMarque());
        model.setText(location.getModel());
        category.setText(location.getCategory());
        puissance.setText(location.getPuissance());
        dailyP.setText(String.valueOf(location.getDailyPrice()));
        Image imagexx = new Image("image/" + location.getImage_id());
        image.setImage(imagexx);

        
      
    }

    @FXML
    private void louer(ActionEvent event) {
      TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            
            
            tray.setAnimationType(type);
            tray.setTitle("If U are sure to rent this car ");
            tray.setMessage("PLEASE VISIT US IN OUR DEPARTMENT");
            tray.setNotificationType(NotificationType.INFORMATION);
            tray.showAndDismiss(Duration.millis(3000));
          
        
    }

    @FXML
    private void calculer(ActionEvent event) {
      
            //datedebut
        LocalDate localDateDebut = date1.getValue();
            Instant instant = Instant.from(localDateDebut.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date date = java.util.Date.from(instant);
            java.sql.Date dtdebut = new java.sql.Date(date.getTime());
             //datefin
             LocalDate localDateFin = date2.getValue();
            Instant instant1 = Instant.from(localDateFin.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date datefin = java.util.Date.from(instant1);
           java.sql.Date dtfin = new java.sql.Date(datefin.getTime());

           int diffInDays = (int)( (dtfin.getTime() - dtdebut.getTime()) 
                 / (1000 * 60 * 60 * 24) );
           System.out.println(diffInDays);
      
           float priceCalculed = (float) (diffInDays * location.getDailyPrice());
           
           System.out.println(price);
           
                   price.setText(String.valueOf(priceCalculed));


           
           
           

    }

    @FXML
    private void backhome(ActionEvent event) throws IOException {
        UI_LocationController.fromBack = true;
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Location.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
}
