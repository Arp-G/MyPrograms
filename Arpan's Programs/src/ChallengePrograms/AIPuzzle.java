package ChallengePrograms;

/*
 * 
 
Sample input

1
2
3
5
6
$
7
8
4
1
2
3
5
8
6
$
7
4

* 
*/

import java.util.*;

class Move
{
    Character state[][];
    
    String move;
    
    Move(Character state[][],String move)  
    {
        this.state=state;
        this.move=move;
    }
 
}

public class AIPuzzle 
{
    static int max=999999;
    
    static int bestPath=max;
    
    static List<Move> route;
    
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the size of the problem");
        
        int n=sc.nextInt();
        
        Character InitialState[][],FinalState[][];
        
        System.out.println("Enter initial state values");
        
        InitialState=GetInput(n,sc);
        
        System.out.println("Enter final state values");
        
        FinalState=GetInput(n,sc);
        
        sc.close();
        
        int row,col;
        
        row=col=0;
        
        Outer:
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(InitialState[i][j]=='$')
                {
                    row=i;
                    col=j;
                    break Outer;
                }
            }
        }
        
        drawState(new Move(InitialState,"Initial State"),n);
        
     /*  long time=java.lang.System.currentTimeMillis() ;
        PuzzleSolver(InitialState,new ArrayList<Move>(),row,col,0,FinalState);
        time=java.lang.System.currentTimeMillis()-time;
        
        
        System.out.println("Time taken= "+time);*/
        
        
      long time=java.lang.System.currentTimeMillis() ;
        HeuristicPuzzleSolver(InitialState,new ArrayList<Move>(),row,col,0,FinalState);
        
        time=java.lang.System.currentTimeMillis()-time;
        
        
        System.out.println("Time taken= "+time);
        
        
        
        if(bestPath==max)
        {
            System.out.println("No paths where found");
            return;
        }
                   
        for(Move tmp:route)
        {
            drawState(tmp,n);
        }   
        
        System.out.println("This is the required goal state");
        
    }
    
    static void drawState(Move ob,int n)
    {
        System.out.println(ob.move);
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print("| "+ob.state[i][j]+" |");
            
            System.out.println();
            
            for(int j=0;j<n && i!=n-1;j++)
               System.out.print("-----"); 

            System.out.println();
        }
    }
    
    static Character[][] getCopy(Character state[][],int n)
    {
    	Character cpy[][]=new Character[n][n];
    	
    	for(int i=0;i<n;i++)
    		for(int j=0;j<n;j++)
    			cpy[i][j]=state[i][j];
    	
    	return cpy;
    }
     
    static void PuzzleSolver(Character state[][],List<Move> path,int row,int col,int count,Character FinalState[][])
    {
    	   	
    	if(count>15)
    		return;
    	
        if(count>=bestPath)
            return;
        
        
        if(isGoal(state,FinalState))
        {
            route=path;
            bestPath=count;
            return;
        }
        
        Character tmp[][];
        
        List<Move> tmpPath;
        
        if(row!=0) //UP
        {
        	
            tmp=getCopy(state,state[0].length);
                      
            tmp=swap(row,col,row-1,col,tmp);
                       
            
            if( path.size()>1 && !isGoal((path.get(path.size()-2)).state,tmp) || path.size()<=1 )
            {	
              	tmpPath=new ArrayList<Move>(path);
            	
            	tmpPath.add(new Move(tmp,"Move the blank upwards"));
            
            	PuzzleSolver(tmp,tmpPath,row-1,col,count+1,FinalState);
            }
        }
        
        if(row!=state.length-1) //DOWN
        {
        	
        	tmp=getCopy(state,state[0].length);
            
            tmp=swap(row,col,row+1,col,tmp);
            
            if( path.size()>1 && !isGoal((path.get(path.size()-2)).state,tmp) || path.size()<=1  )
            {
              	tmpPath=new ArrayList<Move>(path);
            	
            	tmpPath.add(new Move(tmp,"Move the blank downwards"));
            
            	PuzzleSolver(tmp,tmpPath,row+1,col,count+1,FinalState);
            }
        }
        
        if(col!=0) //LEFT
        {
        	
        	tmp=getCopy(state,state[0].length);
            
            tmp=swap(row,col,row,col-1,tmp);
            
            if( path.size()>1 && !isGoal((path.get(path.size()-2)).state,tmp) || path.size()<=1  )
            {
             	tmpPath=new ArrayList<Move>(path);
            
            	tmpPath.add(new Move(tmp,"Move the blank Left"));
            
            	PuzzleSolver(tmp,tmpPath,row,col-1,count+1,FinalState);
            }
        }
        
        if(col!=state.length-1) //RIGHT
        {
        	
        	tmp=getCopy(state,state[0].length);
            
            tmp=swap(row,col,row,col+1,tmp);
            
            if( path.size()>1 && !isGoal((path.get(path.size()-2)).state,tmp) || path.size()<=1  )
            {
            	tmpPath=new ArrayList<Move>(path);
            
            	tmpPath.add(new Move(tmp,"Move the blank right"));
            
            	PuzzleSolver(tmp,tmpPath,row,col+1,count+1,FinalState);
            }
        }
        
        
    }
        
    static Character[][] swap(int row1,int col1,int row2,int col2,Character matrix[][])
    {
        char tmp=matrix[row1][col1];
        
        matrix[row1][col1]=matrix[row2][col2];
        
        matrix[row2][col2]=tmp;
        
        return matrix;
    }
    
    static boolean isGoal(Character state[][],Character FinalState[][])
    {
        for(int i=0;i<state.length;i++)
        {
            for(int j=0;j<state.length;j++)
            {
                if(state[i][j]!=FinalState[i][j])
                    return false;
            }
        }
        
        return true;
    }
        
    static Character[][] GetInput(int n,Scanner sc)
    {
        Character matrix[][]=new Character[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.next().charAt(0); 
            }
        }
        
        return matrix;
    }
    
    static void HeuristicPuzzleSolver(Character state[][],List<Move> path,int row,int col,int count,Character FinalState[][])
    {
                
        if(isGoal(state,FinalState))
        {
            route=path;
            bestPath=count;
            return;
        }
        
        char move=HeuristicFunction(state,row,col,FinalState);

        switch(move)
        {
        
        case 'U':
        	
        	state=swap(row-1,col,row,col,state);
        		
            path.add(new Move(state,"Move the blank upwards"));
            
            PuzzleSolver(state,path,row-1,col,count+1,FinalState);
            
            break;

        case 'D':
        	
        	state=swap(row+1,col,row,col,state);
        	
            path.add(new Move(state,"Move the blank downwards"));
            
            PuzzleSolver(state,path,row+1,col,count+1,FinalState);
            
            break;
            
        
        case 'L':
        	
        	state=swap(row,col,row,col-1,state);
        	
            path.add(new Move(state,"Move the blank Left"));
            
            PuzzleSolver(state,path,row,col-1,count+1,FinalState);
            
            break;
         
        
        case 'R':
        	
        	state=swap(row,col,row,col+1,state);
            
            path.add(new Move(state,"Move the blank right"));
            
            PuzzleSolver(state,path,row,col+1,count+1,FinalState);
            
            break;
	
        }
            
    } 
       
    static char HeuristicFunction(Character matrix[][],int row,int col,Character finalState[][])
    {
    	int value=0;
    	
    	char move=0;
    	
    	if(row!=0)
    	{
    		swap(row,col,row-1,col,matrix);
    	   	
    		if(FindHeuristic(matrix,finalState)>value)
    			
    		move='U';
    	
    		swap(row,col,row-1,col,matrix);

    	}
    	
    	
    	if(row!=matrix.length-1)
    	{
    		swap(row,col,row+1,col,matrix);
    	   	
    		if(FindHeuristic(matrix,finalState)>value)
    			move='D';
    	
    		swap(row,col,row+1,col,matrix);
    		
    	}
    	
    	
    	
    	
    	if(col!=0)
    	{	
    		swap(row,col,row,col-1,matrix);
    	
    		if(FindHeuristic(matrix,finalState)>value)
    			move='L';
    	
    		swap(row,col,row,col-1,matrix);
    	}
    	
    	
    	
    	if(col!=matrix.length-1)
    	{
    		swap(row,col,row,col+1,matrix);
    	
    		if(FindHeuristic(matrix,finalState)>value)
    			move='R';
    	
    		swap(row,col,row,col+1,matrix);
    	}
    	
    	return move;
    }
    
    static int FindHeuristic(Character state[][],Character finalState[][])
    {
    	int value=0;
    	
    	for(int i=0;i<state.length;i++)
    		for(int j=0;j<state.length;j++)
    			if(state[i][j]==finalState[i][j])
    				value++;
    	return value;
    
    }
    


}
