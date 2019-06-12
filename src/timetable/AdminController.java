/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import timetable.doa.UserDoa;


public class AdminController implements Initializable {

 @FXML
 private JFXTextField uname1;
 @FXML
 private JFXPasswordField password;
    UserDoa userDoa;
    public AdminController(){
    userDoa=new UserDoa();
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    public void Submit(ActionEvent evt) throws IOException{
        
        System.out.println(uname1.getText());
        System.out.println("password "+password.getText());
        boolean flag=userDoa.getUser(uname1.getText(),password.getText());//mano,mano123
        System.out.println("Login successful : "+flag);
        if(flag==true){
         Parent parent =FXMLLoader.load(getClass().getResource("modules.fxml"));
        Scene second =new Scene(parent);
        Stage app_Start=(Stage) ((Node)evt.getSource()).getScene().getWindow();
        app_Start.setScene(second);
        app_Start.show();
        }
        else{
        
        }
    }
}
