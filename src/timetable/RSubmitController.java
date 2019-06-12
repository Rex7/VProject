/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import timetable.doa.RoomDoa;
import timetable.doa.SubjectDoa;
import timetable.model.Room;
import timetable.model.Subject;


public class RSubmitController implements Initializable {
    private int myId=89;
    private Room room;
@FXML
private JFXTextField subjectName;
@FXML
      private JFXButton AddSubmit;
 
 static   Subject sub=new Subject();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void setId(Room  myRoom){
      
        System.out.println(" whats"+myRoom.getRname());
        System.out.println("room "+myRoom.getCandl());
        int i=new RoomDoa().getRoomId(myRoom);
         System.out.println("id "+i);
         this.myId=i;
         this.room=myRoom;
         System.out.println(" room name "+myRoom.getRname());
         
    sub.setRid(i);
    sub.setRsub(subjectName.getText());
    
    }
    public void submit(ActionEvent evt){
        System.out.println("subjetc Name "+sub.getRsub());
        System.out.println("subject "+subjectName.getText());
        System.out.println("subject Id in submit method "+sub.getRid());
        SubjectDoa subjectDoa=new SubjectDoa();
        Subject my=new Subject();
        my.setRid(sub.getRid());
        my.setRsub(subjectName.getText());
        subjectDoa.save(my);
        
    }
    
  
    
}
