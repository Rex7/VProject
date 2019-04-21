/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Regis charles
 */
public class TeacherController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane secondPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void submit(ActionEvent evt) throws IOException{
        Pane newLoadedPane;
      secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("subject.fxml"));
                secondPane.getChildren().add(newLoadedPane);
    }
}
