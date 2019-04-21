/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.Vector;

public class Chromosome 
{    
    Vector<Slot[][]> t = new Vector<>();
        Slot[][] s2a = new Slot[12][5];
        Slot[][] s2b = new Slot[12][5];
        Slot[][] s4a = new Slot[12][5];
        Slot[][] s4b = new Slot[12][5];
        Slot[][] s4c = new Slot[12][5];
        Slot[][] s6a = new Slot[12][5];
        Slot[][] s6b = new Slot[12][5];
        Slot[][] s6c = new Slot[12][5];
        Slot[][] s8a = new Slot[12][5];
        Slot[][] s8b = new Slot[12][5];
        Slot[][] s8c = new Slot[12][5];
public void cinit()
    {
        int i,j;
        for(i=0;i<=11;i++)
            for(j=0;j<=4;j++)
            {
            s2a[i][j]= new Slot();
            s2b[i][j]= new Slot();
            s4a[i][j]= new Slot();
            s4b[i][j]= new Slot();
            s4c[i][j]= new Slot();
            s6a[i][j]= new Slot();
            s6b[i][j]= new Slot();
            s6c[i][j]= new Slot();
            s8a[i][j]= new Slot();
            s8b[i][j]= new Slot();
            s8c[i][j]= new Slot();
            }
        t.add(s2a);
        t.add(s2b);
        t.add(s4a);
        t.add(s4b);
        t.add(s4c);
        t.add(s6a);
        t.add(s6b);
        t.add(s6c);
        t.add(s8a);
        t.add(s8b);
        t.add(s8c);
    }
class Slot {
      String[] teacher = new String[4];
      String[] subject = new String[4];
      String[] room = new String[4];
      String prac = new String();
      
      public Slot()
      {
          for(int i=0;i<4;i++)
          {
              teacher[i]=" ";
              subject[i]=" ";
              room[i]=" ";
          }
      }
}    
}