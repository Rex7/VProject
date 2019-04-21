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

/**
 *
 * @author kamal
 */
public class RoomDoa implements roomINterface {

    @Override
    public void getAllRecord() {
       Connection connection=DatabaseConnection.getConnection();
       try{
           PreparedStatement pst=connection.prepareStatement("select * from Room");
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               System.out.println("data"+rs.getString("rid"));
               System.out.println("data "+rs.getString("rname"));
           }
       }
       catch(Exception ex){
           System.out.println(" exception"+ex);
       }
       


    }

    @Override
    public boolean save(Room room) {
        Connection connection =DatabaseConnection.getConnection();
   try{
   PreparedStatement pst =connection.prepareStatement("insert into room (rname,`C/L`) values(?,?)");
   pst.setString(1, room.getRname());
   pst.setInt(2, room.getCandl());
  
   int status=pst.executeUpdate();
   if(status==1){
   return true;
   }
   }
   catch(SQLException ex){
       System.out.println("error "+ex.getMessage());
   
   }
       
    
    return false;
    }

    @Override
    public int getRoomId(Room room) {
        int id;
        Connection connection =DatabaseConnection.getConnection();
         try{
           PreparedStatement pst=connection.prepareStatement("select * from Room where rname=? and `C/L`=?");
           pst.setString(1, room.getRname());
           pst.setInt(2,room.getCandl());
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               id=rs.getInt("rid");
               return id;
           }
       }
       catch(Exception ex){
           System.out.println(" exception"+ex);
       }
        return 0;
    }
    
}
