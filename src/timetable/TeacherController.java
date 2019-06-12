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
import timetable.doa.teacherDoa;
import timetable.model.Teacher;


public class TeacherController implements Initializable {

  @FXML
  JFXTextField initials;
    @FXML
    private Pane secondPane;
      FXMLLoader loader;
      SubjectController controller;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void submit(ActionEvent evt) throws IOException{
        System.out.println("initials "+initials.getText());
        Pane newLoadedPane;     
            newLoadedPane = FXMLLoader.load(getClass().getResource("subject.fxml"));
            secondPane.getChildren().add(newLoadedPane);
             loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("subject.fxml"));
                try {
                    loader.load();
                       teacherDoa teach=new teacherDoa();
           Teacher teacher =new Teacher();
           teacher.setInit(initials.getText());
           boolean flag=teach.save(teacher);
                      controller = loader.getController();
                         int i=teach.getTeacherId(teacher);
                          System.out.println("Id of teacher is "+i);
                controller.setId(i);
                } catch (IOException ex) {
                    System.out.println("Exception thrown");
                }
           
    }
}
