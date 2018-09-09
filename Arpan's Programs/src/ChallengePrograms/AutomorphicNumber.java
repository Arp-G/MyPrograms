package ChallengePrograms;


/*an automorphic number (sometimes referred to as a circular number) is a number whose 
 * square "ends" in the same digits as the number itself. For example, 52 = 25, 62 = 36, 762 = 5776, 3762 = 141376,and 8906252 = 793212890625*/

import java.util.Scanner;

public class AutomorphicNumber
{
	int number;
	
	
	public static void main(String args[])
	{
		System.out.println("Enter a number");
		Scanner sc=new Scanner(System.in);
		Integer n=sc.nextInt();
		
		Long sq=(long)n*n;
		
		String number=n.toString();
		
		String square=sq.toString();
		
		int number_len=number.length();
		
		int square_len=square.length();
		
		String chk=square.substring(square_len-number_len, square_len);
		
		System.out.println("The square of "+number+" is "+square);
		
		if(chk.equals(number)) System.out.println(number+" is an automorphic number");
		else System.out.println(number+" is not an automorphic number");
		
		
		
	}
}
