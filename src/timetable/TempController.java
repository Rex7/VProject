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


public class TempController implements Initializable {

    @FXML
    Pane secondPane;
    private String myData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public TempController() {

    }

    public void setText(String data) throws IOException {
        Pane newLoadedPane;
        this.myData = data;
        System.out.println("Data " + data);
        switch (myData) {
            case "addUser":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                break;
            case "addData":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("add.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                break;
            case "generate":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("tt.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                break;
            case "timetable":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("tt1.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                break;
            case "delete":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("modify.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                break;
                

        }
    }

    public void ButtonClicked(ActionEvent evt) throws IOException {

        Pane newLoadedPane;

        JFXButton button = (JFXButton) evt.getSource();
        String text = button.getText();
        System.out.println("Text " + button.getId());
        switch (button.getId()) {
            case "AddUser":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
                secondPane.getChildren().add(newLoadedPane);
               
                break;
            case "AddData":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("add.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                JFXButton my=(JFXButton)evt.getSource();
               
                
                break;
            case "Generate":
                 secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("tt.fxml"));
                secondPane.getChildren().add(newLoadedPane);
               ;
                break;
            case "Timetable":
                secondPane.getChildren().clear();
                newLoadedPane = FXMLLoader.load(getClass().getResource("tt1.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                break;
            case "ViewData":
                secondPane.getChildren().clear();

                break;
            case "delete":
                secondPane.getChildren().clear();
                    newLoadedPane = FXMLLoader.load(getClass().getResource("Modify.fxml"));
                secondPane.getChildren().add(newLoadedPane);
                break;
            case "logout":
                Parent parent = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                Scene second = new Scene(parent);
                Stage app_Start = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                app_Start.setScene(second);
                app_Start.show();
                break;

        }

    }

}
