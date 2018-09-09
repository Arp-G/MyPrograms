package ChallengePrograms;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/finding-the-numbers/0/?ref=self

class Finding_the_numbers
{
	
	public static void main (String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
				
		for(int i=0;i<T;i++)
		{
		    List<Integer> list=new ArrayList<>();
		    
		    int N=sc.nextInt();
		    
		    for(int j=0;j<(2*N+2);j++)
		    {
		        list.add(sc.nextInt());
		    }
		    
		    Collections.sort(list);

		    int k=0;
		    
		   
		    while(list.size()>2)
		    {
		    	
		        if(list.get(k)==list.get(k+1))
		        {
		            list.remove(k);
		            list.remove(k);		            
		        }
		        else 
		        	k++;
		    }
		    
		    System.out.print(list.get(0)+" "+list.get(1));
		    
		    System.out.println();		    
		}
				sc.close();
	}
}