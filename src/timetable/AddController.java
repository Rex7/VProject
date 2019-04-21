/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Regis charles
 */
public class AddController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane secondPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    public void submitLogin(ActionEvent evt) throws IOException{
   JFXButton button=(JFXButton) evt.getSource();
   
   
     Pane newLoadedPane;
   switch(button.getId()){
       case "teacher":
        secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("teacher.fxml"));
                secondPane.getChildren().add(newLoadedPane);
           break;
       case"room" :
           secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("room.fxml"));
                secondPane.getChildren().add(newLoadedPane);
           break;
       case"subject":
             secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("subject.fxml"));
                secondPane.getChildren().add(newLoadedPane);
           break;
       case "department":
            secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("department.fxml"));
                secondPane.getChildren().add(newLoadedPane);
           break;
   
   }
    }
    
}
