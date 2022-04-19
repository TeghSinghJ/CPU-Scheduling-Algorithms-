package Algorithms;

import java.util.Scanner;

class SJF_demo
{
   Scanner sc=new Scanner(System.in);
   int n_of_p;
   int[] p=new int[100];
   int[] complete_time=new int[100];
   int[] arr_time=new int[100];
   int[] wait_time=new int[100];
   int[] turnAr=new int[100];
   void getProcess()
   {
       System.out.println("[*] Enter number of process:");
       n_of_p=sc.nextInt();
       for(int i=0;i<n_of_p;i++)
       {
           System.out.println("[*] Enter p"+(i+1)+" 's burst time:");
           p[i]=sc.nextInt();
           System.out.println("[*] Enter p"+(i+1)+" 's arrival time:");
           arr_time[i]=sc.nextInt();
       }
       for(int i=0;i<n_of_p;i++)
       {
           for(int j=0;j<n_of_p;j++)
           {
               int temp;
               if(p[i]<p[j])
               {
                   temp=p[i];
                   p[i]=p[j];
                   p[j]=temp;
                   
               }
           }
           
       }
   }
   void comp_Time()
   {
       complete_time[0]=arr_time[0]+p[0];
       for(int i=1;i<n_of_p;i++)
       {
           complete_time[i]=p[i]+complete_time[i-1];
       }
   }
  public void turnAroundTime()
  {
      for(int i=0;i<n_of_p;i++)
      {
          turnAr[i]=complete_time[i]-arr_time[i];
      }
  }
  public void waitingTime()
  {
      for(int i=0;i<n_of_p;i++)
      {
          wait_time[i]=turnAr[i]-p[i];
      }
  }
  public void showResult()
  {
      System.out.println(" -----------------------------------------------------------------------------------------------");
      System.out.println("|\tProcess ID\t|\tComplete Time\t|\tTurn Around Time |\tWaiting Time \t|");
      System.out.println(" -----------------------------------------------------------------------------------------------");
      for(int i=0;i<n_of_p;i++)
      {
          System.out.println("| P"+(i+1)+"\t\t\t| "+complete_time[i]+"\t\t\t| "+turnAr[i]+"  \t\t\t| "+wait_time[i]+"\t\t\t|");
      }
      System.out.println(" -----------------------------------------------------------------------------------------------");
  }
}
class SJF
{
    public static void main(String args[])
    {
        SJF_demo d=new SJF_demo();
        d.getProcess();
        d.comp_Time();
        d.turnAroundTime();
        d.waitingTime();
        d.showResult();
    }
}