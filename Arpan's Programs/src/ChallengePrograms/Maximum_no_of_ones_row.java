package ChallengePrograms;

//https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row/

import java.util.*;
import java.io.*;

public class Maximum_no_of_ones_row 
{
	public static void main(String args[]) 
	{
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();

		int count,max,maxrow,j,k;
		
		for(int i=0;i<T;i++)
		{
		    count=max=maxrow=0;
		    
			int row=sc.nextInt();
			
			int col=sc.nextInt();
			
			for(j=0;j<row;j++)
			{
				count=0;
				for(k=0;k<col;k++)
				{
					if(sc.nextInt()==1)
						count++;
				}
				if(count>max) 
				{
				    max=count;
				    maxrow=j; 
				}
			}
			
			System.out.println(maxrow);
		}
	}
}
