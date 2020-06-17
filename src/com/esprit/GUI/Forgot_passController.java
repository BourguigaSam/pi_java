/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;


import com.esprit.GUI.CodeController;
import com.esprit.utils.DataSource;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Forgot_passController implements Initializable {

    
    private DataSource cnx;
    public ResultSet rs;
    public int x;
    public String y,z;
    public String username,pass,mesg;
    Scene scene;
    Stage stage= new Stage();
    MediaPlayer mediaplayer;
    @FXML
    private MediaView mv;
    @FXML
    private Circle btnClose;
    @FXML
    private TextField mailid;
    @FXML
    private Button btnid;
    @FXML
    private Label label;
    @FXML
    private Label exit;

        public static final String ACCOUNT_SID = "ACc98bb8185a79cdc4f764686910fad80c";
    public static final String AUTH_TOKEN = "1dd8dcb6bcaa2644e88d120c3f0b68bd";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String VUrl = getClass().getResource("/image/password-reset-password-safety.mp4").toExternalForm();
        Media media = new Media(VUrl);
        mediaplayer = new MediaPlayer(media);
        mv.setMediaPlayer(mediaplayer);
        mediaplayer.play();
    }    

    @FXML
    private void OnClick_btn_play(){
        if(mediaplayer.getStatus()==PLAYING){
        mediaplayer.pause();
        }else {
        mediaplayer.play();
        
        }
    
    }
    @FXML
    private void handleMouseEvenet(MouseEvent event){
        if (event.getSource() == btnClose){
            System.exit(0);
        }
    }
    

    @FXML
    private void SendMail(ActionEvent event) throws SQLException, AddressException, MessagingException, IOException {
        if (mailid.getText().isEmpty()){ label.setText("remarque : email vide");  }
        else {
          Connection conn = DataSource.getInstance().getCnx();
          String req= "Select username,password from fos_user where email=? ";
          PreparedStatement prs= conn.prepareStatement(req);
          prs.setString(1, mailid.getText());
          rs= prs.executeQuery();
          while (rs.next()){
                 username= rs.getString("username");
                 pass=rs.getString("password");
          }
          y = getSaltString();
          z = mailid.getText();
          mesg="votre code est : " + y;
          
          
              Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

      com.twilio.rest.api.v2010.account.Message messages = com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+216 96 921 774"),
        new PhoneNumber("+13347593893"), y).create();
          
       String from ="huntkingdom2020@gmail.com";
       String pass="96921774";
       String [] to={mailid.getText()};
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
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailid.getText()));    
           message.setSubject(sub);    
           message.setText(mesg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");  
           mediaplayer.stop();
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/esprit/GUI/Code.fxml"));
            Parent root= loader.load();
            CodeController ccc = loader.getController();
            ccc.setEmail(z);
            ccc.setCode(y);
            mailid.getScene().setRoot(root);
           
           
    }

    }

        protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

   @FXML
    private void exit(MouseEvent event) throws IOException {
        Node node =(Node)event.getSource();
        stage = (Stage)node.getScene().getWindow();
        stage.close();
                   //mediaplayer.stop();

        scene = new Scene(FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_connexion1.fxml")));
        stage.setScene(scene);
        stage.show();

            
    }
    
    
}











   

    
