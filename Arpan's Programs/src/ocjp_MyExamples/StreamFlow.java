package ocjp_MyExamples;

import java.util.stream.*;

class MyClass  // THis shows the flow or manner in which elements in a stream are evaluated. That is elements are not evaluated all at once but are evaluated one by one
{
    String name;
    
    int age;
    
    MyClass(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    
    public boolean equals(Object a)
    {
        System.out.println("Equlas was called for "+this);
           
        if(a instanceof MyClass)
        {
            MyClass aa=(MyClass)a;
            if((this.name).equals(aa.name) && this.age==aa.age) return true;
            else return false;
        }
        else return false;
    }
    
    public int hashCode()
	{
		return age;
	}
    
    public String toString()
    {
        return this.name+"   "+this.age;
    }
}

public class StreamFlow
{
    public static void main(String args[]) 
    {
        Stream<MyClass> str=Stream.of(  new MyClass("Arp",10)  ,   new MyClass("Sap",13) , new MyClass("Arp",10)   ,   new MyClass("Adi",45)  ,   new MyClass("Sap",13)  ,    new MyClass("jobar",60)   );
        
        str.distinct().forEach(a->System.out.println("in stream "+a));
    }
}
