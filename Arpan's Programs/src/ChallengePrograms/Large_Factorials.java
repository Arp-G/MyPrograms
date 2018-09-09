package ChallengePrograms;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Large_Factorials 
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		Long fact;
		
		for(int i=0;i<T;i++)
		{
		    int N=sc.nextInt();
		    
		    fact=fact(N);
		    
		    System.out.print((fact.toString()).charAt(0)+" ");
		
		
		i=0;
		
		while(true)
		{
			long chk=(long)java.lang.Math.pow(10,i);
			
			if(chk==fact)
			{
				System.out.println(i);
		        break;
		    }
			else if(chk>fact)
		    {
		        System.out.println(i-1);
		        break;
		    }
		    i++;
		}
		
		}
	}
	
	static long fact(long x)
	{
	    if( x==1) return 1;
	    else
	    return x*fact(x-1);
	}
}