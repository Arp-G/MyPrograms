package ocjp_MyExamples;


import java.util.*;

interface X{}

class A implements X
{}

class B extends A{}

class C extends B{}







public class GenericsProblems {
    
    void test()
    {
        List<? super C> ref=new ArrayList<B>();
        
        ref.add(new C());
        
        // ref.add(new B());  Invalid as compiler doesn't know about new ArrayList<B>()
        
        // ref.add(new A());  Invalid as compiler doesn't know about new ArrayList<B>()
        
        // X y=new C(); 
        
        // ref.add(y); Invalid
        
    }
    
    
    void test1()
    {
      List<Integer> number = new ArrayList<>();
      
      // List<Object> object = number;    This doesnt work we cannot assign ArrayList<Integer> to ArrayList<Object> but this works/compiles 
      //                                  in case of arrays but gives ArrayStoreException at runtime as seen in test2() method
      
    }
    
    
    void test2()
    {
        Integer[] number = {new Integer(10)};
        
        Object object[] = number;
        
        object[0] = 0;
        
        object[0] = "Zero"; // this will give ArrayStore exception when run
    }
    
    
    
    void test3()
    {
        
        test_test(new ArrayList<String>());
    }
    
    void test_test(List<?> list)
    {
    }
    
    public static void main(String args[]) 
    {
        System.out.println("test");
    }
}
