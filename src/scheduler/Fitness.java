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
public class Fitness {
    int points;

    public int fitnessvalue(Initialization I)
    {
        int i,j,k,kk,ve,vv,x;
                points=0;
        String ss,se;
        for(ve=0;ve<1;ve++)
        {
            for(vv=ve+1;vv<3;vv++)
            {
                for(i=0;i<8;i++)
                {
                    for(j=0;j<5;j++)
                    {
                        for(k=0;k<3;k++)
                        {
                            for(kk=0;kk<3;kk++)
                            {
                                //System.out.println("rx");
                                //System.out.println("ve"+ve+"vv"+vv+"i"+i+"j"+j+"k"+k+"kk"+kk);
                                ss=I.C.t.get(ve)[i][j].teacher[0];
                                se=I.C.t.get(vv)[i][j].teacher[0];
                                //System.out.println("ve"+ss+"==t="+se);
                                if(I.C.t.get(ve)[i][j].teacher[k].equals(I.C.t.get(vv)[i][j].teacher[kk]))
                                {
                                    if(!I.C.t.get(vv)[i][j].teacher[kk].equals(" "))
                                            {
                                                //System.out.println(I.C.t.get(ve)[i][j].teacher[k]+"==="+I.C.t.get(vv)[i][j].teacher[kk]);
                                                points=points+1;
                                            }
                                }
                                //System.out.println("r"+I.C.t.get(ve)[i][j].room[k]+"==="+I.C.t.get(vv)[i][j].room[kk]);
                                if(I.C.t.get(ve)[i][j].room[k].equals(I.C.t.get(vv)[i][j].room[kk]))
                                {
                                    if(!I.C.t.get(vv)[i][j].room[kk].equals(" "))
                                            {
                                    points=points+1;
                                            }
                                }
                            }
                        }
                    }
                }
            }    
        }
        //System.out.println("fitto"+points);
    return(points);
    }
}
