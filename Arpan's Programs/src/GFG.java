//https://practice.geeksforgeeks.org/problems/dice-throw/0/?track=SP-Mathematics


import java.util.*;



public class GFG
 {
     static int count=0;
     
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    
	    int n=sc.nextInt();
	    
	    while(n!=0)
	    {
	        
	        count=0;
	        
	        int a=sc.nextInt();
	        int b=sc.nextInt();
	        int c=sc.nextInt();
	        
	        
	       for(int i=1;i<=a;i++) 
	            SumCount(1,a,i,b,i,c,"");
	       
	       
	        
	        System.out.println(count);
	        
	        n=n-1;
	    }
	 }
	 
	 static void SumCount(int a,int maxA,int b,int maxB,int cur_sum,int req_sum,String sol)
	 {
	     //sol=sol+"called SumCount for dice "+a+" face"+b+" current sum= "+cur_sum+"\n";
	     
	    /* try
	     {
	    	 Thread.sleep(1000);
	     }
	     catch(Exception e)
	     {}*/
	     
	     
     
	       if(cur_sum==req_sum && a==maxA)
	       {   
	          // System.out.println(sol);
	           count=count+1;
	          
	           return;
	       }
	       
	       if(a==maxA)
	            return;
	            
	       if(cur_sum>=req_sum)
	            return;
	            
	      
	      for(int i=1;i<=maxB;i++)
	      {
	            SumCount(a+1,maxA,i,maxB,cur_sum+i,req_sum,sol);
	      }
	     
	 }
}