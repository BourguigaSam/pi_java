/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;

import com.esprit.models.Location;
import com.esprit.models.Personne;
import com.esprit.services.ServiceLocation;
import com.esprit.services.ServicePersonne;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author aissa
 */
public class MainProg extends Application{

    /**
     * @param args the command line arguments
     */
    
        public void start(Stage primaryStage) throws Exception {
        
            Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Event.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Accueil HuntKingdom");
             //   primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setScene(scene);
        primaryStage.show();
       primaryStage.setResizable(true);
    }
    
    
    public static void main(String[] args) {
      launch(args);
     }
    
}
