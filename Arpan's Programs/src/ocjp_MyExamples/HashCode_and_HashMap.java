package ocjp_MyExamples;

/*
  A Map is nothing but a set of buckets holding key-value pairs. Each bucket corresponds to a unique hashcode. When you store a key-value pair in a Map, the following things happen:

1. Hashcode of the key is computed. This key is used to identify the bucket where the key-value must be stored.
2. The key - value pair is stored in that bucket wrapped in a Map.Entry object.
3. If multiple keys have same hashcode value, all those key-value pairs are stored in the same bucket.

Now, a look up in a Map is a three step process:

1. Hashcode of the key is computed. This code is used to identify the bucket where the key should be looked for.
2. For all the key-value pairs in that bucket, check whether the supplied key is equal to the key in the bucket using equals() method.
3. If a match exists, return the value, otherwise, return null.

As you can see, it is critically important to make sure that hashCode() method return the same value for two objects that are equal as per equals() method.
 If this rule is not followed, you will not be able to retrieve the value from the map using another key object that is equal to the key object stored in the map.

Remember this problem only happens when using HashMap and not overriding Hashcode also this wont happen if we have keys in hashmap for which hashcode() is overriden.
Here the problem arises since we use STudent object as key in map for which we don't have hashcode overriden.

 */


import java.util.*;

public class HashCode_and_HashMap 
{
    public static void main(String args[]) {
        
        Map<MyStudent,String> map=new HashMap<>();
        
       // Map<Student,String> map=new TreeMap<>(); this wont cause a problem even without overriding hashCode() only HashMap depends on hashCode()
        
        map.put(new MyStudent(10,"Arp"),"Arp Student"); // Here the key values in the map are of type Student
        map.put(new MyStudent(15,"debo"),"Debo Student");
        map.put(new MyStudent(13,"Adi"),"Adi Student");
        
        System.out.println(map.get(new MyStudent(10,"Arp"))); // although Student "Arp" is there still this gives null
    }
}

class MyStudent implements Comparable<MyStudent>
{
    int roll;
    String name;
    
    MyStudent(int roll,String name)
    {
        this.name=name; this.roll=roll;
        
    }
    
    String getName(){ return this.name; }
    int getRoll(){ return this.roll; }
    
    public int compareTo(MyStudent o)
    {
        return this.roll-o.roll;
    }
    
    public String toString()
    {
        return roll+"  "+name;
    }
    
    public boolean equals(Object ob)
    {
        if(ob instanceof MyStudent)
        {
        	MyStudent tmp=(MyStudent)ob;
            
            if(tmp.name.equals(this.name) && tmp.roll==this.roll) return true;
            else return false;
        }
        else return false;
    }
    
   /* public int hashCode() //This will make HashMap work properly as expected
    {
        return this.roll;
    }*/
}