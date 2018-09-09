package ocjp_MyExamples;

public class Anonymous_Inner_Class 
{
	abstract class A
	{
		abstract void yolo();
				
	}
	
	interface B
	{
		public abstract void yolo();
	}
	
	B test()
	{
		
		A ref1=new A() { 
			
			void yolo()
			{
				System.out.println("This is an anonymous class example using ABSTRACT CLASS");
			}
		
		};
		
		ref1.yolo();
		
		B ref2=new B() {
			
			public void yolo()// dont forget to add public.. interface methods must be public
			{
				System.out.println("This is an anonymous class example using INTERFACE");
			}
		
		};
		
		ref2.yolo();
		
		return new B() {
						
			public void yolo()
			{
				System.out.println("This is anouther style to declare and use an anonymous inner class");
			}
		};
			
	}
	
	
	public static void main(String ...args)
	{
		
		Anonymous_Inner_Class obj=new Anonymous_Inner_Class();
		
		Anonymous_Inner_Class.B ref= obj.test();
		
		ref.yolo();
		
		
	}
		
}


