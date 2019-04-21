/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author kamal
 */
public class Solution {
    public String ary[][][]=new String[11][24][15];
    public Solution(String arr[][][])
    {
        ary=arr;
    }
    /*public void Givearray(String pary[][][] )
    {
        System.out.println("pary");
        int v,i,j;
        ary=pary;
        for(v=0;v<11;v++)
   {
     for(i=0;i<24;i++)// i slot 0-5*3*3
            {
                for(j=0;j<15;j++)
                {
                    if(!ary[v][i][j].equals(" "))
                 System.out.print(ary[v][i][j]+"|");
                    else
                        System.out.print("$$$$");
                }
                System.out.println("");
            }
     System.out.println("............");
    }
    }
    
    
    public String[][][] givarray()
    {
        System.out.println("pary2");
        System.out.println("garray"+ary[0][0][0]);
        return(ary);
    }
*/
}
