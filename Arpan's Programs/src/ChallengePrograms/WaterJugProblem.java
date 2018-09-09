package ChallengePrograms;

import java.util.*;

public class WaterJugProblem
{
	
	static List<Solution> SolSet=new ArrayList<>();
	
	public static void main(String args[])
	{
		
		System.out.println("------------------WATER JUG PROBLEM SOLVER------------------\n");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter capcity of the 2 jugs\n");
		
		int x=sc.nextInt();
		
		int y=sc.nextInt();
		
		System.out.println("Enter target capcity of the 2 jugs\n");
		
		int tx=sc.nextInt();
		
		int ty=sc.nextInt();
		
		sc.close();
		
		FindSolution(0,0,x,y,tx,ty,"",0);
		
		Comparator<Solution> BestSolution = (p,q)-> p.solCount-q.solCount;
		
		Collections.sort(SolSet,BestSolution);
		
		System.out.println("Total "+SolSet.size()+" possible solutions was found for the problem\n");
		
		if(SolSet.size()!=0)
		{
			System.out.println("Best Solution is");
		
			System.out.println(SolSet.get(0).sol);
		}
		
		System.out.println("Solutions that involve more than 10 steps are ignored to avoid complexity\n");
		
		System.out.println("---------------------------------------------------------Designed By Arpan");
		
		
		
	}
	
	
	static void FindSolution(int x,int y,int xCapacity,int yCapacity,int xTarget,int yTarget,String sol,int count)
	{
		
		if(x==xTarget && y==yTarget) // If Goal state is found
		{
				SolSet.add(new Solution(sol,count));
				return;
		}

		
		int newX=x,newY=y;
		String newSol=sol;
		
		
		
		if(count>10) // Too many recursion , Ignore this recursion
			return;
		
		//Production Rules
		
		if(x<xCapacity)
		{
			newSol=sol;
			
			newX=xCapacity;
			
			newY=y;
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Fill first jug\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
		
		if(y<yCapacity)
		{			
			newSol=sol;
			
			newY=yCapacity;
			
			newX=x;
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Fill second jug\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
		if(x>0)
		{
			newSol=sol;
			
			newX=0;
			
			newY=y;
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Empty first jug\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
		if(y>0)
		{
			newSol=sol;
			
			newX=x;
			
			newY=0;
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Empty Second jug\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
		if((x+y)>xCapacity && y>0)
		{
			newSol=sol;
			
			newX=xCapacity;
			
			newY=y-(xCapacity-x);
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Pour water from the second jug into first jug until first jug is full\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
		if((x+y)>yCapacity && x>0)
		{
			newSol=sol;
			
			newX=x-(yCapacity-y);
			
			newY=yCapacity;
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Pour water from the first jug into second jug until second jug is full\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
		
		if((x+y)<=xCapacity && y>0)
		{
			newSol=sol;
			
			newX=x+y;
			
			newY=0;
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Pour all water from second jug into first jug\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
		if((x+y)<yCapacity && x>0)
		{	
			newSol=sol;
			
			newX=0;
			
			newY=y+x;
			
			newSol=newSol+"("+newX+","+newY+")";
			
			newSol=newSol+"Pour all water from first jug into second jug\n";
			
			FindSolution(newX,newY,xCapacity,yCapacity,xTarget,yTarget,newSol,count+1);
		}
		
			
	}
}


class Solution
{
	String sol;
	
	int solCount;
	
	
	Solution(String sol,int solCount)
	{
		this.sol=sol;
		this.solCount=solCount;
	}
}