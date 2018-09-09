package ChallengePrograms;
import java.util.Scanner;


public class MyQueue<T>
{
	Node Front,Rear,Head;
	int Size,NodeCount;
	
	MyQueue(int Size,T value)
	{
		Front=Rear=null;
		NodeCount=0;
		this.Size=Size;
		InsQueue(value);
	}
	
	<T> void InsQueue(T obj)
	{
		if(NodeCount==Size)
		{
			System.out.println("Queue Overflow");	
		}
		else
		{
			Node<T> nd=new Node<T>(obj);
			
			if(Rear==null)
			{
				System.out.println("Queue Created of Size "+Size+"  and type :  "+obj.getClass().getName());
				Front=Rear=Head=nd;
				NodeCount++;
			}
			else
			{
				Rear.prev=nd;
			
				nd.next=Rear;
			
				Rear=nd;
			
				NodeCount++;
			}
			
		
		displayQueue();
		}
	}
	
	void delqueue()
	{
		if(Front==null)
		{
			System.out.println("Queue Underflow");
		}
		else
		{
			if(NodeCount==1)
			{
				Front=Rear=null;
				NodeCount=0;
			}
			else
			{
			Front=Front.prev;
			
			Front.next=null;
			
			NodeCount--;
			}
		}
		
		displayQueue();
	}
	
	void displayQueue()
	{
		System.out.println();
		System.out.println();
		System.out.println("Current Queue Status");
		System.out.println("Number of Nodes : "+NodeCount);
		System.out.println();
		
		Node temp=Rear;
		while(temp!=null)
		{
			System.out.print(temp.value+" , ");
			temp=temp.next;
		}
		System.out.println();
		System.out.println();
	}
	
	public static void main(String args[])
	{
		int size,ch=0,chh=0;
	
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Queue Menu :");
		System.out.println("--------------------------");
		System.out.println("Choose 1 for Integer Queue");
		System.out.println("Choose 2 for Boolean Queue");
		System.out.println("Choose 3 for Double Queue");
		System.out.println("Choose 4 for String Queue");
		
			
		do
		{
			ch=sc.nextInt();
			
			System.out.println("Enter the size of the Queue");
			
			size=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				System.out.println("Enter first Integer value in Queue");
				int value=sc.nextInt();
				MyQueue<Integer> IQ=new MyQueue<Integer>(size,value);
				do
				{
				System.out.println("Integer Queue Menu :");
				System.out.println("--------------------------");
				System.out.println("Choose 1 for Insertion in Queue");
				System.out.println("Choose 2 for Deletion in Queue");
				System.out.println("Choose 3 to Display Queue Elements");
				System.out.println("Choose 4 to Exit");
				
				chh=sc.nextInt();
				
				switch(chh)
				{
					case 1:
						System.out.println("Enter an integer value to insert in the queue");
						value=sc.nextInt();
						IQ.InsQueue(value);
						break;
					
					case 2:
						IQ.delqueue();
						break;
						
					case 3:
						IQ.displayQueue();
						break;
						
					case 4:
						System.out.println("Exiting....");
						ch=0;
						break;
						
						default:
							System.out.println("Wrong choice exiting...");
							ch=0;
				}
				
				}while(ch!=0);
				
				break;
				case 2:
				
					System.out.println("Enter first boolean value in Queue");
					Boolean value1=sc.nextBoolean();
					MyQueue<Boolean> BQ=new MyQueue<Boolean>(size,value1);
				do {
					System.out.println("Boolean Queue Menu :");
					System.out.println("--------------------------");
					System.out.println("Choose 1 for Insertion in Queue");
					System.out.println("Choose 2 for Deletion in Queue");
					System.out.println("Choose 3 to Display Queue Elements");
					System.out.println("Choose 4 to Exit");
				
					chh=sc.nextInt();
				
					switch(chh)
					{
						case 1:
							System.out.println("Enter an Boolean value to insert in the queue");
							value1=sc.nextBoolean();
							BQ.InsQueue(value1);
							break;
					
						case 2:
							BQ.delqueue();
							break;
						
						case 3:
							BQ.displayQueue();
							break;
						
						case 4:
							System.out.println("Exiting....");
							ch=0;
							break;
						
							default:
								System.out.println("Wrong choice exiting...");
								ch=0;
					
					
					
					}
				}while(ch!=0);
				
					break;
					
					
					
				case 3:
					
					System.out.println("Enter first Double value in Queue");
					Double value2=sc.nextDouble();
					MyQueue<Double> DQ=new MyQueue<Double>(size,value2);
				
					do
					{
					
					System.out.println("Double Queue Menu :");
					System.out.println("--------------------------");
					System.out.println("Choose 1 for Insertion in Queue");
					System.out.println("Choose 2 for Deletion in Queue");
					System.out.println("Choose 3 to Display Queue Elements");
					System.out.println("Choose 4 to Exit");
				
					chh=sc.nextInt();
				
					switch(chh)
					{
						case 1:
							System.out.println("Enter a Double value to insert in the queue");
							value2=sc.nextDouble();
							DQ.InsQueue(value2);
							break;
					
						case 2:
							DQ.delqueue();
							break;
						
						case 3:
							DQ.displayQueue();
							break;
						
						case 4:
							System.out.println("Exiting....");
							ch=0;
							break;
						
							default:
								System.out.println("Wrong choice exiting...");
								ch=0;
					}
				
					}while(ch!=0);
					
					break;
					
					
				case 4:
					
					System.out.println("Enter first String value in Queue");
					String value3=sc.next();
					MyQueue<String> SQ=new MyQueue<String>(size,value3);
				
					do
					{
					System.out.println("String Queue Menu :");
					System.out.println("--------------------------");
					System.out.println("Choose 1 for Insertion in Queue");
					System.out.println("Choose 2 for Deletion in Queue");
					System.out.println("Choose 3 to Display Queue Elements");
					System.out.println("Choose 4 to Exit");
				
					chh=sc.nextInt();
				
					switch(chh)
					{
						case 1:
							System.out.println("Enter a String value to insert in the queue");
							value3=sc.next();
							SQ.InsQueue(value3);
							break;
					
						case 2:
							SQ.delqueue();
							break;
						
						case 3:
							SQ.displayQueue();
							break;
						
						case 4:
							System.out.println("Exiting....");
							ch=0;
							break;
						
							default:
								System.out.println("Wrong choice exiting...");
								ch=0;
					}
					
					}while(ch!=0);
				
					break;
			
				default:
				{
					System.out.println("Wrong choice ... Enter choice again ");	
					ch=0;
				}
		
			}
			}while(ch==0);
		
		}
	}
		

class Node<T>
{
	T value;
	Node next,prev;
	Node(T value)
	{
		this.value=value;
		next=prev=null;
	}

}

	
			
		
	
	
	
	

