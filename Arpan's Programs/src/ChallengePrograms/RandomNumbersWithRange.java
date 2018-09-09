package ChallengePrograms;

import java.util.Random;

public class RandomNumbersWithRange 
{
	 public static void main(String[] args) 
	 {
	        for (int i = 0; i < 5; i++) // Generate 5 random numbers between 50 to 100
	        {
	            System.out.println("Random Number:- " + randomNumberInRange(50, 100));
	        }
	  }
	 
	    public static int randomNumberInRange(int min, int max) 
	    {
	        Random random = new Random();
	        
	        return random.nextInt((max - min) + 1) + min;
	    }
}
