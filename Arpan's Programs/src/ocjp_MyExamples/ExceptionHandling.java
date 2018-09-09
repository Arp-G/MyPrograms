package ocjp_MyExamples;

import java.util.Scanner;
public class ExceptionHandling {

public void getdata()
{
	System.out.println("Enter a number between 0 to 10");
	try
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		if(a<0 || a>10)
		{
			throw new MyException();
		}
		
		a=a/a;
		System.out.println("Division successfull !");
	}
	catch(MyException e)
	{
		System.out.println("Exception occured : "+e);
	}
	catch(ArithmeticException e)
	{
		System.out.println("Exception occured : "+e);
	}
	finally
	{
		System.out.println("Finally Block");
	}
}
	
	public static void main(String[] args) 
	{
		
		ExceptionHandling obj=new ExceptionHandling();
		
		obj.getdata();
		
	}

}

class MyException extends Exception
{
	private String str="Value entered is out of Range";
	
	public String toString()
	{
		return str;
	}
	
	
}