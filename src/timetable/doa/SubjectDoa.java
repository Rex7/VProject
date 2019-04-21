/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import timetable.datalayer.DatabaseConnection;
import timetable.model.Subject;

/**
 *
 * @author Regis charles
 */
public class SubjectDoa implements subjectInterface {

    @Override
    public boolean save(Subject subject) {
    Connection connection =DatabaseConnection.getConnection();
         try{
   PreparedStatement pst =connection.prepareStatement("insert into rsub (rid,rsub) values(?,?)");
   pst.setInt(1, subject.getRid());
   pst.setString(2, subject.getRsub());
    
   
 
   int status=pst.executeUpdate();
             System.out.println("inside subject doa "+subject.getRid());
   if(status==1){
   return true;
   }
   }
   catch(SQLException ex){
       System.out.println(" ex "+ex.getMessage());
   }
       return false;
    }
    
}
