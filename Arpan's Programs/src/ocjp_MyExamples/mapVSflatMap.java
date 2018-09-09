package ocjp_MyExamples;

import java.util.stream.*;
import java.util.*;

public class mapVSflatMap 
{
    public static void main(String args[]) 
    {
        int a[]={1,2,3};
        
        ArrayList<Integer> arr1=new ArrayList<>(); 
        
        arr1.add(1); arr1.add(2); arr1.add(3);
        
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        
        ArrayList<String> arr3=new ArrayList<String>(); arr3.add("Four"); arr3.add("Five"); arr3.add("Six");
        
        Stream<ArrayList> str=Stream.of(arr1,arr2,arr3);
        Stream<ArrayList> str1=Stream.of(arr1,arr2,arr3);
        
        System.out.println("Output of map() :");
        System.out.println("-------------------");
        
        str.map(x->x).forEach(System.out::print);
        
        System.out.println();
        System.out.println();
        System.out.println("Output of flatMap() :");
        System.out.println("----------------------");
        
        str1.flatMap(x->x.stream()).forEach(System.out::print);
        
        
                        
    }
    
}
