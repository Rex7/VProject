/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import timetable.doa.UserDoa;
import timetable.model.User;

/**
 * FXML Controller class
 *
 * @author Regis charles
 */
public class AddUserController implements Initializable {

 @FXML
 private JFXTextField name,username;//password,confirmPassword;
 @FXML
 private ChoiceBox category;
 @FXML
 JFXPasswordField password,confirmPassword;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       category.setItems(FXCollections.observableArrayList("admin","student","teacher"));
     
    } 
    public void register(ActionEvent evt){
    UserDoa userDoa = new UserDoa();
    User user = new User();
    user.setUsername(username.getText());
    user.setPassword(password.getText());
       
    user.setCategory((String) category.getValue());
    user.setName(name.getText());
   boolean flag= userDoa.save(user);
   if(flag){
   name.setText(" ");
    username.setText(" ");
     password.setText(" ");
      confirmPassword.setText(" "); category.getSelectionModel().clearSelection();
      
   }
        System.out.println("Operation successful : "+flag);
    
    }
    
}
