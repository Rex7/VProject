/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schediuler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import schediuler.datalayer.DatabaseConnection;
import schediuler.model.Room;

/**
 *
 * @author kamal
 */
public class RoomDao implements RoomInterface 
{
    int l1,l2;
public ArrayList<String>[][] roomarr = new ArrayList[100][3];//room data array 
public ArrayList<String>[][] rsubarr = new ArrayList[100][3];//room subj array*
@Override
    public void getAllrecord() {
        int i,j;
        for(i=0;i<100;i++)
            for(j=0;j<3;j++)
            {
                roomarr[i][j] = new ArrayList<>();
                rsubarr[i][j] =new ArrayList<>();
            }
       Connection connection=DatabaseConnection.getConnection();
       try{
           PreparedStatement pst=connection.prepareStatement("select * from Room");
           ResultSet rs=pst.executeQuery();
           i=0;
           while(rs.next()){
               roomarr[i][0].add(rs.getString("rid"));
               roomarr[i][1].add(rs.getString("rname"));
               roomarr[i][2].add(rs.getString("C/L"));
               i++;
               
           }
           l1=i;
            PreparedStatement prsub=connection.prepareStatement("select * from rsub");
           ResultSet rrs=prsub.executeQuery();
           i=0;
           while(rrs.next()){
               rsubarr[i][0].add(rrs.getString("rsid"));
               rsubarr[i][1].add(rrs.getString("rid"));
               rsubarr[i][2].add(rrs.getString("rsub").toLowerCase());
               i++;
               }
           l2=i;
       }
       
       catch(Exception ex){
           System.out.println(" exception"+ex);
       }
       finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SubjectDao.class.getName()).log(Level.SEVERE, null, ex);
            }
       
      }
       randomize();
    }

    public  void randomize() //Fisher yates algo
    { 
        String temp;
        Random r = new Random(); 
        
        for (int i = l2-1; i > 0; i--)//30
        { 
            int j = r.nextInt(i+1); //4
            for(int k=0;k<3;k++)
            {
            temp = rsubarr[i][k].get(0); 
            rsubarr[i][k].set(0,rsubarr[j][k].get(0)); 
            rsubarr[j][k].set(0,temp); 
            } 
        }
         
    } 
    
    
}
