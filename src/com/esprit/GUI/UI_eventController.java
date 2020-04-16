/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.models.Participation;
import com.esprit.services.ServiceEvenement;
import com.esprit.services.ServiceParticipation;
import com.esprit.utils.DataSource;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UI_eventController implements Initializable {
 ResultSet rs;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Label nom;
    @FXML
    private Label date;
    @FXML
    private Label lieu;
    @FXML
    private Label prix;
    
    @FXML
    private Label nom1;
    @FXML
    private ImageView image1;
    @FXML
    private Label date1;
    @FXML
    private Label lieu1;
    @FXML
    private Label prix1;
    
    
    @FXML
    private Label nom2;
    @FXML
    private Label date2;
    @FXML
    private Label lieu2;
    @FXML
    private Label prix2;
    
      @FXML
    private Circle btnClose;
    @FXML
    private Label nom21;
    @FXML
    private Label date21;
    @FXML
    private Label lieu21;
    @FXML
    private Label prix21;
    
    @FXML
    private Button next;
       
    private final ServiceEvenement es = new ServiceEvenement();
    private Connection con = DataSource.getInstance().getCnx();
    @FXML
    private AnchorPane anchorpane1;
    @FXML
    private AnchorPane anchorpane2;
    @FXML
    private AnchorPane anchorpane21;
    @FXML
    private Button participer;
    @FXML
    private Button participer1;
    @FXML
    private Button participer2;
    @FXML
    private Button participer21;
    @FXML
    private Button partAnul;
    @FXML
    private Button partAnul1;
    @FXML
    private Button partAnul2;
       ServiceParticipation ps = new ServiceParticipation();
    @FXML
    private Button partAnul21;
    @FXML
    private ImageView image11;
    @FXML
    private ImageView image12;
    @FXML
    private ImageView image13;
    @FXML
    private ImageView MyParticipation;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 try {
         rs = con.createStatement().executeQuery("select * from evenement ");
            afficherliste();
        } catch (SQLException ex) {
           // System.out.println("dddd");
            Logger.getLogger(UI_eventController.class.getName()).log(Level.SEVERE, null, ex);
        }      
   MyParticipation.setOnMouseClicked(e->{
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Participation.fxml"));
                 Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
            } catch (IOException ex) {
                Logger.getLogger(Interface_Accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       
   });
    
    }
    
         public void afficherliste() throws SQLException {
              //   ScrollPane sp = new ScrollPane();
  // rs.last();
        int x = rs.getRow();
        rs.first();

     nom.setText(rs.getString("nom"));  
          date.setText(rs.getString("dateDebut"));
         lieu.setText(rs.getString("lieu"));
          prix.setText(rs.getString("prix"));
          int id= rs.getInt("id");
          
            
               
       ObservableList<Participation>  data = FXCollections.observableArrayList(ps.AfficherParticipation());

        for (Participation d : data) {
            if ((d.getId_user()!=Controller.getUserId())|| (d.getId_event()!=id) ){
              partAnul.setVisible(false);
          participer.setVisible(true);
                participer.setOnAction(e->{
                    Participation p= new Participation();
                      
                    p.setId_event(id);
                    p.setValidite("en cours");
                    p.setId_user(Controller.getUserId());
              
                
                    ServiceParticipation ps = new ServiceParticipation();
                    ps.ajouterParticipation(p);
                    
                    
                    
                    
                    
                });
            }
            else{
           
                             
          participer.setVisible(false);
            partAnul.setVisible(true);
              partAnul.setOnAction(e->{
               
            Participation p0=ps.AfficherParticipationById(d.getId());
            ps.SupprimerParticipation(p0);
            });
            }
        
                
          
          
                
            }
        
          
              
        
           rs.next();         
          nom1.setText(rs.getString("nom"));  
          date1.setText(rs.getString("dateDebut"));
         lieu1.setText(rs.getString("lieu"));
          prix1.setText(rs.getString("prix"));
          int id1= rs.getInt("id");
              
               
       ObservableList<Participation>  data1 = FXCollections.observableArrayList(ps.AfficherParticipation());

        for (Participation d1 : data1) {
            if ((d1.getId_user()!=Controller.getUserId())|| (d1.getId_event()!=id1) ){
              partAnul1.setVisible(false);
          participer1.setVisible(true);
                participer1.setOnAction(e->{
                    Participation p= new Participation();
                      
                    p.setId_event(id1);
                    p.setValidite("en cours");
                    p.setId_user(Controller.getUserId());
              
                
                    ServiceParticipation ps = new ServiceParticipation();
                    ps.ajouterParticipation(p);
                    
                    
                    
                    
                    
                });
            }
            else{
           
                             
          participer1.setVisible(false);
                partAnul1.setVisible(true);
              partAnul1.setOnAction(e->{
               
            Participation p0=ps.AfficherParticipationById(d1.getId());
            ps.SupprimerParticipation(p0);
            });
            }
        
                
          
          
                
            }
        
              
           
              
                    rs.next();         
 nom2.setText(rs.getString("nom"));  
          date2.setText(rs.getString("dateDebut"));
         lieu2.setText(rs.getString("lieu"));
          prix2.setText(rs.getString("prix"));
           int id2= rs.getInt("id");
                 
               
       ObservableList<Participation>  data2 = FXCollections.observableArrayList(ps.AfficherParticipation());

        for (Participation d2 : data2) {
            if ((d2.getId_user()!=Controller.getUserId())|| (d2.getId_event()!=id2) ){
              partAnul2.setVisible(false);
          participer2.setVisible(true);
                participer2.setOnAction(e->{
                    Participation p= new Participation();
                      
                    p.setId_event(id2);
                    p.setValidite("en cours");
                    p.setId_user(Controller.getUserId());
              
                
                    ServiceParticipation ps = new ServiceParticipation();
                    ps.ajouterParticipation(p);
                    
                    
                    
                    
                    
                });
            }
            else{
           
                             
          participer2.setVisible(false);
                partAnul2.setVisible(true);
              partAnul2.setOnAction(e->{
               
            Participation p0=ps.AfficherParticipationById(d2.getId());
            ps.SupprimerParticipation(p0);
            });
            }
        
                
          
          
                
            }
        
                              rs.next();         
 nom21.setText(rs.getString("nom"));  
          date21.setText(rs.getString("dateDebut"));
         lieu21.setText(rs.getString("lieu"));
          prix21.setText(rs.getString("prix"));
                         int id21= rs.getInt("id");
               
               
       ObservableList<Participation>  data21 = FXCollections.observableArrayList(ps.AfficherParticipation());

        for (Participation d21 : data21) {
            if ((d21.getId_user()!=Controller.getUserId())|| (d21.getId_event()!=id21) ){
              partAnul21.setVisible(false);
          participer21.setVisible(true);
                participer21.setOnAction(e->{
                    Participation p= new Participation();
                      
                    p.setId_event(id21);
                    p.setValidite("en cours");
                    p.setId_user(Controller.getUserId());
              
                
                    ServiceParticipation ps = new ServiceParticipation();
                    ps.ajouterParticipation(p);
                    
                    
                    
                    
                    
                });
            }
            else{
           
                             
          participer21.setVisible(false);
                partAnul21.setVisible(true);
              partAnul21.setOnAction(e->{
               
            Participation p0=ps.AfficherParticipationById(d21.getId());
            ps.SupprimerParticipation(p0);
            });
            }
        
                
          
          
                
            }
        
        }    

         
         @FXML
  public void afficherliste1() throws SQLException {
     
        rs.next();

     nom.setText(rs.getString("nom"));  
          date.setText(rs.getString("dateDebut"));
         lieu.setText(rs.getString("lieu"));
          prix.setText(rs.getString("prix"));
           rs.next();         
          nom1.setText(rs.getString("nom"));  
          date1.setText(rs.getString("dateDebut"));
         lieu1.setText(rs.getString("lieu"));
          prix1.setText(rs.getString("prix"));
                    rs.next();         
 nom2.setText(rs.getString("nom"));  
          date2.setText(rs.getString("dateDebut"));
         lieu2.setText(rs.getString("lieu"));
          prix2.setText(rs.getString("prix"));
                              rs.next();         
 nom21.setText(rs.getString("nom"));  
          date21.setText(rs.getString("dateDebut"));
         lieu21.setText(rs.getString("lieu"));
          prix21.setText(rs.getString("prix"));
       
            
            
        }
   @FXML
    private void mousepressedhome(MouseEvent event) throws IOException{
        
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
    @FXML
    private void mousepressedinbox(MouseEvent event) throws IOException{
        
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Chat.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
    @FXML
     private void mousepressedstore(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Shop.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
 
     @FXML
     private void mousepressedsevent(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_event.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
     @FXML
     private void mousepressedrent(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Location.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
     @FXML
     private void mousepressedblog(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Blog.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
@FXML
     private void myevents(MouseEvent event) throws IOException{
        // change it to store interface
           Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/UI_Participation.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();  
        
    }
       @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
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
  


}
        
   
    
    
        

    
    

