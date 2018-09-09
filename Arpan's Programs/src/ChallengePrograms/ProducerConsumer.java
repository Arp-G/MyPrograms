package ChallengePrograms;

public class ProducerConsumer {

	public static void main(String[] args)
	{
		Resource obj=new Resource();
		Producer pro=new Producer(obj);
		Consumer con=new Consumer(obj);
	}
	

}

class Resource
{
	public boolean Available;
	public int ResourceNo;
	
	Resource()
	{
		Available=false;
		ResourceNo=0;
	}
	
	synchronized void put()
	{
		
			System.out.println("Produce  "+ResourceNo);
			Available=true;
			notify();
			try
			{
					wait();
			}
			catch(Exception e)
			{}
			ResourceNo++;
					
		
		
	}
	
	synchronized void get()
	{
		
			System.out.println("Consume  "+ResourceNo);
			Available=false;
			notify();
			try
			{
					wait();
			}
			catch(Exception e)
			{}
					
		
		
	}
}

class Producer implements Runnable
{
	Resource obj;
	Producer(Resource obj)
	{
		this.obj=obj;
		Thread Producer=new Thread(this,"Producer");
		Producer.start();
		
	}
	
	public void run()
	{
		while(!obj.Available)
		{
			obj.put();
			try
			{
				
			Thread.sleep(1000);
			}catch(Exception e){}
		}
		
		
	}

	
}

class Consumer implements Runnable
{
	Resource obj;
	Consumer(Resource obj)
	{
		this.obj=obj;
		Thread Consumer=new Thread(this,"Consumer");
		Consumer.start();
	}
	
	public void run()
	{
		while(obj.Available)
		{
			obj.get();
			try
			{
				
			Thread.sleep(1000);
			}catch(Exception e){}
		}
		
		
	}
	
}