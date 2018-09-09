package ChallengePrograms;

import java.util.*;

public class Buissness_Trip{
   
	public static void main(String args[]) 
    {
       
       Scanner sc=new Scanner(System.in);
       
       int k=sc.nextInt();
       
       List<Integer> list=new ArrayList<>();
       
       for(int i=0;i<12;i++)
       {
           list.add(sc.nextInt());
       }
       
       Collections.sort(list,Collections.reverseOrder());
       
       int count=0;
       int sum=0;
       boolean flag=false;
       
       while(count<12)
       {
    	   if(sum>=k) { System.out.println(count); flag=true; break;}
    	   
    	   sum=sum+list.get(count);
    	   
    	   count++;
    	   
       }
       
       if(!flag) 
    	   System.out.println(-1);
    	   
       sc.close();
       
    }
}