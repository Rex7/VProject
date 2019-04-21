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
import timetable.doa.RoomDoa;
import timetable.doa.SubjectDoa;
import timetable.model.Room;
import timetable.model.Subject;

/**
 * FXML Controller class
 *
 * @author Regis charles
 */
public class RSubmitController implements Initializable {
    private int myId=89;
    private Room room;
@FXML
private JFXTextField subjectName;
 
    Subject sub=new Subject();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void setId(Room  room){
      
        System.out.println(" whats"+room.getRname());
        System.out.println("room "+room.getCandl());
        int i=new RoomDoa().getRoomId(room);
         System.out.println("id "+i);
         this.myId=i;
         this.room=room;
    sub.setRid(i);
    sub.setRsub(subjectName.getText());
    }
    
    public void submit(ActionEvent evt){
       
  
    SubjectDoa doa=new SubjectDoa();
        System.out.println("subject data "+myId);
         System.out.println("room  "+room.getRname());
          System.out.println("room  "+room.getCandl());
    boolean flag=doa.save(sub);
        System.out.println("operation "+flag);
    }
    
}
