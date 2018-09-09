package ChallengePrograms;

public class MultithreadingProject 
{
	public static void main(String args[])
	{
		Counter obj=new Counter();
		PositiveCounter pro=new PositiveCounter(obj);
		NegativeCounter con=new NegativeCounter(obj);
	}
}

class Counter
{
	int count;
	Counter()
	{
		count=0;
	}
	synchronized void Poscounter()
	{
			while(true)
			{
				while(count<10)
				{
					System.out.println(Thread.currentThread()+"  =  "+count++);
					try
					{
						Thread.sleep(500);
					}catch(Exception e){};
		
				}
				notify();
				try
				{
					wait();
				}catch(Exception e){};

			}
	}
	
	synchronized void Negcounter()
	{
		while(true)
		{
			while(count>0)
			{
				System.out.println(Thread.currentThread()+"  =  "+count--);
				try
				{
					Thread.sleep(500);
				}catch(Exception e){};
	
			}
				notify();
				try
				{
					wait();
				}catch(Exception e){};
		}
	}
}

class PositiveCounter implements Runnable
{
	Counter obj;
	
	PositiveCounter(Counter obj)
	{
		Thread PositiveCount=new Thread(this,"Positive Counter");
		this.obj=obj;
		PositiveCount.start();
	}
	
	public void run()
	{		
		obj.Poscounter();
	}
}


class NegativeCounter implements Runnable
{
	Counter obj;
	
	NegativeCounter(Counter obj)
	{
		Thread NegativeCount=new Thread(this,"Negative Counter");
		this.obj=obj;
		NegativeCount.start();
	}
	
	public void run()
	{		
		obj.Negcounter();
	}
}