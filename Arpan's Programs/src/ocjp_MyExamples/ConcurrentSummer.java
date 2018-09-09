package ocjp_MyExamples;

import java.util.Random;
import java.util.concurrent.*;
import java.util.*;

public class ConcurrentSummer extends RecursiveTask<Integer>
{
	static List<Integer> arr;
	int start;
	int end;
	
	ConcurrentSummer(int start,int end)
	{
		this.start=start;
		this.end=end;
	}
	
	
	public Integer compute()
	{
		
		//if(end-start<2)System.out.println("Start = "+start+"  end = "+end);
		
		 if(end-start==1) // if there are only two numbers
	        {
	            return arr.get(start)+arr.get(end);
	        }
	        else if(end-start==0) // if there is only one number then that number is both start and end
	        {
	            return arr.get(start);
	        }
		else
		{
			int mid=start+(end-start)/2;
			
			ConcurrentSummer task1=new ConcurrentSummer(start,mid);
			
			ConcurrentSummer task2=new ConcurrentSummer(mid+1,end);
			
			task1.fork();
			
			return task2.compute()+task1.join();
		}
	}
	
	
	static int normalSummer()
	{
		int sum=0;
		
		for(int a:arr)
		{
			sum+=a;
		}
		
		return sum;
	}
	
	public static void main(String args[])
	{
		
		Integer a[]=new Integer[100000];
		
		//Integer a[]= {1,2,3,4,5};
		 
		Random rand = new Random();
		 
		for(int j=0;j<100000;j++)
		{
			a[j]=rand.nextInt(100);
		}
		
		
		
		List<Integer> arr=Arrays.asList(a);
		
		ConcurrentSummer.arr=arr;
		
		ForkJoinTask<Integer> task=new ConcurrentSummer(0,arr.size()-1);
		
		ForkJoinPool pool=new ForkJoinPool();
		
		int sum=pool.invoke(task);
		
		
		long time=java.lang.System.currentTimeMillis() ;
		
		System.out.println("Sum = "+sum);
		
		System.out.println("Completed Concurrent Sum in "+ (java.lang.System.currentTimeMillis()-time ));
		
		time=java.lang.System.currentTimeMillis() ;
		
		System.out.println("Sum = "+normalSummer());
		
		System.out.println("Completed Normal Sum in "+ (java.lang.System.currentTimeMillis()-time ));
		
	}
}
