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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ModulesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void buttonAction(ActionEvent evt) throws IOException {
        Parent parent;
        Stage app_Start;
        Scene second;
        FXMLLoader loader;
        TempController controller;

        JFXButton button = (JFXButton) evt.getSource();
        String text = button.getText();
        System.out.println("Text " + button.getId());
        switch (button.getId()) {
            case "addUser":
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("temp.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    System.out.println("Exception thrown");
                }
                controller = loader.getController();
                controller.setText("addUser");
                parent = loader.getRoot();
                second = new Scene(parent);
                app_Start = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                app_Start.setScene(second);
                app_Start.show();

                break;
            case "addData":

                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("temp.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    System.out.println("Exception thrown");
                }
                controller = loader.getController();
                controller.setText("addData");
                parent = loader.getRoot();
                second = new Scene(parent);
                app_Start = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                app_Start.setScene(second);
                app_Start.show();

                break;
            case "generate":

                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("temp.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    System.out.println("Exception thrown");
                }
                controller = loader.getController();
                controller.setText("generate");
                parent = loader.getRoot();
                second = new Scene(parent);
                app_Start = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                app_Start.setScene(second);
                app_Start.show();

                break;
            case "timetable":
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("temp.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    System.out.println("Exception thrown");
                }
                controller = loader.getController();
                controller.setText("generate");
                parent = loader.getRoot();
                second = new Scene(parent);
                app_Start = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                app_Start.setScene(second);
                app_Start.show();
                break;

            case "delete":

                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("temp.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    System.out.println("Exception thrown");
                }
                controller = loader.getController();
                controller.setText("delete");
                parent = loader.getRoot();
                second = new Scene(parent);
                app_Start = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                app_Start.setScene(second);
                app_Start.show();
               

                break;

        }
    }
}
