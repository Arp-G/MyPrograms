package ocjp_MyExamples;

import java.io.*;

import java.nio.file.*;

public class TestingFileMethods 
{
	public static void main(String args[])throws IOException
	{
		
		
		 Path p1 = Paths.get("c:\\yo\\yo\\..\\temp\\test.txt");    p1=p1.normalize(); System.out.println(p1);
		
		
		File file=new File("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\Resource1\\Resource2\\resource"); // this is directory 
		
		File file1=new File("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\Resource1\\Resource2\\resource11.txt"); // this is a file
		
		System.out.println(file1.createNewFile());// here file1 is actually created
		
		System.out.println(file.getParent());
		
		System.out.println(file1.mkdirs());
		
		System.out.println(file.length());
		
		System.out.println(file.isFile());
		
		System.out.println(file.isDirectory());
		
		File file2=new File("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\zoo.txt");
		
		//System.out.println(file.renameTo(file1)); here if you uncomment this statement then file2 will be created
												//  this shows that a file or directory is never created until its needed
				
	}
}
