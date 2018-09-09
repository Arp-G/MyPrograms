package java_training;

import java.util.Scanner;

public class NumberPlay 
{
	public static void main(String args[])
	{
		System.out.println("Enter a number");
		Scanner sc=new Scanner(System.in);
		Integer n=sc.nextInt();
	
		long sq=n*n;
	
		String str= ((Long)sq).toString();
	
		int len=str.length();
		
		try
		{
			
			if(len%2!=0)
			{
				throw new WrongInputException(n);
			}
		}
		catch(WrongInputException e)
		{
			System.out.println(e);
			throw new ArithmeticException();
		}
	
		String s1=str.substring(0,len/2);
	
		String s2=str.substring(len/2,len);
	
		int chk=Integer.parseInt(s1)+Integer.parseInt(s2);
	
		if(n==chk) System.out.println(n+" is a the number");
		else System.out.println(n+" is not a the number");
		sc.close();
	}
		
}


class WrongInputException extends Throwable
{
	int n;
	WrongInputException(int n)
	{
		this.n=n;
	}
	
	public String toString()
	{
		return n+" is a invalid number input";
	}
}