/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Interface_registerController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField email1;
    @FXML
    private TextField pass;
    @FXML
    private TextField pass1;
    @FXML
    private Label terms;
    @FXML
    private CheckBox conditions;
    @FXML
    private Circle btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    @FXML
    private void register(ActionEvent event) throws SQLException, IOException {
        Connection conn = DataSource.getInstance().getCnx(); 
        String req= "INSERT INTO fos_user (username,email,password,phone,roles) VALUES (?,?,?,?,'a:0:{}')";
        String req1= "SELECT * FROM fos_user WHERE email=?";
        PreparedStatement prs= conn.prepareStatement(req);
        PreparedStatement prs1= conn.prepareStatement(req1);
        prs1.setString(1, email.getText());
        ResultSet rs = prs1.executeQuery();
        prs.setString(1, username.getText());
        prs.setString(2, email.getText());
        String pwd = BCrypt.hashpw(pass.getText(),BCrypt.gensalt(13));
        prs.setString(3, pwd.substring(0,2)+"y"+pwd.substring(3));
        prs.setString(4, phone.getText());

        
          if (username.getText().equals(""))
        {   terms.setText("username is empty");  }
        else if (rs.next()){
             terms.setText("email deja existant");
         }
         else if (email.getText().isEmpty()){
             terms.setText("Please insert your Email");
         }
         
                  else if (validateEmaill() == false){
             terms.setText("Your Email Not Working");
         }
                 
         // dear oussam one day i will kill u .... yes it's me taz
        // else if (!email.getText().matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}")){
        //     terms.setText("Incorrect Email");
        // }
         else if (phone.getText().equals(""))
        {   terms.setText("name is empty");  }
         
          else if (pass.getText().equals(""))
        {   terms.setText("mot de passe est vide");  }
         
           
         else if (pass1.getText().equals(""))
        {   terms.setText("repeter mot de passe est vide");  }
         
          else if (!pass1.getText().equals(pass.getText()))
        {   terms.setText("mot de passe n'est pas compatible");  }
        
                  else if (!conditions.isSelected()){
                   terms.setText("accept the terms");}

          
          else if (conditions.isSelected()){
                   prs.executeUpdate();
              Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_connexion1.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
          }
          
          }
              
     @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }
    
     @FXML
     private void retour(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_connexion1.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
        
    }

    @FXML
    private void resetAll(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_register.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    }
    // Dear oussama , one day i will put gun in ur head :) :) 
    private boolean validateEmaill(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email.getText());
        if(m.find() && m.group().equals(email.getText())){
            return true;
        }else{
            return false;            
        }
    }
    
    
}
