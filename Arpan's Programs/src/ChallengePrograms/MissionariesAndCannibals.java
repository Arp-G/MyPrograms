package ChallengePrograms;


// MissionariesAndCannibals Problem Solver designed by ARP


import java.util.*;


public class MissionariesAndCannibals 
{
	
	static List<Sol> solSet=new ArrayList<>();
	
	static int limit=20; // max Recursion depth (Solutions having steps more than this limit will be ignored)
	
	public static void main(String args[])
	{
		
		displayProblem();
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter initial state details :");
		
		System.out.println("Enter Number of missionaries and No of cannibals in left bank");
	
		Bank b1=new Bank(sc.nextInt(),sc.nextInt());
		
		System.out.println("Enter Number of missionaries and No of cannibals in right bank");
	
		Bank b2=new Bank(sc.nextInt(),sc.nextInt());
		
		System.out.println("Enter final state details :");
		
		System.out.println("Enter Number of missionaries and No of cannibals in left bank");
	
		Bank fb1=new Bank(sc.nextInt(),sc.nextInt());
		
		System.out.println("Enter Number of missionaries and No of cannibals in right bank");
	
		Bank fb2=new Bank(sc.nextInt(),sc.nextInt());
		
		System.out.println("Enter initial boat position 0=left bank and 1=right bank");
		
		int pos=sc.nextInt();	
		
		State Initial=new State(b1,b2);
		
		State Final=new State(fb1,fb2);
		
		sc.close();
		
		if(!Initial.isValidState() || !Final.isValidState())
		{
			System.out.println("Wrong input, one of the input states is invalid");
			return;
		}
		
		
			if(pos==0)
				solver(Initial,Final,"",1,true,0);
			else
				solver(Initial,Final,"",1,false,0);
		
		
		if(solSet.isEmpty())
			System.out.println("No solution within "+limit+" steps was found for the given input");
		else
		{
			Collections.sort(solSet,(a,b)->a.solCount-b.solCount);
			
			Sol sol=solSet.get(0);
			
			System.out.println("\nTotal "+solSet.size()+" solutions were found within "+limit+" steps for the given input");
			System.out.println("\nBest solution requires minimum "+(sol.solCount-1)+" steps, the solution is...");
			System.out.println("\nInitial State :");
			System.out.println(sol.solString);
			System.out.println("\nThis is the required Goal State");
		}
		
	
	}
	
	
	static void solver(State current,State goal,String sol,int solCount,boolean pos,int recDepth)
	{
				
		sol=addPictorialSol(sol,current,pos);
		
		if(current.equals(goal)) // Solution found
		{		

			if(solSet.isEmpty()) // Limit recursion depth to best solution
				limit=solCount;	
			
			solSet.add(new Sol(sol,solCount));	
			return;
		}
		
		if( !current.isValidState() || recDepth>=limit)  // Invalid State
			return;
		
		
		//Possible states / Production rules
		
		if(pos) //left bank
		{
			
			State tmp=current.p1();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 1 missionary from left bank to right bank",solCount+1,!pos,recDepth+1);
				
			
			tmp=current.p2();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 1 cannibal from left bank to right bank",solCount+1,!pos,recDepth+1);
								
				
			tmp=current.p3();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 2 missionaries from left bank to right bank",solCount+1,!pos,recDepth+1);
	
				
			tmp=current.p4();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 2 cannibals from left bank to right bank",solCount+1,!pos,recDepth+1);
			
			tmp=current.p5();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 1 missionary and 1 Cannibal from left bank to right bank",solCount+1,!pos,recDepth+1);
		}
				
		else //Right Bank
		{
			State tmp=current.p6();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 1 missionary from right bank to left bank",solCount+1,!pos,recDepth+1);
				
			tmp=current.p7();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 1 cannibal from right bank to left bank",solCount+1,!pos,recDepth+1);
	
				
			tmp=current.p8();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 2 missionaries from right bank to left bank",solCount+1,!pos,recDepth+1);
				
				
			tmp=current.p9();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 2 cannibals from right bank to left bank",solCount+1,!pos,recDepth+1);
			
			tmp=current.p10();
			
			if(tmp.isValidState() && !tmp.equals(current.prevState))
					solver(tmp,goal,sol+"\nMove 1 missionary and 1 Cannibal from right bank to left bank",solCount+1,!pos,recDepth+1);	
						
		}	
		
	}
	
	static String addPictorialSol(String sol,State current,boolean pos)
	{
		Bank Left=current.Left;
		
		Bank Right=current.Right;
		
		String pic="";
		
		for(int i=0;i<Left.m;i++)
		{
			pic=pic+" O ";
		}
		
		pic=pic+" , ";
		
		for(int i=0;i<Left.c;i++)
		{
			pic=pic+" X ";
		}
		
		if(pos)
			pic=pic+" |BB| ->";
		
		pic=pic+" -----------";
		
		if(!pos)
			pic=pic+"<- |BB| ";
		
		for(int i=0;i<Right.c;i++)
		{
			pic=pic+" X ";
		}
		
		pic=pic+" , ";
		
		for(int i=0;i<Right.m;i++)
		{
			pic=pic+" O ";
		}
		
		return sol+"\n\n"+pic+"\n\n";
		
	}
	
	static void displayProblem()
	{
		System.out.println("---------------------------- MISSIONARIES AND CANNIBALS PROBLEM ----------------------------\n");
		
		System.out.println("In this problem, three missionaries and three cannibals must cross a river using a boat which can carry atmost two people, under the constraint that, for both banks, \n"
				+ "that the missionaries present on the bank cannot be outnumbered by cannibals. The boat cannot cross the river by itself with no people on board.");
		
		System.out.println("\nPress Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        
        System.out.println("\n\n\n");
	}
}


class Bank // Denotes each river bank
{
	int m;
	int c;
	
	Bank(int m,int c)
	{
		this.m=m;
		this.c=c;
	}
	
	boolean isValidBank()
	{
		if( m>=0 && c>=0)	
		{
		    if(m==0 || m>=c)
		        return true;
		    else
		        return false;
		}
		else
			return false;
	}
	
	public boolean equals(Object ob)
	{
		if(ob instanceof Bank)	
		{
			Bank tmp=(Bank)ob;
			
			return (tmp.m==this.m && tmp.c==this.c);
		}
		else
			return false;
	}
	
	public String toString()
	{
	    return m+"  "+c;
	}
}


class State
{
	Bank Left,Right;
	
	State prevState;// Contains the previous State from which this state was generated , used to avoid looping recursive calls
	
	State(Bank Left,Bank Right)
	{
		this.Left=Left;
		this.Right=Right;
		prevState=this;
	}
	
	
	State(Bank Left,Bank Right,State prevState)
	{
		this.Left=Left;
		this.Right=Right;
		this.prevState=prevState;
	}
	
	boolean isValidState()
	{
		return Left.isValidBank() && Right.isValidBank();
	}
	
	//Production Rules
	
	State p1() //Transfer 1  missionary from left bank to right bank
	{
		
		Bank Left=new Bank(this.Left.m-1,this.Left.c);
		Bank Right=new Bank(this.Right.m+1,this.Right.c);
		
		return new State(Left,Right,this);			
	}
	
	State p2() //Transfer 1  cannibal from left bank to right bank
	{
		
		Bank Left=new Bank(this.Left.m,this.Left.c-1);
		Bank Right=new Bank(this.Right.m,this.Right.c+1);
		
		return new State(Left,Right,this);			
	}
	
	State p3() //Transfer 2  missionaries from left bank to right bank
	{
		
		Bank Left=new Bank(this.Left.m-2,this.Left.c);
		Bank Right=new Bank(this.Right.m+2,this.Right.c);
		
		return new State(Left,Right,this);			
	}
	
	State p4() //Transfer 2  cannibals from left bank to right bank
	{
		
		Bank Left=new Bank(this.Left.m,this.Left.c-2);
		Bank Right=new Bank(this.Right.m,this.Right.c+2);
		
		return new State(Left,Right,this);			
	}
	
	State p5() //Transfer 1 missionary and 1 Cannibal from left bank to right bank
	{
		
		Bank Left=new Bank(this.Left.m-1,this.Left.c-1);
		Bank Right=new Bank(this.Right.m+1,this.Right.c+1);
		
		return new State(Left,Right,this);			
	}
	
	State p6() //Transfer 1  missionary from right bank to left bank
	{
		
		Bank Left=new Bank(this.Left.m+1,this.Left.c);
		Bank Right=new Bank(this.Right.m-1,this.Right.c);
		
		return new State(Left,Right,this);			
	}
	
	State p7() //Transfer 1  cannibal from right bank to left bank
	{
		
		Bank Left=new Bank(this.Left.m,this.Left.c+1);
		Bank Right=new Bank(this.Right.m,this.Right.c-1);
		
		return new State(Left,Right,this);			
	}
	
	State p8() //Transfer 2  missionaries from right bank to left bank
	{
		
		Bank Left=new Bank(this.Left.m+2,this.Left.c);
		Bank Right=new Bank(this.Right.m-2,this.Right.c);
		
		return new State(Left,Right,this);			
	}
	
	State p9() //Transfer 2  cannibals from right bank to left bank
	{
		
		Bank Left=new Bank(this.Left.m,this.Left.c+2);
		Bank Right=new Bank(this.Right.m,this.Right.c-2);
		
		return new State(Left,Right,this);			
	}
	
	State p10() //Transfer 1 missionary and 1 Cannibal from right bank to left bank
	{
		
		Bank Left=new Bank(this.Left.m+1,this.Left.c+1);
		Bank Right=new Bank(this.Right.m-1,this.Right.c-1);
		
		return new State(Left,Right,this);			
	}
							
	
	public boolean equals(Object ob)
	{
		if(ob instanceof State)	
		{
			State tmp=(State)ob;
			
			return (tmp.Left.equals(this.Left) && tmp.Right.equals(this.Right));
		}
		else
			return false;
	}
	
	public String toString()
	{
	    return "Left Bank :"+this.Left.toString()+"  Right Bank :"+this.Right.toString();
	}

}


class Sol
{
	String solString;
	
	int solCount;
	
	Sol(String solString,int solCount)
	{
		this.solString=solString;
		
		this.solCount=solCount;
	}
}