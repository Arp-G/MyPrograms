package ChallengePrograms;

import java.util.*;

public class PasswordGenerator
{
	public static void main(String args[])
	{
		System.out.println(passGenerator(10));
	}
	
	static String passGenerator(int length)
	{
		
		Character[] alphabets= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		Character[] numbers= {'1','2','3','4','5','6','7','8','9','0'};
		
		Character[] specialchars= {'~','!','@','#','$','%','^','&','*','(',')','-','+','*','/'};
		
		List<Character> pool=new ArrayList<>();
		
		pool.addAll(Arrays.asList(alphabets));
		
		pool.addAll(Arrays.asList(numbers));
		
		pool.addAll(Arrays.asList(specialchars));
		
		
		
		
		String pass="";
		
		for(int i=0;i<length;i++)
		{
				Collections.shuffle(pool);
				
				Random rn=new Random();
				
				//rn.nextInt((max - min) + 1) + min
				
				if((rn.nextInt((2-1)+1)+1)==1) pass=pass+Character.toLowerCase(pool.get(0)); // Generate a Random number 1 or 2 if 1 is generated insert lowercase char in pass else insert uppercase char
				else
				pass=pass+pool.get(0);
		}
		
		return pass;
	}
}
