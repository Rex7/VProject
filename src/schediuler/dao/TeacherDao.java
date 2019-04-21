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
public class TeacherDao implements TeacherInterface {
    int l1;
    public ArrayList[][] teacharr = new ArrayList[60][2];
    public ArrayList[][] tsubarr = new ArrayList[90][5];
    public void teacherecord() {
        int i,j;
       
        for(i=0;i<60;i++)
            for(j=0;j<2;j++)
            {
                teacharr[i][j] = new ArrayList();
            }
        for(i=0;i<90;i++)
            for(j=0;j<5;j++)
            {
                tsubarr[i][j] =new ArrayList();
            }
       Connection connection=DatabaseConnection.getConnection();
       try{
           PreparedStatement pst=connection.prepareStatement("select * from teacher");
           ResultSet rts=pst.executeQuery();
           i=0;
           while(rts.next()){
               teacharr[i][0].add(rts.getString("tid"));
               teacharr[i][1].add(rts.getString("tname"));
               i++;
               
           }
            PreparedStatement ptsub=connection.prepareStatement("select * from tsub");
           ResultSet rtss=ptsub.executeQuery();
           i=0;
           while(rtss.next()){
               tsubarr[i][0].add(rtss.getString("tsid"));
               tsubarr[i][1].add(rtss.getString("tid"));
               tsubarr[i][2].add(rtss.getString("tsub"));
               tsubarr[i][3].add(Integer.parseInt(rtss.getString("lhours")));
               tsubarr[i][4].add(Integer.parseInt(rtss.getString("phours")));
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
        
        for (int i = l1-1; i > 0; i--) { 
            int j = r.nextInt(i+1); 
            for(int k=0;k<5;k++)
            {
               
            tsubarr[l1][k].add(tsubarr[i][k].get(0)); 
            tsubarr[i][k].set(0,tsubarr[j][k].get(0)); 
            tsubarr[j][k].set(0,tsubarr[l1][k].get(0)); 
             tsubarr[l1][k].remove(0);
            } 
        }
    }
         
    
}
































    

