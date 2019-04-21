/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.doa;


/**
 *
 * @author Regis charles
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import timetable.model.User;
import java.util.List;
import timetable.datalayer.DatabaseConnection;

public class UserDoa implements doaInterface  {
  
    @Override
    public boolean save(User user){
   Connection connection =DatabaseConnection.getConnection();
   try{
   PreparedStatement pst =connection.prepareStatement("insert into admin (username,password,category,name) values(?,?,?,?)");
   pst.setString(1, user.getUsername());
   pst.setString(2,user.getPassword());
   pst.setString(3,user.getCategory() );
   pst.setString(4, user.getName());
   int status=pst.executeUpdate();
   if(status==1){
   return true;
   }
   }
   catch(SQLException ex){}
       return false;
    }

   

  

    @Override
    public void delete(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllRecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getUser(String username, String password) {
     Connection connection = DatabaseConnection.getConnection();
    try {
      
        PreparedStatement pst=connection.prepareStatement("SELECT * FROM admin WHERE username=? and password=?");
       pst.setString(1,username);
       pst.setString(2, password);
       ResultSet rs=pst.executeQuery();
        if(rs.next())
        {
           return true;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
    }
    
}
