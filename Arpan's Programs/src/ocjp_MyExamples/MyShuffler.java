package ocjp_MyExamples;

import java.util.*;

public class MyShuffler
{
    
   static <T> List<T> shuffler(List<T> array)
    {
        int len=array.size();
        int r1,r2;
        
        T tmp;
        
        Random ran=new Random();
        
        
        int NoOfShuffles=ran.nextInt(len)*ran.nextInt(len); // carry out ran.nextInt(len)*ran.nextInt(len) number of shuffles
        
       // System.out.println("Doing "+NoOfShuffles+" shuffeles");
        
        for(int i=0;i<NoOfShuffles;i++) 
        {
            r1=ran.nextInt(len);
            
            r2=ran.nextInt(len);
            
           // System.out.println("Swapping indes "+r1+" with index "+r2);
            
            tmp=array.get(r2);
            array.set(r2,array.get(r1));
            array.set(r1,tmp);
            
        }
        
        return array;
    }
    
    
    public static void main(String args[]) 
    {
        List<StudentDemo> stuArray=new ArrayList<StudentDemo>( Arrays.asList(new StudentDemo("Arp",10),new StudentDemo("Debo",12),new StudentDemo("Adi",33),new StudentDemo("Sourav",66),new StudentDemo("Godai",77),new StudentDemo("Sap",35),new StudentDemo("Samrat",3)) );
        
        System.out.println("Before shuffle : "+ stuArray);
        
        System.out.println("After shuffle : "+ shuffler(stuArray));
    }
}


class StudentDemo
{
    String Name;
    int roll;
    
    StudentDemo(String Name,int roll)
    {
        this.Name=Name;
        this.roll=roll;
    }
    
    public String toString()
    {
        return roll+"  "+Name;
    }
}
