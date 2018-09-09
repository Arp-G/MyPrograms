package ChallengePrograms;

import java.util.*;
import java.lang.*;
import java.io.*;

class Excel_Intersect {
	
	public static void main (String[] args) throws IOException
	{
		
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		int n;
		
		for(int x=0;x<T;x++)
		{
			int max=sc.nextInt();
			
			List<Integer> Leftlist=new ArrayList<>();
		
			List<Integer> Rightlist=new ArrayList<>();
		
			for(int i=0;i<max;i++)
			{
				n=sc.nextInt();
			
				if(n%2==0)
				{
					Rightlist.add(n);
				}
				else
				{
					Leftlist.add(n);
				}
			}
		
			
		Collections.sort(Leftlist,Collections.reverseOrder());
		
		Collections.sort(Rightlist);

		
		for(int i=0;i<Leftlist.size();i++)
		{
			System.out.print(Leftlist.get(i)+" ");
		}
		
		for(int i=0;i<Rightlist.size();i++)
		{
			System.out.print(Rightlist.get(i)+" ");
		}
		
		System.out.println();
		
	}
		sc.close();
	}
}
