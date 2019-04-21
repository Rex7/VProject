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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import schediuler.datalayer.DatabaseConnection;

/**
 * 
 * @author kamal
 */
public class SubjectDao implements SubjectInterface
{   int l1;
    public ArrayList[][] subarr = new ArrayList[50][6];
    @Override
    public void sub(){
        int i,j;
        
        for(i=0;i<50;i++)
            for(j=0;j<6;j++)
            subarr[i][j] = new ArrayList<>();
        
    Connection connection=DatabaseConnection.getConnection();
       try{
           PreparedStatement pst=connection.prepareStatement("select * from subject");
           ResultSet rs=pst.executeQuery();
           i=0;
           while(rs.next()){
               subarr[i][0].add(rs.getString("sid"));
               subarr[i][1].add(rs.getString("sname"));
               subarr[i][2].add(Integer.parseInt(rs.getString("lhours")));
               subarr[i][3].add(Integer.parseInt(rs.getString("phours")));
               subarr[i][4].add(rs.getString("sem"));
               subarr[i][5].add(Integer.parseInt(rs.getString("opt")));
               i++;
           }
           l1=i;
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
    public  void randomize() 
    { 
        
        Random r = new Random(); 
        
        for (int i = l1-1; i >= 0; i--) { 
            int j = r.nextInt(i+1); 
            for(int k=0;k<6;k++)
            {
            subarr[l1][k].add(subarr[i][k].get(0)); 
            subarr[i][k].set(0,subarr[j][k].get(0)); 
            subarr[j][k].set(0,subarr[l1][k].get(0)); 
            subarr[l1][k].remove(0);
            } 
        }
    }
         
}