package java_training;



public class Testing 
{
	static int id=101;
	
	String name="NSHM";
	
	public void display()
	{
		System.out.println(id);
		System.out.println(name);
	}
		
	 public static void main(String args[]) 
	    {
	        new Testing().id=102;
	        
	        System.out.println(new Testing().id);
	    }
}
