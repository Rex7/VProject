/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import timetable.doa.RoomDoa;
import timetable.model.Room;


public class RoomController implements Initializable {

    @FXML
    Pane secondPane;
    @FXML
    private JFXTextField roomNo, cl;
     FXMLLoader loader;
        RSubmitController controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void submit(ActionEvent evt) throws IOException {
        
        Room room = new Room();
        room.setRname(roomNo.getText());
        room.setCandl(Integer.parseInt(cl.getText()));
        RoomDoa doa = new RoomDoa();
        Pane newLoadedPane;
        boolean flag = doa.save(room);
        System.out.println("flag " + flag);
        int no = Integer.parseInt(cl.getText());

        if (no == 1) {
            secondPane.getChildren().clear();
            newLoadedPane = FXMLLoader.load(getClass().getResource("rSubmit.fxml"));
            secondPane.getChildren().add(newLoadedPane);
            
            int i = doa.getRoomId(room);
            System.out.println(" my id " + i);
               loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("rSubmit.fxml"));
                try {
                    loader.load();
                      controller = loader.getController();
                controller.setId(room);
                } catch (IOException ex) {
                    System.out.println("Exception thrown");
                }
              
            
        } else {

        }
        if (flag == true) {
            System.out.println("done");
        } else {
            System.out.println("not done");
        }

    }

}
