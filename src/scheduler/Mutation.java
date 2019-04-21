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
public class Mutation {
    
   public Initialization Mutate(Initialization I)
   {
        int i,j,k,x,ids;
        for(k=0;k<11;k++)
            {
                ids=0;
                if(k==4||k==7||k==10)
                {
                    ids=2;
                }
            Random r = new Random();     
            
                for(j=4; j >= 0; j--)
                {
                    x = r.nextInt(j+1);
                    for(i=0+ids;i<6+ids;i++)
                    {
                        I.C.t.get(k)[9][4]=I.C.t.get(k)[i][j];
                        I.C.t.get(k)[i][j]=I.C.t.get(k)[i][x];
                        I.C.t.get(k)[i][x]=I.C.t.get(k)[9][4];
                    }
                }            }
        return(I);
   }
    
}
