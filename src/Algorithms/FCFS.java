package Algorithms;
import java.util.Scanner;
public class FCFS
{
	Scanner sc=new Scanner(System.in);
	int no_of_process;
        final float nline=52;
	int process_id;
	float average_waiting_time=0;
	int[] waiting_time=new int[100];
	int[] turn_around_time=new int[100];
	int[] prcs_arr_time=new int[100];
	int[] complete_time=new int[100];
	int[] prcs_busrt_time=new int[100];
	public void getProcess()
	{
		System.out.print((char)27 + "[32m[*] Enter number of process:");
		no_of_process=sc.nextInt();
		for(int i=0;i<no_of_process;i++)
		{
			System.out.print((char)27 + "[32m[*] Enter process "+(i+1)+"'s Burst time:");
			prcs_busrt_time[i]=sc.nextInt();
			System.out.print((char)27 + "[32m[*] Enter process "+(i+1)+"'s Arrival time:");
			prcs_arr_time[i]=sc.nextInt();
		}
		for(int i=0;i<no_of_process;i++)
		{
			for(int j=0;j<no_of_process;j++)
			{
				int temp;
				if(prcs_arr_time[i]>prcs_arr_time[j])
				{
					temp=prcs_arr_time[i];
					prcs_arr_time[i]=prcs_arr_time[j];
					prcs_arr_time[j]=temp;
				}
			}
		}
	}
	public void compTime()
	{
            complete_time[0]=prcs_arr_time[0]+prcs_busrt_time[0];
        	for(int i=1;i<no_of_process;i++)
		{
			complete_time[i]=prcs_busrt_time[i]+complete_time[i-1];
		}
	}
	public void turnAr()
	{
		for(int i=0;i<no_of_process;i++)
		{
			turn_around_time[i]=complete_time[i]-prcs_arr_time[i];
		}
	}
	public void waitTime()
	{
            for(int i=0;i<no_of_process;i++)
		{
			waiting_time[i]=turn_around_time[i]-prcs_busrt_time[i];
		}
	}
	public void showResult()
	{
              for(int i=0;i<nline;i++)
              {
                System.out.print((char)27 + "[44m--");
              }
              System.out.println("");
               System.out.println((char)27 + "[30m|\tProcess_ID\t|\tComplete Time\t|\tTurn Around Time\t|\tWaiting Time\t|");
               for(int i=0;i<nline;i++)
                {
                System.out.print((char)27 + "[44m--");
                }
               System.out.println("");
		for(int i=0;i<no_of_process;i++)
		{
                    System.out.println("|\tProcess"+(i+1)+"\t|\t"+complete_time[i]+"\t\t|\t"+turn_around_time[i]+"\t\t\t|\t"+waiting_time[i]+"\t\t|");
		}
//                System.out.println("");
           for(int i=0;i<nline;i++){
            System.out.print("--");}
	}
        public void avg()
        {
            for(int i=0;i<no_of_process;i++)
            {
                average_waiting_time+=waiting_time[i];
            }
            average_waiting_time=average_waiting_time/no_of_process;
            System.out.println((char)27 + "[32mAverage waiting Time="+average_waiting_time);
        }
        public void gantCharrt()
        {
            System.out.println("GANNT CHART:");
            System.out.print("---------------------");
            for(int i=0;i<no_of_process;i++)
            {
                
                System.out.println("|\tp["+i+"]\t|");
            }
            System.out.print("---------------------");
        
        }
}
