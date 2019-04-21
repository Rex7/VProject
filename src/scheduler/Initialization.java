/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;
import java.util.ArrayList;
import java.util.Collections;
import schediuler.dao.RoomDao;
import schediuler.dao.SubjectDao; 
import schediuler.dao.TeacherDao;
import timetable.TtController;
/**
 *
 * @author kamal
 */

public final class Initialization {
    int lhours,phours,lastslot,sl;
    String sub[];
    String subo[];
    String subol[];
    ArrayList<String> suba = new ArrayList<>(10);
    ArrayList<String> subao = new ArrayList<>(10);
    ArrayList<String> subaol = new ArrayList<>(10);
   public ArrayList<String[][][]> arrl= new ArrayList<>(11);
    String arr[][][]= new String[11][24][15];
    public String prac =" ",Single=" ";
    String sem;//sem number
    int v;//index of vector
    String Ret,Sub,rub,Teacher,Room,Lab;
    //Chromosome.Slot[][] slt = new Chromosome.Slot[12][5];
    public RoomDao R = new RoomDao();
    public TeacherDao T= new TeacherDao();
    public SubjectDao S= new SubjectDao();
    public Chromosome C= new Chromosome();//created
    //public TtController Tt=new TtController();
    public Initialization()
    {
        C.cinit();
       init("2",0);
       
      init("2",1);
      
      init("4",2);
      init("4",3);
      init("4",4);//ss
      init("6",5);
      init("6",6);
      init("6",7); //ss
      init("8",8);
      init("8",9);
      init("8",10);//ss4 7 10
    }
    
    public void init(String semp,int vp)
    {   sem=semp;
        v=vp;
        
        int i,j;
        R.getAllrecord();
        S.sub();
        T.teacherecord();
        
        System.out.println("SEMISTER :"+sem);
        for(i=0;i<27;i++)
        {
            if(S.subarr[i][4].get(0).equals(sem)&&((int)S.subarr[i][5].get(0))>0)
            {
            //System.out.println("nopt"+C.t.get(v)[i][j].subject[0]);
             if(((int)S.subarr[i][3].get(0))>0)
                     subao.add((String) S.subarr[i][1].get(0));
              if(((int)S.subarr[i][2].get(0))>0)
                     subaol.add((String) S.subarr[i][1].get(0));        
            }                      
        }
        int ids=0;
        if(v==4||v==7||v==10)
        {
            ids=2;
        }
         for(j=0;j<5;j++)//j day
         {//for j
            for(i=0+ids;i<6+ids;i++)// i slot
                {//for i      //System.out.println("get"+i+j);
                 if(i==5+ids)
                    {
                        lastslot=1;
                    }
                    else
                    {
                        lastslot=0;
                    }
                Ret="nul";
                C.t.get(v)[i][j].subject[0]=get(0,i,j,0);
                //System.out.println(C.t.get(v)[i][j].subject[0]);
                C.t.get(v)[i][j].room[0]=get(1,i,j,0);
                //System.out.println(C.t.get(v)[i][j].room[0]);
                C.t.get(v)[i][j].teacher[0]=get(2,i,j,0);
                //System.out.println(C.t.get(v)[i][j].teacher[0]);
                C.t.get(v)[i][j].prac=prac;
                //System.out.println(prac);
                if(C.t.get(v)[i][j].teacher[0].equals("nul"))
                    {
                        C.t.get(v)[i][j].prac="nul";
                    }
                if(C.t.get(v)[i][j].prac.equals("1"))
                    {
                        for(int k=0;k<27;k++)
                        {
                            if(S.subarr[k][1].get(0).equals(C.t.get(v)[i][j].subject[0]))
                            {
                                //System.out.println(S.subarr[k][1].get(0));
                                if(((int)S.subarr[k][5].get(0))==0)
                                    {
                                        //System.out.println("opt"+C.t.get(v)[i][j].subject[0]);
                                        suba.add(C.t.get(v)[i][j].subject[0]);
                                    }
                                
                            }//if
                        }//for k
                    }//if
                
                //System.out.println(suba);
                if(!Single.equals("1"))
                    {
                        //System.out.println("checkInside");
                        i=i+1;
                        C.t.get(v)[i][j].subject[0]=C.t.get(v)[i-1][j].subject[0];
                       C.t.get(v)[i][j].room[0]=C.t.get(v)[i-1][j].room[0];
                       C.t.get(v)[i][j].teacher[0]=C.t.get(v)[i-1][j].teacher[0];
                       C.t.get(v)[i][j].prac=C.t.get(v)[i-1][j].prac;

                    }
                Single="0";
            }//for i
        }//for j
         
         //System.out.println(" ");
         int g=3,sll,k,s,gi=0,o=0,sli;
         sub = suba.stream().toArray(String[]::new);
         subo = subao.stream().toArray(String[]::new);
         subol = subaol.stream().toArray(String[]::new);
         sl=sub.length;//System.out.println("length"+sl);
         sll=subo.length;//System.out.println(sll);
         sli=subol.length;
         suba.clear();
         subao.clear();
         subaol.clear();
         int oflag;
         int subi[] = new int[sl];
         int subio[] = new int[sll];
         
         for(i=0;i<sl;i++)
         {
             subi[i]=4;//4
             //System.out.println("999999999999999999999999999"+sub[i]);
              //System.out.println("subi + i"+sub[i]+subi[i]);

         }
          for(i=0;i<sll;i++)    
          {
              //System.out.println("888888888888888888888888888"+subo[i]);
              subio[i]=6;
          }
          /*for(i=0;i<sli;i++)    
          {
              System.out.println("77777777777777777777777777777777"+subol[i]);
              
          }
         */
         //System.out.println("length"+sl);
         
         String csub;
         for(j=0;j<5;j++)//j day
         {//for j
             for(i=0+ids;i<=5+ids;i++)// i slot
            {//for i       //System.out.println("");
                 if(C.t.get(v)[i][j].prac.equals("1"))
                 {   
                     oflag=1;
                    csub=C.t.get(v)[i][j].subject[0];//current sub
                    //System.out.println("csub"+csub);

                     for(s=0;s<sl;s++)
                     {
                         if(sub[s].equals(csub))//geting subject index
                         {
                             //System.out.println("index"+s);
                             oflag=0;
                             o=(s+1)%sl;
                             //System.out.println("indexo"+o);
                             break;
                         }
                     }
                     if(oflag!=0)//2
                        {
                        for(s=0;s<sll;s++)
                            {
                                if(subo[s].equals(csub))
                                    {
                                        oflag=1;
                                        //System.out.println("indexop"+s);
                                        o=(s+1)%sll;
                                        //System.out.println("indexo"+o);
                                        subio[s]=subio[s]-1;
                                        break;
                                    }
                            }   
                        }
                     
                     //increment o
                     //System.out.println("opi+s"+o+s);
                     for(k=1;k<g;k++)
                        {
                            while(o!=s)//untill same
                            {
                                //System.out.println("o|=s"+o+s);
                                if(oflag==0)
                                {
                                   if(subi[o]!=0)
                                       {
                                           subi[o]=subi[o]-1;//''''''
                                           gi=o;//got index of subject
                                           break;
                                       }
                                   o=(o+1)%sl;
                                }
                                else
                                {
                                    if(oflag==1)
                                    {
                                       if(subio[o]!=0)
                                        {
                                           subio[o]=subio[o]-1;
                                           gi=o;//got index of subject
                                           break;
                                        }
                                    o=(o+1)%sll;//1
                                    }
                                }
                            }//while

                            //System.out.println("oflag"+oflag);
                            //System.out.println("gi"+gi);
                            if(oflag==0)
                            {
                                C.t.get(v)[i][j].subject[k]=sub[gi];
                                o=(o+1)%sl;
                            }
                            else
                            {
                                C.t.get(v)[i][j].subject[k]=subo[gi];
                                o=(o+1)%sll;
                            }
                            C.t.get(v)[i][j].room[k]=get(1,i,j,k);
                            C.t.get(v)[i][j].teacher[k]=get(2,i,j,k);
                        }//for k
                    }//if
                 else
                {
                    //System.out.println("elseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    csub=C.t.get(v)[i][j].subject[0];
                     for(k=0;k<27;k++)
                    {
                     if(csub.equals(S.subarr[k][1].get(0))&&(int)S.subarr[k][5].get(0)>0)
                        //subequals and opt
                        {
                         int p;
                          //System.out.println("match opt");
                         for(s=0;s<sli;s++)
                            {
                                if(csub.equals(subol[s]))//geting subject index
                                {
                                     //System.out.println(subol[s]);
                                    o=(s+1)%sli;
                                    break;
                                }
                            }
                          //System.out.println("match"+o+s);
                          for(p=1;p<3;p++)
                            {
                                // System.out.println("p="+p);
                                while(o==s)//untill same
                                {
                                    o=(o+1)%sli;
                                }
                                 //System.out.println("posss"+p+o+s);//102
                                C.t.get(v)[i][j].subject[p]=subol[o];
                                C.t.get(v)[i][j].room[p]=get(1,i,j,p);
                                C.t.get(v)[i][j].teacher[p]=get(2,i,j,p);
                                
                                o=(o+1)%sli;
                            }     
                        }//if
                     }//for    
                 }//else
            }//for i
        }//for j
         System.out.println("Div"+v);
            int d;
            String da="";
            for(j=0;j<5;j++)
            {//for j
                d=j+1;
                switch(d)
                {
                    case 1:da="Monday";break;
                    case 2:da="tuesday";break;
                    case 3:da="Wednesday";break;
                    case 4:da="Thursday";break;
                    case 5:da="Friday";break;
                }
                System.out.println("Day :"+da);
               
                for(i=0;i<=5+ids;i++)
                {//for i   
                    //slt=C.t.get(0);
                    switch (C.t.get(v)[i][j].prac)
                    {
                    case "1":
                        System.out.print("P|");
                       
                        break;
                    case "0":
                        System.out.print("L|");
                        break;
                    default:
                        System.out.print("null");
                        break;
                    }
                     for(k=0;k<3;k++)
                    {
                    System.out.print(C.t.get(v)[i][j].subject[k]+"|");
                    System.out.print(C.t.get(v)[i][j].room[k]+"|");
                    System.out.print(C.t.get(v)[i][j].teacher[k]+"|");
                
                    }
                    System.out.println("$");
                }//for i
            }//for j
            int m,n,b;
            //System.out.println("77777777777777777777"+C.t.get(v)[0][0].subject[0]);
            //arr[0][0]=C.t.get(v)[0][0].subject[0];
            //System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+arr[0][0]);
            
            
            for(i=0;i<24;i++)// i slot 0-5*3*3
            {
                for(j=0;j<15;j++)//j day0-4*3
                 {//
                     m=i/3;
                     n=j/3;
                     b=i%3;
                arr[v][i][j]=C.t.get(v)[m][n].subject[b];
                 arr[v][i][j+1]=C.t.get(v)[m][n].teacher[b];
                  arr[v][i][j+2]=C.t.get(v)[m][n].room[b];
                  j=j+2;
                }
            
            }
             //System.out.println("jax"+v);
             if(v==10)
             {
                
                 arrl.add(arr);
                 //Tt.Givearray(arrl);
                 
             }
             
            /*switch(v)
            {
               
                case 0:arr0=arr;
                        arrl.add(arr0);
                        for(i=0;i<18;i++)
                            for(j=0;j<15;j++)
                                System.out.println("j"+arrl.get(v)[i][j]);
                        break;
                case 1:arr0=arr1;arrl.add(arr1);break;
                case 2:arr0=arr2;arrl.add(arr2);break;
                case 3:arr0=arr3;arrl.add(arr3);break;
                case 4:arr0=arr4;arrl.add(arr4);break;
                case 5:arr0=arr5;arrl.add(arr5);break;
                case 6:arr0=arr6;arrl.add(arr6);break;
                case 7:arr0=arr7;arrl.add(arr7);break;
                case 8:arr0=arr8;arrl.add(arr8);break;
                case 9:arr0=arr9;arrl.add(arr9);break;
                case 10:arr0=arr10;arrl.add(arr10);break;
                
                
                
            }*/
            
             
        //System.out.println("44444444444444444444444444");
            /*System.out.println("11111111111111111111111111111"+arrl.get(v));
               System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        //for (i = 0; i < 10; i++) 
        //{
            System.out.println(i+"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
            for (j = 0; j < 18; j++)
            {
                for (k = 0; k < 15; k++)
                {
        System.out.println(arrl.get(v)[j][k]);
                }
            }*/
        //} 
            for(i=0;i<24;i++)// i slot 0-5*3*3
            {
                for(j=0;j<15;j++)
                {
                    if(!arr[v][i][j].equals(" "))
                 System.out.print(arr[v][i][j]+"|");
                    else
                        System.out.print("$$$$");
                 
                }
                System.out.println("");
            }
           
    }   
            
    
    public String get(int sw,int slot,int day,int sli)
    {
       //System.out.println("gett");
        int i,j,k,ops=0,check,lflag,tflag;
        
        switch(sw)
        {
            case 0:      //System.out.println("case 0");
                for(i=0;i<27;i++)
                {//for1
                    
                    //System.out.println("case 0"+i);
                    check=0;
                    if(S.subarr[i][4].contains(sem)) // sem 2
                    {//System.out.println("if sem 2 in");
                    //System.out.println(String.valueOf(S.subarr[i][1].get(0)));
                        lhours=(int)S.subarr[i][2].get(0);
                       //System.out.println("lhours="+lhours);
                        phours=(int)S.subarr[i][3].get(0);
                        //System.out.println("phours"+phours);
                        if(lhours>0) //lecture hours is not zero
                        {//System.out.println("lec");
                            rub=String.valueOf(S.subarr[i][1].get(0));
                            for(j=0;j<slot;j++)//checking day slots
                            {
                                    //System.out.println("check"+rub);
                                if((C.t.get(v)[j][day].subject[0].equals(rub))&&(C.t.get(v)[j][day].prac.equals("0")))//lecture should not repeat
                                {//subject same and prac=0
                                    //System.out.println("cond"+C.s2a[j][day].subject[0]);
                                    
                                    check=1;
                                    break;
                                }
                            }
                            if(check==0||slot==0)
                                {
                                  prac="0";
                                  if((((int)S.subarr[i][5].get(0))==1)||(((int)S.subarr[i][5].get(0))==2))//optional
                                  {         
                                      if(lastslot==1)
                                      {
                                       ops=1;   
                                      }
                                      else
                                      {
                                           for(k=0;k<27;k++)
                                           {
                                               if(((int)S.subarr[k][5].get(0))%2==1&&S.subarr[k][4].get(0).equals(sem))
                                               {
                                                   S.subarr[k][5].set(0,4);
                                                   S.subarr[k][2].set(0,(int)S.subarr[k][2].get(0)-2);
                                                   
                                               }
                                           }
                                        }
                                  }   
                                   //System.out.println("bef"+S.subarr[i][2].get(0));
                                   if(ops!=1)
                                   {
                                   if(lhours==1||lastslot==1)
                                        {
                                       S.subarr[i][2].set(0,(int)S.subarr[i][2].get(0)-1); //decrement by 2
                                       //System.out.println("aftr1"+S.subarr[i][2].get(0));
                                        Single="1";
                                        }
                                   else
                                        {
                                            S.subarr[i][2].set(0,(int)S.subarr[i][2].get(0)-2);
                                             //System.out.println("aftr2"+S.subarr[i][2].get(0));
                                        }
                                   }
                                       Sub=String.valueOf(S.subarr[i][1].get(0));//allot subject
                                  Ret=Sub;
                                  break;
                                    
                                }
                            }
                        else//practical
                            {
                            //System.out.println("else");
                            if(phours>0&&lastslot!=1)
                            {//System.out.println("prac");
                                rub=String.valueOf(S.subarr[i][1].get(0));    
                                for(j=0;j<slot;j++)
                                {//System.out.println("for");
                                    if((C.t.get(v)[j][day].subject[0].equals(rub))&&(C.t.get(v)[j][day].prac.equals("1")))//practical should not repeat
                                    {//System.out.println("cond");
                                    check=1;
                                    
                                    }
                                }
                                if(check==0||slot==0)
                                    {
                                        ops=0;
                                       prac="1";
                                       // add
                                       if(((int)S.subarr[i][5].get(0))>0&&((int)S.subarr[i][3].get(0))>0)//current row opt and phours >0
                                       {
                                           ops=1;
                                           for(k=0;k<27;k++)
                                           {//sem and opt 1
                                               if((int)S.subarr[k][5].get(0)>0&&S.subarr[k][4].get(0).equals(sem))
                                               {
                                                   S.subarr[k][5].set(0,2);
                                                   S.subarr[k][3].set(0,0);
                                                   
                                               }
                                           }
                                       }
                                       if(ops!=1)
                                       {
                                       S.subarr[i][3].set(0,(int)S.subarr[i][3].get(0)-2);      
                                       }
                                       Sub=String.valueOf(S.subarr[i][1].get(0));
                                      Ret=Sub;
                                      //System.out.println(Ret);
                                      break;
                                    }
                           }
                       }
                    }
                    
                } 
                
                break;
        case 1 : /*if(Ret.equals("nul"))
                {
                    break;
                }*/
            int r=v;
                Sub=C.t.get(v)[slot][day].subject[sli];
                if(prac.equals("0"))//class
                {   
                    if(sli!=0)//not 0
                    {
                        if(sli==1)
                        {
                        r=12;
                                }
                        else
                        {
                         r=11;
                        }
                    }
                    for(i=0;i<45;i++)
                    {   
                        if(R.roomarr[i][2].contains(prac))// to find class '0'
                        {
                            
                            if(r<=0)
                            {
                            Room=R.roomarr[i][1].get(0);
                            Ret=Room;
                            break;
                            }
                            r--;
                        }
                    }
                 
                }
                else//Lab 
                {
                    if(prac.equals("1"))
                    {
                    for(i=0;i<80;i++)
                    {   
                        lflag=0;
                        //System.out.println(R.rsubarr[i][2].get(0)+"=="+Sub);
                        if(R.rsubarr[i][2].contains(Sub))//to find lab w.r.t subject
                        {
                            //System.out.println("match********");
                            Lab=R.rsubarr[i][1].get(0);
                            for(int u=0;u<40;u++)
                            {
                                if(R.roomarr[u][0].get(0).equals(Lab))
                                { 
                                    Lab=R.roomarr[u][1].get(0);
                                    for(j=0;j<3;j++)
                                    {
                                        if(C.t.get(v)[slot][day].room[j].equals(Lab))
                                        {
                                           
                                           lflag=1;
                                           break;
                                        }
                                    }
                                    if(lflag==0)
                                    break;
                                }
                            }
                            //System.out.println(Lab);
                            Ret=Lab;
                            break;
                        }
                    }
                }
            }
                 break;
        case 2:  if(Ret.equals("nul"))
                {
                    break;
                }
            Sub=C.t.get(v)[slot][day].subject[sli];
            for(i=0;i<80;i++) 
            {   //System.out.println(i+Sub+T.tsubarr[i][2].get(0));
                if(T.tsubarr[i][2].contains(Sub))
                {   //System.out.println("sub");
                    if(prac.equals(0))//class
                    {//System.out.println("class");
                        if(!T.tsubarr[i][3].contains("0"))
                        {//System.out.println("find");
                            T.tsubarr[i][3].set(0,(int)T.tsubarr[i][3].get(0)-2);
                            Teacher=String.valueOf(T.tsubarr[i][1].get(0));
                            for(int u=0;u<51;u++)
                            {
                                if(T.teacharr[u][0].get(0).equals(Teacher))
                                { Teacher=String.valueOf(T.teacharr[u][1].get(0));
                                    break;
                                }
                            }
                            Ret=Teacher;
                            break;
                        }
                    }
                    else//lab
                    {
                         if(!T.tsubarr[i][4].contains("0"))
                        {
                            T.tsubarr[i][4].set(0,(int)T.tsubarr[i][4].get(0)-2);
                            Teacher=String.valueOf(T.tsubarr[i][1].get(0));
                            for(int u=0;u<51;u++)
                            {
                                tflag=0;
                                if(T.teacharr[u][0].get(0).equals(Teacher))
                                { Teacher=String.valueOf(T.teacharr[u][1].get(0));
                                
                                    for(j=0;j<3;j++)
                                    {
                                        if(C.t.get(v)[slot][day].teacher[j].equals(Teacher))
                                        {
                                           
                                           tflag=1;
                                           break;
                                        }
                                    }
                                    if(tflag==0)
                                    break;
                                }
                            }
                            Ret=Teacher;
                            break;
                        }
                    }}
                    
            }
            break;
            }
        //System.out.println(Ret);
        return(Ret);
    }
    
    
    }