/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.services.ServiceEvenement;
import com.esprit.utils.DataSource;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AfficherClientController  extends Controller implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private VBox vbox;
    @FXML
    private HBox hbox;
    @FXML
    private ImageView image;
    @FXML
    private Label titre;
    @FXML
    private Label date;
     @FXML
    private Circle btnClose;

    private Connection con = DataSource.getInstance().getCnx();
    private final ServiceEvenement es = new ServiceEvenement();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 try {
            afficherliste();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public AnchorPane afficherliste() throws SQLException {

            
                 ScrollPane sp = new ScrollPane();
        AnchorPane anchor = new AnchorPane();
        ResultSet rs = con.createStatement().executeQuery("select * from evenement ");
        rs.last();
        int x = rs.getRow();
        rs.first();

        for (int i = 0; i < x; i++) {

         
            ImageView image = new ImageView();
            //Image img = new Image(getClass().getResource("/Images/").toExternalForm() + rs.getString("image"));
            //image.setImage(img);
            
            Label label1 = new Label();
            label1.setText(rs.getString("nom"));
            
        Label label2 = new Label();
          label2.setText(rs.getString("dateEvenement"));
      
           anchor.getChildren().addAll(image, label1, label2);
        //    hbox.getChildren().addAll(image, label1, btn);

         //   vbox.getChildren().add(hbox);

              rs.next();
        }

        sp.setContent(vbox);
        anchor.getChildren().add(sp);

        return anchor;
   
            
            
        }
         @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }
}
