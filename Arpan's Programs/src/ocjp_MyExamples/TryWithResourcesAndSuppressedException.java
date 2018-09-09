package ocjp_MyExamples;

// This program tells about the order in which exceptions are executed in try-with-resources and when exception are suppressed. See the output to understand the order

interface Testing{}

class Example_class implements AutoCloseable // To be used with try-with-resources Example_class must implement AutoCloseable or Closeable
{
	int number=0;
	
	Example_class(int number)
	{
		this.number=number;
		
		// throw new RuntimeException("new exception from "+number); // if we throw exception here then try block will never execute
	}
	
	public void close() throws Exception
	{
		System.out.println("Close() was called for Example_class number = "+number);
		
		throw new Exception("Exception in Close() for Example_class number = "+number);
	}
}


public class TryWithResourcesAndSuppressedException
{
	public static void main(String args[])
	{
			
		try(Example_class eg1=new Example_class(1);  Example_class eg2=new Example_class(2))
		{ 
			System.out.println("Inside try block");
			throw new Exception("Exception from try block");
			
		}
		catch(Exception e)
		{
			System.out.println("Primary Exception is "+e.getMessage());

			System.out.println("Number of suppressed Exceptions = "+e.getSuppressed().length); //Throwable[] getSuppressed() returns an array of suppressed exceptions
			
			for(Throwable t:e.getSuppressed())
			{
				System.out.println(t.getMessage());
			}
		}
		
	}
}	
