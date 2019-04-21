/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import schediuler.dao.RoomDao;
import schediuler.dao.SubjectDao;
import schediuler.dao.TeacherDao;
import timetable.TtController;


public class Schediuler  {
     public Initialization I1 =new Initialization();
     public Initialization D =new Initialization();
     int n=30;
     public Initialization Ini[] =new Initialization[n];
      public Initialization Mut[] =new Initialization[n];
      public Initialization Crs[] =new Initialization[n];
      public Initialization pop[][] =new Initialization[n][100];
      public Initialization Min =new Initialization();
     ArrayList<Integer> sl=new ArrayList<>();
     ArrayList<Integer> ml=new ArrayList<>();
     ArrayList<Integer> cl=new ArrayList<>();
     public Fitness F =new Fitness();
     public Crossover Cr =new Crossover();
    public Mutation M =new Mutation();
    public Solution S;
    public ArrayList<String[][][]> arl= new ArrayList<>();
    //public TtController T=new TtController();
    int[] points = new int[n];
    int[] mpoints = new int[n];
    int[] cpoints = new int[n];
    int minp=20;
    public String ary[][][]= new String[11][24][15];
   
    public Schediuler()
    {
        System.out.println("INITIAL POPULATION OF CHROMOSOMES WITH OPTIMIZED ALGORITHM");
        int i;
        for(i=0;i<n;i++)
        {
            System.out.println("CHROMOSOME INITIALIZED NUMBER : "+i);
            Ini[i] =new Initialization();//
        }
        sfun();
        
     
    }
    
    
    public void sfun()//selection function
    {
        
        int i,j,k,g=0,p=0,min1=20,min2=20;
        
        for(i=0;i<n;i++)//pop=ini
            {
                pop[0][i]=Ini[i];
            }
        
        while(g<30)
        {
        k=0;
        System.out.println("GENERATION NO :"+g+1);
         System.out.println("FITNESS EVALUATION :");
         System.out.println("FITNESS VALUE OF POPULATED CHROMOSOMES :");
        for(i=0;i<n;i++)
        {
            points[i]=F.fitnessvalue(pop[p][i]);
            System.out.println("Points"+i+"="+points[i]);
            if(points[i]<minp)
            {
                minp=points[i];
                Min=pop[p][i];
            }
            
            if(points[i]<min1)//selection
            {
                sl.add(i);
                pop[p+1][k]=pop[p][i];//
                System.out.println("SELECTED FOR NEXT GENERATION :"+i);
                k++;
            }
        }
        
        
        System.out.println("MUTATED CHROMOSOMES FITNESS EVALUATION");
        for(j=0;j<sl.size();j++)//mutation
        {
            System.out.println("BEFORE MUTATION POINTS="+j+points[sl.get(j)]);
            Mut[j]=M.Mutate(pop[p][sl.get(j)]);
            mpoints[j]=F.fitnessvalue(Mut[j]);
            System.out.println("POINTS"+j+"="+mpoints[j]);
            if(mpoints[j]<min1)//MUtated selection
            {
                ml.add(j);
                pop[p+1][k]=Mut[j];
                k++;
            }
        }
        
        System.out.println("CROSSOVER CHROMOSOMES FITNESS EVALUATION");
        for(i=0;i<sl.size();i++)//crossover
        {
         Crs[i]=Cr.Crossovers(pop[p][sl.get(i)],pop[p][sl.get((i+1)%sl.size())],D);  
            cpoints[i]=F.fitnessvalue(Crs[i]);
            System.out.println("POINTS"+i+"="+cpoints[i]);
            if(cpoints[i]<min1)//crossover selection
            {
                cl.add(i);
                pop[p+1][k]=Crs[i];
                k++;
            }
        }
        sl.clear();
        ml.clear();
        cl.clear();
        g++;
        min1=min2;
        }
        System.out.println("MINIMUM POINTS="+minp);
       
        Display();
        //T.Garray(ary);
        S=new Solution(ary);
        //S.Givearray(ary);
        
    }
    public void Display()
    {
        int i,j,m,n,b,v;
        for(v=0;v<11;v++)
        {
            for(i=0;i<24;i++)// i slot 0-5*3*3
            {
                for(j=0;j<15;j++)//j day0-4*3
                    {//
                     m=i/3;
                     n=j/3;
                     b=i%3;
                ary[v][i][j]=Min.C.t.get(v)[m][n].subject[b];
                 ary[v][i][j+1]=Min.C.t.get(v)[m][n].teacher[b];
                  ary[v][i][j+2]=Min.C.t.get(v)[m][n].room[b];
                 
                  j=j+2;
                    }
            }
            
        }
        arl.add(ary); 
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
}
