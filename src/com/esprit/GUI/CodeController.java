/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.utils.DataSource;
import com.twilio.type.PhoneNumber;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.mindrot.jbcrypt.BCrypt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CodeController implements Initializable {

    @FXML
    private TextField mailid;
    @FXML
    private Button btnid;
 MediaPlayer mediaplayer;
    @FXML
    private MediaView mv;
     @FXML
    private Circle btnClose;

   
   private DataSource cnx;
    public ResultSet rs;
    public int x;
    public String y,z;
    public String username,pass,mesg,email,code;

    Stage stage= new Stage();
    @FXML
    private Label remarque;
        public static final String ACCOUNT_SID = "ACc98bb8185a79cdc4f764686910fad80c";
    public static final String AUTH_TOKEN = "d7f4a4837830f879a62fb17027b0df3f";
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          String VUrl = getClass().getResource("/image/gif.mp4").toExternalForm();
        Media media = new Media(VUrl);
        mediaplayer = new MediaPlayer(media);
        mv.setMediaPlayer(mediaplayer);
        mediaplayer.play();
    
    }  
    
 public void setEmail(String email) {
        this.email = email;
    }
 
  public void setCode(String code) {
        this.code = code;
        System.out.println("====>"+code);
    }

    
    @FXML
    private void SendMail(ActionEvent event) throws AddressException, MessagingException, SQLException, IOException  {
        System.out.println(this.code);

        if( mailid.getText().equals(this.code)    )
        {
            
          Connection conn = DataSource.getInstance().getCnx();
          String req= "Select username,password from fos_user where email=? ";
          PreparedStatement prs= conn.prepareStatement(req);
          prs.setString(1, this.email);
          rs= prs.executeQuery();
          while (rs.next()){
                 username= rs.getString("username");
                //pass=rs.getString("password").substring(0,2)+"a"+rs.getString("password").substring(3);
                 //pass=rs.getString("password");
                 pass=hashpw(rs.getString("password"),rs.getString("password").substring(0,2)+"a"+rs.getString("password").substring(3));
          }

          mesg="votre nom d'utilisateur: "+username+"\n"+"votre mode de pass: "+pass; ;
          
          
       String from ="huntkingdom2020@gmail.com";
       String pass="96921774";
       String [] to={this.email};
       String host="mail.javatpoint.com";
       String sub="Password Recovery";
       
        Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(from,pass);
    }
}); 
          //compose message                
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(this.email));    
           message.setSubject(sub);    
           message.setText(mesg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");  
          com.twilio.rest.api.v2010.account.Message messages = com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21696921774"),
        new PhoneNumber("+13347593893"), mesg).create();
            
 
        Node node =(Node)event.getSource();
            stage = (Stage)node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_connexion1.fxml")));
            stage.setScene(scene);
            stage.show();

           
           
    }
        else { remarque.setText("Code Invalide");}
    }
 @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }

    @FXML
    private void exit(MouseEvent event) {
                            Node node =(Node)event.getSource();
            stage = (Stage)node.getScene().getWindow();
            stage.close();
    }
    
    
    
}
