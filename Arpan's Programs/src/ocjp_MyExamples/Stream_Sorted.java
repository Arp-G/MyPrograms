package ocjp_MyExamples;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;



class Student1 implements Comparable<Student1>
{
    int  roll;
    String name;
    
    Student1(int roll,String name)
    {
        this.roll=roll;
        this.name=name;
    }
    
    public boolean equals(Object obj)
    {
        if(obj instanceof Student1)
        {
            Student1 ob=(Student1)obj;
            if(this.roll==ob.roll && this.name.equals(ob.name)) return true; else return false;
        }
        else 
        {
            return false;
        }
    }
    
    public int compareTo(Student1 obj)
    {
        return this.roll-obj.roll;
    }
    
    public String toString()
    {
        return "Roll no ="+roll+" Name = "+name;
    }
}
public class Stream_Sorted 
{
    static int MyComparator(Student1 ob1,Student1 ob2)
    {
        return ob1.roll-ob2.roll;
    }
    public static void main(String args[])
    {
        
       /* Stream<Student1> s=Stream.of(new Student1(12,"arp"),new Student1(3,"Debo"),new Student1(19,"Adi"));
        
        //s.sorted().forEach(System.out::println);
        
        //s.sorted(Comparator.reverseOrder()).forEach(System.out::println);
        
        s.sorted(Stream_Sorted::MyComparator).forEach(System.out::println);*/
    	
    	String str="arp";
    	
    	boolean b=str.concat("Rokz")==str;
    	
    	System.out.println(b);
        
        
    }
}
