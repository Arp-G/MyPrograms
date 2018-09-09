package ChallengePrograms;
/* 
 * This Program is an example of passing lambda expressions as arguments.
 *  It passes a lambda expression stored in a reference of the functional interface "test"
 *  and also passes two generic data to a function "EqualCheck"
 *  The function EqualCheck uses the lambda expression to check if the two  generic data
 *  are equal or not. If they are equal it passes a true boolean value and if
 *  they are not equal in generates a "Object Not Equal" User Defined Exception
 */



interface Test<T>
{
	boolean func(T x,T y);
}


public class LambdaTest 
{
	
	
	<T> boolean EqualCheck(Test ob,T str1,T str2)
	{
		return ob.func(str1,str2);
	}
	
	public static void main(String args[])throws ObjectNotEqualException
	{
		
		Test ref=(str1,str2)->{
			if(str1.equals(str2)) return true;
			else return false;
		};
		
		LambdaTest obj=new LambdaTest();
		
		if  ( obj.EqualCheck(ref, "Arpan" , "Arpan") )
		
		{
			System.out.println("Objects are equal");
		}
		else
		{
			throw new ObjectNotEqualException();
		}
	}

	
}

class ObjectNotEqualException extends Exception
{
	ObjectNotEqualException()
	{
		super("Object Not Equal Exception");
	}
}
