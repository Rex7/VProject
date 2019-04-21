/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.Random;

/**
 *
 * @author kamal
 */
public class Crossover {
     public Initialization Crossovers(Initialization I1,Initialization I2,Initialization I3)
   {
      
        int k,x,i,j;
        //Random r = new Random();
        x=5;
        for(k=0;k<x;k++)
            {
                for(i=0;i<8;i++)
                    {
                        for(j=0;j<5;j++)
                        {   
                            I3.C.t.get(k)[i][j]=I1.C.t.get(k)[i][j];//I3.C.t.set(k,I1.C.t.get(k));
                        }
                    }
            }
        for(k=x;k<11;k++)
            {
            for(i=0;i<8;i++)
                {   
                    for(j=0;j<5;j++)
                    {
                        I3.C.t.get(k)[i][j]=I2.C.t.get(k)[i][j]; 
                    }
                }
            }               
        return(I3);
   }
}
