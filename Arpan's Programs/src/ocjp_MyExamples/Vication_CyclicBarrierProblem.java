package ocjp_MyExamples;

/*
 * Three friends went on a vacation to India but this time they had a special plan... They wanted to visit places together but wanted to travel from one place to another individually.
 * At every destination they would meet together enjoy the place and would then travel their own paths to reach the next destination where they would meet.
 * They had one condition though... If one or two of them reached a destination before the others then they would wait until all the three friends arrived...
 * They decided to visit 4 places : North India , Kolkata , Mumbai and Chennai.
 */

import java.util.concurrent.*;


public class Vication_CyclicBarrierProblem 
{
	private void NorthIndia() 
	{
		System.out.println(Thread.currentThread().getName()+" Reached North India");		
	}
	
	private void Kolkata()
	{
		System.out.println(Thread.currentThread().getName()+" Reached Kolkata");
	}
	
	private void Mumbai()
	{
		System.out.println(Thread.currentThread().getName()+" Reached Mumbai");
	}
	
	private void Chennai()
	{
		System.out.println(Thread.currentThread().getName()+" Reached Chennai");
	}
	
	public void WaitForMe(CyclicBarrier northindia,CyclicBarrier kolkata,CyclicBarrier mumbai,CyclicBarrier chennai)
	{
		
		try
		{
			
			NorthIndia();
		
			northindia.await(); // The cyclic barrier north India will wait until 3 threads (representing 3 friends here) call await() on it. After that Barrier breaks and 
								// all the 3 waiting threads continue execution and visit the next destination.
			Kolkata();
		
			kolkata.await();
		
			Mumbai();
		
			mumbai.await();
		
			Chennai();
			
			chennai.await();
			
		
		}
		catch(InterruptedException | BrokenBarrierException e)
		{
			System.out.println("Ops trip cancel because of "+e);
		}
	}
	
	public static void main(String args[])
	{
		ExecutorService service = null;
		
		try
		{
			service=Executors.newFixedThreadPool(3);
			
			CyclicBarrier northindia=new CyclicBarrier(3 , ()->System.out.println("All of us have arrived at North India.. North India barrier broken lets explore North India together.."));
			
			CyclicBarrier kolkata=new CyclicBarrier(3 , ()->System.out.println("All of us have arrived at Kolkata.. Kolkata barrier broken lets explore Kolkata together.."));
			
			CyclicBarrier mumbai=new CyclicBarrier(3 , ()->System.out.println("All of us have arrived at Mumbai.. Mumbai barrier broken lets explore mumbai together.."));
			
			CyclicBarrier chennai=new CyclicBarrier(3 , ()->System.out.println("All of us have arrived at Chennai.. Chennai barrier broken lets explore Chennai together.."));
			
			Vication_CyclicBarrierProblem ob = new Vication_CyclicBarrierProblem();
			
			for(int i=0;i<3;i++) // Create three threads who will call the different methods() or create three friends and set them to explore the different places
			{
				service.submit(()->ob.WaitForMe(northindia, kolkata, mumbai , chennai));
			}
		}
		finally
		{
			if( service != null) service.shutdown();
		}
	}
}
