/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import timetable.datalayer.DatabaseConnection;
import timetable.model.Room;
import timetable.model.Teacher;
import timetable.model.TeacherSubject;
import timetable.model.teacherSub;

/**
 *
 * @author Regis charles
 */
public class teacherDoa implements teacherIni{

    //@Override
    public boolean save(Teacher teacher) {
   Connection connection =DatabaseConnection.getConnection();
   try{
   PreparedStatement pst =connection.prepareStatement("insert into teacher (tname) values(?)");
   pst.setString(1, teacher.getInit());

  
   int status=pst.executeUpdate();
     System.out.println("status");
   if(status==1){
     
   return true;
   }
   }
   catch(SQLException ex){
       System.out.println("error "+ex.getMessage());
   
   }
       
    
    return false;
    }
     //@Override
    public int getTeacherId(Teacher teacher) {
        int id;
        Connection connection =DatabaseConnection.getConnection();
         try{
           PreparedStatement pst=connection.prepareStatement("select * from teacher where tname=?");
           pst.setString(1, teacher.getInit());
          
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               id=rs.getInt("tid");
               return id;
           }
       }
       catch(Exception ex){
           System.out.println(" exception"+ex);
       }
        return 0;
    }

    //@Override
    public boolean saveTeacher(TeacherSubject teacherSubject) {
    Connection connection =DatabaseConnection.getConnection();
   try{
   PreparedStatement pst =connection.prepareStatement("insert into tsub (tid,tsub,lhours,phours) values(?,?,?,?)");
pst.setInt(1, teacherSubject.getTeacherId());
pst.setString(2, teacherSubject.getTeacherSubject());
pst.setString(3, teacherSubject.getLectureHours());
pst.setString(4, teacherSubject.getPracticalHours());



  
   int status=pst.executeUpdate();
     System.out.println("status");
   if(status==1){
     
   return true;
   }
   }
   catch(SQLException ex){
       System.out.println("error "+ex.getMessage());
   
   }
       
    
    return false;
    }

    //@Override
    public boolean saveMyTeacher(teacherSub sub) {
       Connection connection =DatabaseConnection.getConnection();
   try{
   PreparedStatement pst =connection.prepareStatement("insert into subject (sname,lhours,phours,sem,opt) values(?,?,?,?,?)");
   pst.setString(1, sub.getSubject());
   pst.setInt(2, sub.getLectureHour());
   pst.setInt(3, sub.getPracticalHour());
   pst.setInt(4, sub.getSemister());
   pst.setInt(5, sub.getOptional());

  
   int status=pst.executeUpdate();
     System.out.println("status");
   if(status==1){
     
   return true;
   }
   }
   catch(SQLException ex){
       System.out.println("error "+ex.getMessage());
   
   }
       
    
    return false;
    }
    
    
}
