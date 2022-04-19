/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Algorithms.FCFS;
import static java.lang.System.exit;
import java.util.Scanner;
/**
 *
 * @author Tegh Singh Juni
 */
public class CPU_SCEDULING_CALCULATOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FCFS fcfs=new FCFS();
        Scanner sc=new Scanner(System.in);
       int choice;
       System.out.println((char)27 + "[33m  ========================================");
       System.out.println((char)27 + "[33m |      CPU SCHEDULING CALCULATOR         |");
       System.out.println((char)27 + "[33m  ========================================");
       System.out.println((char)27 + "[32m[1].FIRST COME FIRST SERVE AALGORITHM");
       System.out.println((char)27 + "[32m[2].SHORTEST JOB FIRST ALGORITHM");
       System.out.println((char)27 + "[32m[3].PRIORITY SCHEDULING ALGORITHM");
       System.out.println((char)27 + "[32m[0].EXIT:");
       System.out.print((char)27 + "[32m[*]Enter Your choice:");
       choice=sc.nextInt();
       switch(choice)
       {
           case 1:System.out.println("------------------------------------");
                  System.out.println("--FIRST COME FIRST SERVE ALGORITHM--");
                  System.out.println("------------------------------------");
                  fcfs.getProcess();
                  fcfs.compTime();
                  fcfs.turnAr();
                  fcfs.waitTime();                          
                  fcfs.avg();
                  fcfs.showResult();
                  fcfs.gantCharrt();
                  break;
           case 2:
               break;
           case 3:
               break;
           case 0:System.out.println("See you again...");
               exit(0);
       }
    }
    
}
