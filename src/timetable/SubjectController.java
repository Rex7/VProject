/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXTextField;
import static java.lang.System.out;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import timetable.doa.teacherDoa;
import timetable.model.TeacherSubject;


public class SubjectController implements Initializable {
@FXML

JFXTextField practicals,lecture,subjectName;
   static int id;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
    public void submitAction(ActionEvent evt){
        System.out.println(" practicals "+practicals.getText()+"lectureHours "+lecture.getText());
        
        
        
    }
    
        public void setId(int i){
     id=i;
      
    
    }
        public void submitMyRecord(ActionEvent evt){
            TeacherSubject subject=new TeacherSubject();
            subject.setLectureHours(lecture.getText());
            subject.setPracticalHours(practicals.getText());
            subject.setTeacherId(id);
            subject.setTeacherSubject(subjectName.getText());
           teacherDoa teac=new teacherDoa();
      boolean flag=     teac.saveTeacher(subject);
            System.out.println("id is "+id);
            System.out.println("flag "+flag);
        }
    
}
