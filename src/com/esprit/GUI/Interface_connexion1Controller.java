/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Core.Controller;
import com.esprit.models.Personne;
import com.esprit.services.LoginService;
import com.esprit.services.ServicePersonne;
import com.esprit.utils.DataSource;
import com.goxr3plus.fxborderlessscene.application.Main;
import com.goxr3plus.fxborderlessscene.borderless.BorderlessScene;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import static org.omg.CORBA.ORB.init;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Interface_connexion1Controller implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Label msg;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox remember;
    private final String path="src\\LoginData.ini";
    LoginService loginService = new LoginService();
    int x;
    Stage stage= new Stage();
    ServicePersonne ser = new ServicePersonne();
    private Hyperlink forgot_pass;
    Scene scene;
    
    
    	private BorderlessScene borderlessScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       loginService.readinifile(path,email,password,remember);
    }    

    @FXML
    private void Connecter(ActionEvent event) throws SQLException, IOException {
              
          
        //ya imin ya isar mahabetch -_- 
           if(ser.getUserByuserName(email.getText()).getRoles().equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Admin_Dashboard.fxml"));   
            Scene scene = new Scene(root);
             Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
     
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            return;
        }
       
        
        Connection conn = DataSource.getInstance().getCnx();
        String req= "Select * from fos_user where (username=? or email=?)";
        PreparedStatement prs= conn.prepareStatement(req);
        prs.setString(1, email.getText());
        prs.setString(2, email.getText());
        ResultSet rs = prs.executeQuery();
        if (!rs.next()){
            msg.setText("Username incorrect");
        } 
        
        else {
            if(BCrypt.checkpw(password.getText(),rs.getString("password").substring(0,2)+"a"+rs.getString("password").substring(3)))
            {
       if (!remember.isSelected()){
                String req1= "Select id from fos_user where username=? ";
                PreparedStatement prs1= conn.prepareStatement(req1);
                prs.setString(1, email.getText());
                ResultSet res= prs.executeQuery();
                while (res.next()){
                 x= res.getInt("id");       
                }
                Personne user= new Personne();
                user.setId(x);
                Controller.setUserId(x);
              
                init();
                Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));   
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);          

            }
            else {
               
                loginService.createiniFile(path,email.getText(),password.getText());
                System.out.println("success");           
                String req1= "Select id from fos_user where username=? ";
                PreparedStatement prs1= conn.prepareStatement(req1);
                prs.setString(1, email.getText());
                ResultSet res= prs.executeQuery();
                while (res.next()){
                    x= res.getInt("id");
                } 
                Personne user= new Personne();
                Controller.setUserId(x);
            
                init();
                Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));  
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
                
            }
            }
            else
            {
                msg.setText("Mot de passe incorrecte!");
            }
        }   }  
    
        
        
        
        
        
      
       // String s = email.getText();
      // String m = password.getText();
       
       //Statement statement = null;
      // ResultSet resultSet = null;
    //   DataSource Ds = DataSource.getInstance();
    //   Connection cnx = Ds.getCnx();
       
      // 
      // try {
        //  statement = cnx.createStatement();
          //  String sql = "SELECT * FROM fos_user WHERE username = '" + s + "' AND password = '" + m + "' ;";
         //   resultSet = statement.executeQuery(sql);

           // if (resultSet.next()) {

                // System.out.println(stat);

             //       Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_Acceuil2.fxml"));
               //     Scene scene = new Scene(root);
                 //   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                 //   stage.hide();
                //    stage.setScene(scene);
                  //  stage.show();
        
//    }
            
            
         //   else {
             
           //                             JOptionPane.showMessageDialog(null, "non succée");

           // }
            
            
       // }
       // catch (SQLException e) {
       //     e.printStackTrace();
       // }

    
 
            
    @FXML
    private void Register(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_register.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.hide();
                    stage.setScene(scene);
                    stage.show();
        
        
        
        
    }
    
    
    public BorderlessScene getBorderlessScene() {
		return borderlessScene;
	}

	/**
	 * @param borderlessScene the borderlessScene to set
	 */
	public void setBorderlessScene(BorderlessScene borderlessScene) {
		this.borderlessScene = borderlessScene;
	}
    
        
        public void initActions() {

		
	}
        private void sendmail(ActionEvent event) throws IOException {
        Node node =(Node)event.getSource();
        stage = (Stage)node.getScene().getWindow();
        stage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("/com/esprit/GUI/forgotPass.fxml")));
        stage.setScene(scene);
        stage.show();
    }
    
}
