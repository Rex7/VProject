/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. asas
 */
package timetable.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import timetable.datalayer.DatabaseConnection;

/**
 *
 * @author Regis charles
 */
public class BaseDoa implements baseDoaInterface{

    @Override
    public void del(String id,String category) {
Connection connection =DatabaseConnection.getConnection();
   PreparedStatement pst = null;
   try{
switch(category){
    case "admin":
     pst    =connection.prepareStatement("delete from "+category+" where  username=?");
  
   pst.setString(1, id);
     break;
    case "teacher":
     pst    =connection.prepareStatement("delete from "+category+" where  tname=?");
 
   pst.setString(1, id);
   break;
    case "room":
     pst    =connection.prepareStatement("delete from "+category+" where  rname=?");
 
   pst.setString(1, id);
   break;
     
}
   
   
   int update=pst.executeUpdate();
       System.out.println("deleted "+update);
   
   
   }
   catch(SQLException ex){
       System.out.println("error "+ex.getMessage());
   
   }
       
    
    

    }
   
    
    
}
