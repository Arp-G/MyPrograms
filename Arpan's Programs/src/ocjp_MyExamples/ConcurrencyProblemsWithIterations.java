package ocjp_MyExamples;


/* This program shows that adding or deleting elements from a collection with in a iteration causes a ConcurrentModificationException because before the element that was added or deleted is properly 
 * updated in the collection we try to access the next element in the collection. This problem is not solved using synchronized collection method or using synchronized methods or synchronized blocks
 * it was only solved by using the CopyOnWriteArrayList method on concurrent collections. With CopyOnWriteArrayList when a element is added or deleted a new ArrayList is created every time with the
 * modification while the loop or iteration still uses the previous array thus solving the problem 
 */

import java.util.*;

import java.util.concurrent.*;

public class ConcurrencyProblemsWithIterations 
{
	public static void main(String args[])
	{
		try
		{
			normal_Array();
		}
		catch(ConcurrentModificationException e)
		{
			System.out.println("There was a "+e+" when using normal array lists");
		}
		
		
		concurrent_Array();
		System.out.println("Concurrent Array List that is CopyOnWriteArrayList doesnt cause exception");
			
		try
		{
			synchronized_collection_methods();
		}
		catch(ConcurrentModificationException e)
		{
			System.out.println("There was a "+e+" when using synchronized array lists");
		}	
		
		try
		{
			synchronized_method();
		}
		catch(ConcurrentModificationException e)
		{
			System.out.println("There was a "+e+" when using synchronized methods");
		}
	}



static void normal_Array()
{
	List<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
	
	for(int i:arr)
	{
		System.out.println(i);
		arr.add(i+10);
		
		
	}
}

static void concurrent_Array()
{
	List<Integer> arr=new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
	
	for(int i:arr)
	{
		System.out.println(i);
		arr.add(i+10);
	}	
}


static void synchronized_collection_methods()
{
	List<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));

	List<Integer> arr1=Collections.synchronizedList(arr);
	
	for(int i:arr1)
	{
		System.out.println(i);
		arr.add(i+10);
	}
}

static synchronized void synchronized_method()
{
List<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
	
	for(int i:arr)
	{
		System.out.println(i);
		arr.add(i+10);
	}
}

}