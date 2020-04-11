/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.models.Personne;
import com.esprit.services.ServicePersonne;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ChatController implements Initializable {

    @FXML
    private ListView list;
    @FXML
    private TableView<Personne> tabview;
    @FXML
    private TableColumn<Personne, String> colview;
    @FXML
    private TextField mess_txt;
    @FXML
    private Button env;
     @FXML
    private Circle btnClose;

    public static String ff = "";
 @FXML
    private Label variable;
   
        ObservableList<String> chatMessages = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicePersonne fa = new ServicePersonne();
 ArrayList<Personne> fam = (ArrayList<Personne>) fa.displayMessage();
        ObservableList<Personne> obs = FXCollections.observableArrayList(fam);
        tabview.setItems(obs);
        colview.setCellValueFactory(new PropertyValueFactory<Personne, String>("username"));

            try {
            //a();

            contact();

        } catch (IOException ex) {
            // Logger.getLogger(FXML_liste_familleController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }    

    
   public void contact() throws IOException {
        tabview.setOnMouseClicked(new EventHandler<MouseEvent>() {

            
            public void handle(MouseEvent event) {

                boolean ans = chatMessages.isEmpty();
                if (ans == false) {
                    chatMessages.clear();


        Personne E = tabview.getSelectionModel().getSelectedItem();
        variable.setText(E.getUsername());

        // System.out.println(E.getNom_r());
        String s = variable.getText();
        ChatController.ff = s;
        Statement statement = null;
        ResultSet resultSet = null;
        DataSource myc = DataSource.getInstance();
        Connection cnx = myc.getCnx();
        ServicePersonne n = new ServicePersonne();
        int id_famille = n.getVerif(ChatController.ff);
       // System.out.println("-----------------------" + id_refuge + "-----------------------");
        int id_asso = n.getVerif(Interface_connexion1Controller.hh);
        try {
            statement = cnx.createStatement();
                 String sql = "SELECT * FROM message_asso_famille  where (id_message ='" + id_asso + "' or id_message ='" + id_famille + "' )  and  ( login_envoi ='" + Interface_connexion1Controller.hh + "' or login_envoi ='" + ChatController.ff+ "') and (login_recep ='" + ChatController.ff + "'   or login_recep ='" + Interface_connexion1Controller.hh+ "')order by date ";

                 resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // nom_ref.setText();

              
                    chatMessages.add(resultSet.getString("login_envoi") + " : " + resultSet.getString("message"));
                
                
                
                
                list.setItems(chatMessages);
                                list.scrollTo(Integer.MAX_VALUE);

//                                                
//Blob b =  resultSet.getBlob("image_db");
//         InputStream istreamImage= b.getBinaryStream();
//                Image i = new Image (istreamImage);        
//            im.setImage(i);
                // im.resultSet.getImage("image_db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }                } else {

        Personne E = tabview.getSelectionModel().getSelectedItem();
        variable.setText(E.getUsername());

        // System.out.println(E.getNom_r());
        String s = variable.getText();
        ChatController.ff = s;
        Statement statement = null;
        ResultSet resultSet = null;
        DataSource myc = DataSource.getInstance();
        Connection cnx = myc.getCnx();
        ServicePersonne n = new ServicePersonne();
        int id_famille = n.getVerif(ChatController.ff);
       // System.out.println("-----------------------" + id_refuge + "-----------------------");
        int id_asso = n.getVerif(Interface_connexion1Controller.hh);
        try {
            statement = cnx.createStatement();
                 String sql = "SELECT * FROM message_asso_famille  where (id_message ='" + id_asso + "' or id_message ='" + id_famille + "' )  and  ( login_envoi ='" + Interface_connexion1Controller.hh + "' or login_envoi ='" + ChatController.ff+ "') and (login_recep ='" + ChatController.ff + "'   or login_recep ='" + Interface_connexion1Controller.hh+ "')order by date ";

                 resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // nom_ref.setText();

              
                    chatMessages.add(resultSet.getString("login_envoi") + " : " + resultSet.getString("message"));
                
                
                
                
                list.setItems(chatMessages);
                                list.scrollTo(Integer.MAX_VALUE);

//                                                
//Blob b =  resultSet.getBlob("image_db");
//         InputStream istreamImage= b.getBinaryStream();
//                Image i = new Image (istreamImage);        
//            im.setImage(i);
                // im.resultSet.getImage("image_db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }                }
            }

        }
        );

    }
  
    
    
     public void affiche_message() {

        Personne E = tabview.getSelectionModel().getSelectedItem();
        variable.setText(E.getUsername());

        // System.out.println(E.getNom_r());
        String s = variable.getText();
        ChatController.ff = s;
        Statement statement = null;
        ResultSet resultSet = null;
        DataSource myc = DataSource.getInstance();
        Connection cnx = myc.getCnx();
        ServicePersonne n = new ServicePersonne();
        int id_personne = n.getVerif(ChatController.ff);
       // System.out.println("-----------------------" + id_refuge + "-----------------------");
        try {
            statement = cnx.createStatement();
                 String sql = "SELECT * FROM message_asso_famille  where ( id_message ='" + id_personne + "' )  and  (  login_envoi ='" + ChatController.ff+ "') and (login_recep ='" + ChatController.ff + "' )order by date ";

                 resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // nom_ref.setText();

              
                    chatMessages.add(resultSet.getString("login_envoi") + " : " + resultSet.getString("message"));
                
                
                
                
                list.setItems(chatMessages);
                                list.scrollTo(Integer.MAX_VALUE);

//                                                
//Blob b =  resultSet.getBlob("image_db");
//         InputStream istreamImage= b.getBinaryStream();
//                Image i = new Image (istreamImage);        
//            im.setImage(i);
                // im.resultSet.getImage("image_db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
     @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }
    
   @FXML
    public void env_btn(ActionEvent event) throws IOException {
        String rol = "Famille";

        String tx_c = mess_txt.getText();
          ServicePersonne n55 = new ServicePersonne();
        String login_en = Interface_connexion1Controller.hh;
        String login_re = ChatController.ff;
          int pm = n55.getVerif(Interface_connexion1Controller.hh);
          int id_recep = n55.getVerif(ChatController.ff);
        
       // int pm = Integer.parseInt(FXML_liste_familleController.ii);

        ServicePersonne famille_service = new ServicePersonne();
                Personne famille_entity = new Personne(pm, login_en,login_re, tx_c, Timestamp.valueOf(LocalDateTime.now()) );
 famille_service.ajouterFamille_mess(famille_entity);
 
 
  boolean ans = chatMessages.isEmpty();
                if (ans == false) {
                    chatMessages.clear();


        Personne E = tabview.getSelectionModel().getSelectedItem();
        variable.setText(E.getUsername());

        // System.out.println(E.getNom_r());
        String s = variable.getText();
        ChatController.ff = s;
        Statement statement = null;
        ResultSet resultSet = null;
        DataSource myc = DataSource.getInstance();
        Connection cnx = myc.getCnx();
        ServicePersonne n = new ServicePersonne();
        int id_personne = n.getVerif(ChatController.ff);
       // System.out.println("-----------------------" + id_refuge + "-----------------------");
        int id_asso = n.getVerif(Interface_connexion1Controller.hh);
        try {
            statement = cnx.createStatement();
                 String sql = "SELECT * FROM message_asso_famille  where (id_message ='" + id_asso + "' or id_message ='" + id_personne + "' )  and  ( login_envoi ='" + ChatController.ff+ "') and (login_recep ='" + ChatController.ff + "'   or login_recep ='" + Interface_connexion1Controller.hh+ "')order by date ";

                 resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // nom_ref.setText();

              
                    chatMessages.add(resultSet.getString("login_envoi") + " : " + resultSet.getString("message"));
                
                
                
                
                list.setItems(chatMessages);
                                list.scrollTo(Integer.MAX_VALUE);

//                                                
//Blob b =  resultSet.getBlob("image_db");
//         InputStream istreamImage= b.getBinaryStream();
//                Image i = new Image (istreamImage);        
//            im.setImage(i);
                // im.resultSet.getImage("image_db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }                } else {

        Personne E = tabview.getSelectionModel().getSelectedItem();
        variable.setText(E.getUsername());

        // System.out.println(E.getNom_r());
        String s = variable.getText();
        ChatController.ff = s;
        Statement statement = null;
        ResultSet resultSet = null;
        DataSource myc = DataSource.getInstance();
        Connection cnx = myc.getCnx();
        ServicePersonne n = new ServicePersonne();
        int id_famille = n.getVerif(ChatController.ff);
       // System.out.println("-----------------------" + id_refuge + "-----------------------");
        int id_asso = n.getVerif(Interface_connexion1Controller.hh);
        try {
            statement = cnx.createStatement();
                 String sql = "SELECT * FROM message_asso_famille  where (id_message ='" + id_asso + "' or id_message ='" + id_famille + "' )  and  ( login_envoi ='" + Interface_connexion1Controller.hh + "' or login_envoi ='" + ChatController.ff+ "') and (login_recep ='" + ChatController.ff + "'   or login_recep ='" + Interface_connexion1Controller.hh+ "')order by date ";

                 resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // nom_ref.setText();

              
                    chatMessages.add(resultSet.getString("login_envoi") + " : " + resultSet.getString("message"));
                
                
                
                
                list.setItems(chatMessages);
                                list.scrollTo(Integer.MAX_VALUE);

//                                                
//Blob b =  resultSet.getBlob("image_db");
//         InputStream istreamImage= b.getBinaryStream();
//                Image i = new Image (istreamImage);        
//            im.setImage(i);
                // im.resultSet.getImage("image_db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }                }
            }
  
}
