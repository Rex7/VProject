/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import timetable.doa.teacherDoa;
import timetable.model.teacherSub;

public class Subject2Controller  implements Initializable{
    @FXML
    JFXTextField subjectName,semister,optional,lectureHour,practicalHours;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    public void submitMyRecord(ActionEvent evt){
        teacherSub sub=new teacherSub();
        sub.setSubject(subjectName.getText());
        sub.setLectureHour(Integer.parseInt(lectureHour.getText()));
        sub.setPracticalHour(Integer.parseInt(practicalHours.getText()));
        sub.setOptional(Integer.parseInt(optional.getText()));
        teacherDoa doa=new teacherDoa();
       boolean flag= doa.saveMyTeacher(sub);
        System.out.println("flag "+flag);
        
        
        
    }
    
}
