package ocjp_MyExamples;

 interface TempCons<T,R> //Functionl Inteface for constructor of Myclass1
 {
	  Myclass1<T,R>func(T obj1,R obj2);
 }
 
 interface TempFunc1<T,R>//Functional Interface for MyclassFunc1 of Myclass1
 {
	 void func(T obj1,R obj2);
 }
 
 interface TempFunc2//Functional Interface for MyclassFunc2 of Myclass1
 {
	 void func();
 }
 

class Myclass1<T,R>
 {
	 
	 
	 Myclass1()
	 {
		 System.out.println("Default Constructor Called !");
		 
	 }
	 
	 <T> Myclass1(T a)
	 {
		 System.out.println("Constructor Type 1 Called !");
		 
	 }
	 
	 <T> Myclass1(T a,String x)
	 {
		 System.out.println("Constuctor Type 2 Called !");
		
	 }
	 
	 <T,R>void MyclassFunc1(T x,R y)
	 {
		 System.out.println("MyClass1 instance function called");
	 }
	 
	 static void MyclassFunc2()
	 {
		 System.out.println("MyClass1 static function called");
	 }
 }
 
 class FunctionAsArgument
 {
	 static <T,R> void caller(TempFunc1<T,R> f,T x,R y)
	 {
		 f.func(x,y);
	 }
	 
	 static void caller1(TempFunc2 f) 
	 {
		 f.func();
	 }
	 public static void main(String ...arps)
	 {
		 TempCons<Integer,String> cons=Myclass1<Integer,String>::new; //Creating constructor reference of Myclass1 in cons
		 
		 Myclass1<Integer,String> obj=cons.func(10,"Arpan"); //Using the constructor reference to create an object/instance of the Myclass1
		 
		 obj.MyclassFunc1(10, "Arp"); // Using the object created to directly call a function of Myclass1
		 
		 caller(  obj::<Integer,String>MyclassFunc1  ,12,"Arp"); //Calling " MyclassFunc1() " via " caller() " function  this is an example of passing function as argument via object obj::
		 
		 caller1( Myclass1::MyclassFunc2 );////Calling " MyclassFunc2() " via " caller1() " function  this is an example of passing static function as argument via Myclass1::
		 
	}
 }