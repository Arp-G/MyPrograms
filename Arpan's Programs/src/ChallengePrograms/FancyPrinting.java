package ChallengePrograms;

public class FancyPrinting 
{
	
	static void print(String text,int gap) throws InterruptedException// gap is the time to sleep in milliseconds
	{
		for(int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			
			Thread.sleep(gap);
		}
	}
	
	static void print(String text) throws InterruptedException // Default version sleeps for 50 milliseconds after printing each character
	{
		for(int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			
			Thread.sleep(50);
		}
	}
	
	static void println(String text,int gap) throws InterruptedException// gap is the time to sleep in milliseconds , also changes line after printing
	{
		for(int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			
			Thread.sleep(gap);
		}
		
		System.out.println();
	}
	
	static void println(String text) throws InterruptedException // Default version sleeps for 50 milliseconds after printing each character , also changes line after printing
	{
		for(int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			
			Thread.sleep(50);
		}
		
		System.out.println();
	}
	
	public static void main(String ...args) throws InterruptedException
	{
		println("Hi this a test of Fancy Printing. Here the default sleep is 50 milliseconds. Fancy printing makes text displayed more interesting to watch... ");

		print("Hi this anouther test of Fancy Printing. Here the sleep is 100 milliseconds. Fancy printing makes text displayed more interesting to watch... ",300);
	}
	
}
