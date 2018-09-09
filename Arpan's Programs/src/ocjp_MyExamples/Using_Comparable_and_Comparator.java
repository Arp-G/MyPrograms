package ocjp_MyExamples;

import java.util.ArrayList; // To use an ArrayList of Student type

import java.util.Collections; // For using sort() and binarySearch() methods

import java.util.Comparator; // For using compare() method to specify additional rules to search for students

import java.lang.Comparable; // This is imported by default , to use compareTo() method

import java.util.Scanner; // To take input from user

final class Student implements Comparable<Student>  // Important
{
	private int Roll=0;
	private String Name="";
	private double Marks=0.0;
	
	
	// Setter and Getter methods
	
	public void SetRoll(int Roll)
	{
		this.Roll=Roll;
	}
	
	public void SetName(String Name)
	{
		this.Name=Name;
	}
	
	public void SetMarks(double Marks)
	{
		this.Marks=Marks;
	}
	
	public int GetRoll()
	{
		return Roll;
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public double GetMarks()
	{
		return Marks;
	}
	
	
	
	public int compareTo(Student obj) // comapreTo defined in Comparable is is overridden here
	{
		return this.Roll-obj.Roll;  //  obj.Roll works here we don't need obj.GetRoll as CompareTo() is a method of class Student so it can access its private members
	}
	
	public boolean equals(Student obj)
	{
		if(this.compareTo(obj)==0) return true; else return false;
	}
}



public class Using_Comparable_and_Comparator 
{

	public static void main(String ...args)
	{
		
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter how many students you want to add");
	
	int n=sc.nextInt();
	
	ArrayList<Student> StudentList=new ArrayList<Student>();
	
	for(int i=0;i<n;i++)
	{
		System.out.println("Enter Roll no , name and marks for student "+(i+1));
		
		Student temp=new Student();
		
		temp.SetRoll(sc.nextInt());
		
		temp.SetName(sc.next());
		
		temp.SetMarks(sc.nextDouble());
		
		StudentList.add(temp);
		
	}
	
	while(true)
	{
		
	System.out.println("Student Search Menu :");
	
	System.out.println("1) Enter 1 to Search student by Roll No");
	
	System.out.println("2) Enter 2 to Search student by name");
	
	System.out.println("3) Enter 3 to Search student by marks");
	
	int choice=sc.nextInt();
	
	System.out.println("Enter Student details to search for");
	System.out.println("Enter Roll , Name and Marks of student");
	
	Student Search=new Student();
	
	Search.SetRoll(sc.nextInt());
	
	Search.SetName(sc.next());
	
	Search.SetMarks(sc.nextDouble());
	
	int target=-1;
	
	switch(choice)
	{
	case 1:
		
				
		Collections.sort(StudentList); // Sorting Students by roll . sort() uses overridden version of compareTo() defined in Student
		
		target=Collections.binarySearch(StudentList, Search); // binarySearch() will use compareTo() to compare student objects by Roll

		
		break;
		
	case 2:
		
		Comparator<Student> ByName = new Comparator<Student>() // Using Anonymous inner class and overriding compare() method of Comparator to specify new sorting rule by Name
		{ 
			public int compare(Student obj1,Student obj2) 
			{
				return (obj1.GetName()).compareTo((obj2.GetName())); // Calls the compareTo() method for String to compare Names of students
			}
		}; // Don't forget ; after anonymous class
		
		Collections.sort(StudentList,ByName); // Passing the new Sorting rule ByName to sort(). sort() will now use overridden version of compare() defined in the anonymous inner class to compare Student objects
		
		target=Collections.binarySearch(StudentList, Search , ByName); // binarySearch() will now compare student objects by Name
		
		break;
		
	case 3:
		
		Comparator<Student> ByMarks = (obj1,obj2) ->(int) ( obj1.GetMarks() - obj2.GetMarks() ) ; // Here Marks is of type double so cast it to int before returning as compare() returns int 
		
		// Using Lambda expression and overriding compare() method of Comparator to specify new sorting rule by Marks
			
				
		Collections.sort(StudentList,ByMarks); // Passing the new Sorting rule ByMarks to sort(). sort() will now use overridden version of compare() defined in the lambda expression to compare Student objects
		
		target=Collections.binarySearch(StudentList, Search , ByMarks); // binarySearch() will now compare student objects by Marks
		
		break;
		
		default :
			
			System.out.println("Wrong Choice");
				
	}
	
	
	if(target<0) { System.out.println("Student doesnot exist"); } else
	 
	{
		System.out.println("Student was found at index "+target);
	
		System.out.println("Student details are :");
	
		Student Found=StudentList.get(target);
		
		System.out.println("Student Roll = "+Found.GetRoll());
	
		System.out.println("Student Name is "+Found.GetName());
	
		System.out.println("Student Marks is "+Found.GetMarks());
	
	}
	
	System.out.println("Search again ? (Yes/No) ");
	String ch=sc.next();
	
	if( !(ch.equalsIgnoreCase("Yes")) ) break;
	
	}		
	
	
	sc.close();
	
	}
	

	
}
