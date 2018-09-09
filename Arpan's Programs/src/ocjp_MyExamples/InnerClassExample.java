package ocjp_MyExamples;

public class InnerClassExample
{
	
	public static void main(String args[])
	{
		Outer outer=new Outer();
		
		Outer.Inner1 inner1= outer.new Inner1();
		
		Outer.Inner1.Inner2 inner2=inner1.new Inner2();
		
		
		inner2.abcTest();
		
		inner2.Method_Class();
		
		
	}

}


class Outer // Outer.class is created upon compilation
{
	String abc="Outer class String";
	int c=30;
	
	
	class Inner1 // Outer$Inner1.class is created upon compilation
	{
		
		String abc="Inner1 class String";
		
		class Inner2
		{
			String abc="Inner2 class String";
			
			void abcTest()
			{
				System.out.println(abc);
				System.out.println(Inner1.this.abc); // Just Inner1.abc wont work as we try to make static reference to non-static variable
				System.out.println(Outer.this.abc);
			}
			
			void Method_Class()
			{
				int a=10;// here a is effectively finally as its value is never changed
				
				//a=20; this wont work
				
				final int b=20;
				
				c=31;
				
				class MethodLocal // This class cannot have static members and cannot have any access specifier like private class MethodLocal
				{
					void product()
					{
						System.out.println("Product of Method Local Inner Class :"+(a*b*c)); // It can only access those variables of the method which are either final or effectively final
						
					}
				}
				
				new MethodLocal().product();
			}
		}
	}
}