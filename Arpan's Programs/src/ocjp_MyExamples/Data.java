package ocjp_MyExamples;

import java.io.*;

public class Data implements java.io.Serializable
{        
	public static String f1="yo";    
	public static transient int f2;   
	public transient boolean f3;       
	public final static String f4 = "4";    
	public String f5 = "5"; 
	 

	public static void main(String args[])throws Exception
	{

		Data d = new Data(); 

		d.f1 = "f1"; 

		d.f2 = 2; 

		d.f3 = true;
		
		try( ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\arpan\\Desktop\\testing.txt"))))
		{
				out.writeObject(d);
		}
		
		try( ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\arpan\\Desktop\\testing.txt"))))
		{
			Data ob=(Data)in.readObject();
			
			System.out.println(ob.f1);
			System.out.println(ob.f2);
			System.out.println(ob.f3);
			System.out.println(ob.f4);
			System.out.println(ob.f5);
				
		}
		
	}
	
}
	
	