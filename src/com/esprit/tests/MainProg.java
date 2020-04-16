/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;


import javafx.util.Duration;
import animatefx.animation.FadeIn;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author aissa
 */
public class MainProg extends Application{
    double xOffset, yOffset;

    SplashScreenController spashScreen = new SplashScreenController();
    /**
     * @param args the command line arguments
     */
    
        public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_connexion1.fxml"));
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        Image image = new Image("/image/logo.png");

        primaryStage.getIcons().add(image);
        scene.setFill(Color.TRANSPARENT);
         primaryStage.show();
         new FadeIn(root).play();
         	    primaryStage.hide();

            spashScreen.showWindow();

	//I am using the code below so the Primary Stage of the application 
	//doesn't appear for 2 seconds , so the splash screen is displayed
	PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(1));
	splashScreenDelay.setOnFinished(f -> {
	    primaryStage.show();
	    spashScreen.hideWindow();
	});
	splashScreenDelay.playFromStart();

         root.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					xOffset = event.getSceneX();
					yOffset = event.getSceneY();
				}
			});
			root.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					primaryStage.setX(event.getScreenX() - xOffset);
					primaryStage.setY(event.getScreenY() - yOffset);
				}
			});

    }
    
    
    public static void main(String[] args) {
      launch(args);
     }
    
}




