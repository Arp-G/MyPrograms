package ocjp_MyExamples;

import java.io.*;
import java.util.*;

public class Serialization
{
	static void createFile(List<Child> children , File dataFile)throws IOException
	{
		try( ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile))))
		{
			for(Child child:children)
				out.writeObject(child);
		}
	}
	
	static List<Child>ReadFile(File dataFile)throws IOException,ClassNotFoundException
	{
		List<Child> children=new ArrayList<Child>();
		
		try( ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile))))
		{
			while(true)
			{
				Object ob=in.readObject();
				
				if(ob instanceof Child)
					children.add( (Child) ob);
					
			}
		}
		catch(EOFException e)
		{
			//File end Reached
		}
		
		return children;
	}
	
	public static void main(String args[])throws IOException,ClassNotFoundException
	{
		File file=new File("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\ResourcesSerealizedChildObjects.txt");
		
		List<Child> childArray=new ArrayList<>();
		
		Parent.sp="Parent class static variable newly set";
		
		Child.sc="Child class static variable";
		
		childArray.add(new Child(1));
		//childArray.add(new Child(2));
		//childArray.add(new Child(3));
		
		createFile(childArray,file);
		
		List<Child> children=ReadFile(file);
		
		System.out.println("Child Objects written are..");
		
		for(Child child:childArray)
		{
			System.out.println(child);
		}
		
		System.out.println("Child Objects read are..");
		
		for(Child child:children)
		{
			System.out.println(child);
		}
		
		
	}
	
}




class Parent implements Serializable
{
	// Object ob=new Object(); We cannot store an object of Object Class in this class because the Object class does not implement the Serializable interface
	//hence we will get a java.io.NotSerializableException
	
	private static final long serialVersionUID = 1L;

	static String sp="Parent class static variable";
	
	String ip="Parent class normal instance variable";
	
	transient String tp="Parent class transient instance variable";
	
	static transient String stp="Parent class static transient variable";
	
}


class Child extends Parent implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	
	
	//Serialization ob=new Serialization();  We cannot store an object of class Serialization in class Child because class Serialization does not implement the Serializable interface
										   //hence we will get a java.io.NotSerializableException
	
	static String sc;;
	
	String ic="Child class normal instance variable";
	
	transient String tc="Child class transient instance variable";
	
	static transient String stc="Child class static transient variable";
	
	static int v1;
	
	static Double v2;
	
	static boolean v3;
	
	static Boolean v4;
	
	static double v5;
	
	public Child(int x)
	{
		super();
		
		sc="Child class static variable set by child class constuctor . number = "+x;
		
		ic="Child class normal instance variable  set by child class constuctor . number = "+x;
		
		tc="Child class transient instance variable  set by child class constuctor . number = "+x;
		
		stc="Child class static transient variable  set by child class constuctor . number = "+x;
		
		// Constructor is never called during Deserialization
	}
	
	public String toString()
	{
		String lsp=System.getProperty("line.separator");
		return  ""+lsp+sp+lsp+ip+lsp+tp+lsp+stp+lsp+lsp+""+sc+lsp+ic+lsp+tc+lsp+stc+lsp+v1+lsp+v2+lsp+v3+lsp+v4+lsp+v5+lsp;
	}
}