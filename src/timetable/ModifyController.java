/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import timetable.doa.BaseDoa;

/**
 * FXML Controller class
 *
 * @author Regis charles
 */
public class ModifyController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     */
    @FXML
     JFXTextField   inputText;
     @FXML
 private ChoiceBox categoryModify;
   
    @Override
     public void initialize(URL url, ResourceBundle rb) {
       categoryModify.setItems(FXCollections.observableArrayList("admin","room","teacher"));
    }    
    public void buttonClicked(ActionEvent evt){
        System.out.println("value "+inputText.getText());
        System.out.println("category "+categoryModify.getValue());
        BaseDoa doa=new BaseDoa();
        doa.del(inputText.getText().trim(),categoryModify.getValue().toString());
    }
    
}
