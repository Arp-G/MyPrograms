package ChallengePrograms;
import java.util.ArrayDeque;

interface Drawable<T>
{
	T GetLeftChild(); // Return the Left Child of the current node
	
	T GetRightChild(); // Return the Right Child of the current node
	
	// A redundant node is just a node with any value(s). These value(s) can never be a value for a normal node
	
	// Every redundant node should have the same values and should return true when IsRedundant() method is called on it
	
	Drawable<T> SetLeftChild();  // Set the Left Child of the current node to a redundant node and return that redundant node
	
	Drawable<T> SetRightChild(); // Set the Right Child of the current node to a redundant node and return that redundant node
	
	boolean IsRedundant(); // Check to see if the current node is redundant or not
	
	String Print(); // Return a String that will be printed for this node
	
	public void setCount(int count); // Have a count value for each node and just set it to the count value passed (this.count=count)
	
	public int getCount(); //Return the count value

}



class Family implements Drawable<Family>
{
	String Name;
	
	int Age;
	
	Family LeftChild;
	
	Family RightChild;
	
	int count;
	
	Family(String Name,int Age)
	{
		this.Name=Name;
		this.Age=Age;
		LeftChild=RightChild=null;
	}
	
	public Family GetLeftChild() 
	{
		return LeftChild;
	}
	
	public Family GetRightChild() 
	{
		return RightChild;
	}
	
	public Drawable<Family> SetLeftChild()
	{
		this.LeftChild=new Family("X",0);
		return this.LeftChild;		
	}
	
	public Drawable<Family> SetRightChild()
	{

		this.RightChild=new Family("X",0);
		return this.RightChild;
		
	}
	
	public boolean IsRedundant()
	{
		if(this.Name.equals("X") && this.Age==0) return true;
		
		else return false;
	}

	
	public void setCount(int count)
	{
		this.count=count;
	}
	
	public int getCount()
	{
		return this.count;
	}

	public String Print()
	{
		return Name+","+Age;
	}
	
}




class Tree_Builder<T extends Drawable<T>>
{
	    static int MaxNodeSize=0;
	    
	    static int NoOfLevels=0;
		
		static int NoOfLeaves=0;
		
		
		public static void main(String args[])
		{
			
			Family Node1=new Family("GrandFather",98);
			
			Family Node2=new Family("Father",60);
			
			Family Node3=new Family("Uncle",55);
			
			Family Node4=new Family("Me",22);
			
			Family Node5=new Family("Own Sis",15);
			
			Family Node6=new Family("Cousin Bro",18);
			
			Family Node7=new Family("Cousin Sis",27);
			
			Node1.LeftChild=Node2;
			
			Node1.RightChild=Node3;
			
			Node2.LeftChild=Node4;
			
			Node2.RightChild=Node5;
			
			//Node3.LeftChild=Node6;
			
			Node3.RightChild=Node7;
			
			new Tree_Builder<Family>().startBuild(Node1);
			
			
		}
		
		public void startBuild(T root)
		{
			LargestNode(root,1);
			
			NoOfLeaves=(int)Math.pow(2, NoOfLevels-1);
			
			CompleteTree(root,1);
			
			bfs(root);
			
			drawTree(root);
		}
		
		
		
		
		static  <T extends Drawable<T> >void LargestNode(T root,int level)
		{
			int tmp=((T)(root)).Print().length();
					
			if(tmp>MaxNodeSize) MaxNodeSize=tmp;
			
			if(root.GetLeftChild()!=null) LargestNode(root.GetLeftChild(),(level+1));
			
			if(root.GetRightChild()!=null) LargestNode(root.GetRightChild(),(level+1));
			
			if(root.GetLeftChild()==null && root.GetRightChild()==null) 
			{
					NoOfLeaves++;
					
					if(NoOfLevels<level) NoOfLevels=level;
			}
			
		}
		
		static <T extends Drawable<T> > void CompleteTree(T root,int level)
		{
			
			if(root.GetLeftChild()==null && level<NoOfLevels)  
				Add_Redundant_Node(root,level); 
		
			
			
			else if(root.GetLeftChild()!=null && level<NoOfLevels) 
				 CompleteTree(root.GetLeftChild(),(level+1));
			
			
			
			
			if(root.GetRightChild()==null && level<NoOfLevels) 
				Add_Redundant_Node(root,level);
				
			
			else if(root.GetRightChild()!=null && level<NoOfLevels) 
				CompleteTree(root.GetRightChild(),(level+1));

		}
		
		static <T extends Drawable<T> >void Add_Redundant_Node(T root,int level)
		{
			if(root.GetLeftChild()==null && level<NoOfLevels) 
				Add_Redundant_Node((T)root.SetLeftChild(),(level+1));

			
			if(root.GetRightChild()==null && level<NoOfLevels) 
				Add_Redundant_Node((T)root.SetRightChild(),(level+1));
			
		}
		
		static void SpacePrinter(int MaxNodeSize)
		{
			for(int i=0;i<MaxNodeSize;i++) System.out.print(" ");
		
		}

		
	static <T extends Drawable<T>> void bfs(T root) //BfS Traversal
	{
		ArrayDeque<T> queue=new ArrayDeque<>();
	
		if(root!=null) queue.addLast(root);
	
		int count=0;
	
		while(!queue.isEmpty())
		{
			root=queue.removeFirst(); //Dequeue from queue
		
			count++;
		
			root.setCount(count);
			
		
			if(root.GetLeftChild()!=null) 
				queue.addLast( root.GetLeftChild() ); //Enqueue Left Child in queue
		
		
		
			if(root.GetRightChild()!=null) 
				queue.addLast( root.GetRightChild() ); //Enqueue Right Child in Queue
		}
	}

	static <T extends Drawable<T>> T getNodeAtX(T root,int x) 
	{
		ArrayDeque<T> queue=new ArrayDeque<>();
		
		if(root!=null) queue.addLast(root);
		
		
	
		while(!queue.isEmpty())
		{
			root=queue.removeFirst(); //Dequeue from queue
			
			if(root.getCount()==x)  return (T)root;
		
			if(root.GetLeftChild()!=null) 
				queue.addLast( root.GetLeftChild() ); //Enqueue Left Child in queue
		
		
		
			if(root.GetRightChild()!=null) 
				queue.addLast( root.GetRightChild() ); //Enqueue Right Child in Queue
		}
		return null;
	}

	static <T extends Drawable<T>> void drawTree(T root)
	{
		Drawable Matrix[][]=new Drawable [NoOfLevels][(NoOfLeaves*2)-1];
	
		int tmp=NoOfLeaves;

		int x=1;
		
		
	
		for(int i=1;i<=NoOfLevels;i++)
		{
			for(int j=1;j<=Math.pow(2, i-1);j++)
			{
				if(j==1) 
				{
					Matrix[i-1][tmp-1]=getNodeAtX(root,x); 
				}
				else 
				{
					Matrix[i-1][tmp*(j*2-1)-1]=getNodeAtX(root,x);  
				}
					
				x++;
			}
			
			tmp/=2;
			
		}
		
		String BadNode="";
		
		for(int i=0;i<MaxNodeSize;i++) BadNode=BadNode+" ";
	
		for(int i=0;i<NoOfLevels;i++)
		{
			for(int j=0;j<((NoOfLeaves*2)-1);j++)
			{
				if(Matrix[i][j]==null) SpacePrinter(MaxNodeSize);
				else 
					{
						String str=( Matrix[i][j] ).Print();
						
						if(Matrix[i][j].IsRedundant()) str=BadNode;
						
						int padding=0;
						
						if(str.length()<MaxNodeSize)	padding=(MaxNodeSize-str.length())/2;
						
						for(int k=0;k<padding;k++)	System.out.print(" "); //Left Padding
						
						System.out.print(str);
						
						for(int k=0;k<padding;k++)	System.out.print(" "); //Right Padding
					}
			}
			System.out.println();
			
			int slash=1;
			
			for(int j=0;j<((NoOfLeaves*2)-1);j++) // For Printing / \
			{
				if(Matrix[i][j]==null) SpacePrinter(MaxNodeSize);
				
				else if(Matrix[i][j]!=null && (i+1)!=NoOfLevels && !Matrix[i][j].IsRedundant()) // Last Level does not need / \ to be printed 
				{
					if(	!(	(Drawable)	(	Matrix[i][j].GetLeftChild()	)	).IsRedundant()	)	
					{		
						System.out.print("/");
						slash=2;
					}
						
					SpacePrinter(MaxNodeSize-slash);
						
					if(	!(	(Drawable)	(	Matrix[i][j].GetRightChild()	)	).IsRedundant()	)	
					{		
							System.out.print("\\");
					}
				}
			}
			System.out.println();
				
		}
		
	}

}