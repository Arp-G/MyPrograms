package ChallengePrograms;


import java.util.*;



public class UniqueRandomNumbers 
{

    public static void main(String[] args) 
    {
        List<Integer> list = getnumbers(50,65);
        
        for(int i:list)
        {
        	System.out.print(i+" , ");
        }
              
    }
    
    static List<Integer> getnumbers(int low,int high) // returns an array of random numbers between low and high both inclusive
    {
    	List<Integer> nos=new ArrayList<>();
    	
    	for (int i=low; i<=high; i++) 
        {
            nos.add(i);
        }
    	
        Collections.shuffle(nos);
        
       return nos;
    }
}