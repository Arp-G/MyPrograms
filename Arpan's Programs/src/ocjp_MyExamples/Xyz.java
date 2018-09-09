package ocjp_MyExamples;

import java.io.*;
import java.util.*;


public class Xyz implements Serializable
{
	Object ob=new Object();
	
	
	static void createFile(Aa obj , File dataFile)throws IOException
	{
		try( ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile))))
		{
				out.writeObject(obj);
		}
	}
	
	static Aa ReadFile(File dataFile)throws IOException,ClassNotFoundException
	{
		
		Aa temp=null;
		
		try( ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile))))
		{
			
				Object ob=in.readObject();
				temp=(Aa)ob;
				 
					
			
		}
		catch(EOFException e)
		{
			//File end Reached
		}
		
		return temp;
	}
	
	public static void main(String args[])throws IOException,ClassNotFoundException
	{
		File file=new File("C:\\Users\\arpan\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\xyz.txt");
		
		Aa ob=new Aa();
		
		ob.var="Changed"; // CHECK THIS OUT !!!!!!!!!!!!!
		
		createFile(ob,file);
		
		System.out.println("----------------------------");
		
		Aa tmp=ReadFile(file);
		
		System.out.println(tmp.var);
		
		System.out.println(tmp.var1);
		
	}
}



/*
 * Java will call the constructor for the first non-serializable no-arguments parent class during 
 * deserialization, skipping any constructors and default initializations for serializable classes in between 
 */





class Aa extends Bb  implements Serializable
{
	String var1="Class Aa instance Variable"	;
	
	Object ob; // This wont be a problem during Serialization
	
 // Object ob=new Object(); this will cause NotSerializableException since Object class cannot be Serialized
	
	Aa()
	{
		System.out.println("Constructor of class A");
	}
}

class Bb extends Cc  
{
	Bb()
	{
		System.out.println("Constructor of class B");
	}
}


class Cc  extends Dd
{
	
	
	Cc()
	{
		System.out.println("Constructor of class C");
	}
}

class Dd
{
	String var="Class Dd instance Variable"	;
	Dd()
	{
		
		System.out.println("Constructor of class D");
	}
}


