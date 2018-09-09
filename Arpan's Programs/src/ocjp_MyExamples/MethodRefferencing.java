package ocjp_MyExamples;

interface consface
{
    MethodRefferencing test();
}



interface voidface
{
    void test();
}

interface intface
{
    String test(int a);
}



public class MethodRefferencing {
    
  
  MethodRefferencing()
  {
      System.out.println("My Class Constructor");
  }
  
  void Meth()
  {
       System.out.println("void meth() called");
  }
  
  String IntMeth(int a)
  {
      return "IntMeth() called with parameter "+a;
  }
  
  static void StaticMeth()
  {
      System.out.println("Static method() called");
  }
    
    public static void main(String args[]) 
    {
        consface Constructor_Refference = MethodRefferencing::new;  // Constructor reference acquired
        
        MethodRefferencing obj=Constructor_Refference.test(); // Constructor called and object created with the help of constructor reference
        
        voidface Meth_Refference = obj::Meth; // Reference of Meth() is acquired using object "obj" of MethodRefferencing
        
        intface IntMeth_Refference = obj::IntMeth; // Reference of IntMeth() is acquired using object "obj" of MethodRefferencing
        
        voidface StaticMeth_Refference = MethodRefferencing::StaticMeth; // StaticMeth() is a static method so we directly call it without using object... trying to call it using object by obj::StaticMeth will give error
        
        // Using method references to call methods
        
        Meth_Refference.test(); 
        
        System.out.println ( IntMeth_Refference.test(10) );
        
        StaticMeth_Refference.test();
    }
}
