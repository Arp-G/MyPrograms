import java.util.Arrays;

public class ShotestPath_algos {
	public static void main(String args[]) 
	{
		int INF=999999;
		
	
        int arr[][]= {
        		
        		{0,-1,4,INF,INF},
        		{INF,0,3,2,2},
        		{INF,INF,0,INF,INF},
        		{INF,1,5,0,INF},
        		{INF,INF,INF,-3,0}
			};
        
        bellmanford(arr,5,0);
        
        System.out.println("----------------------------");
        
        /* Let us create the following weighted graph
        10
   (0)------->(3)
    |         /|\
  5 |          |
    |          | 1
   \|/         |
   (1)------->(2)
        3           */
       int arr1[][]= { 
        		
        			{0,   5,  INF, 10},
                    {INF, 0,   3, INF},
                    {INF, INF, 0,   1},
                    {INF, INF, INF, 0}
                    
                  };
        
        floydwarshal(arr1,4);
        
        
        
        /* Let us create the example graph discussed above */
        int arr2[][] = {
        				   {0, 4, INF, INF, INF, INF, INF, 8, INF},
                           {4, 0, 8, INF, INF, INF, INF, 11, INF},
                           {INF, 8, 0, 7, INF, 4, INF, INF, 2},
                           {INF, INF, 7, 0, 9, 14, INF, INF, INF},
                           {INF, INF, INF, 9, 0, 10, INF, INF, INF},
                           {INF, INF, 4, 14, 10, 0, 2, INF, INF},
                           {INF, INF, INF, INF, INF, 2, 0, 1, 6},
                           {8, 11, INF, INF, INF, INF, 1, 0, 7},
                           {INF, INF, 2, INF, INF, INF, 6, 7, 0}
                          };
       
         //dijkstra(arr2, 9 , 0);
        }
	
	
    
    
    
    
    static void bellmanford(int arr[][],int len,int s)
    {
    	int dist[]=new int[len];
    	
        for(int i=0;i<len;i++) // Check all nodes
        {
                dist[i]=arr[s][i]; // Set the direct distances
                //System.out.println(dist[i]);
                
        }
        
        
        for(int i=0;i<len;i++) // For all nodes
        {
        	for(int j=0;j<len;j++) // For every node j
        	{
        		
        		for(int k=0;k<len;k++) // check all via nodes k
        		{
        			if( dist[j] > (dist[k]+arr[k][j]) )
        			{
        				//System.out.println("The distance of "+j+" = "+dist[j]+" is > distance of "+k+" = "+dist[k]+" + cost of (k,j) = "+arr[k][j]);
        				
        				dist[j]=dist[k]+arr[k][j];
        			}
        		}
        	}
        }
        
        
        
        for(int i=0;i<len;i++)
        {
        	System.out.println(dist[i]);
        }
    }
    
    
    static void floydwarshal(int arr[][],int len)
    {

        int dist[][]=new int[len][len];
        
        for(int i=0;i<len;i++) 
        {
        	for(int j=0;j<len;j++) 
        	{
        		dist[i][j]=arr[i][j];
        		
        	}
        }
        
        
        
        
        for(int i=0;i<len;i++) // For every via node
        {
        	for(int j=0;j<len;j++) // For every node j
        	{
        		
        		for(int k=0;k<len;k++) // For every node k
        		{
        			if( dist[j][k] > dist[j][i]+dist[i][k] ) // if the distance( j,k ) is greater than the distance( j,k ) via i then update it
        			{
        				dist[j][k] = dist[j][i]+dist[i][k];
        			}
        		}
        	}
        }
        
        
        
        for(int i=0;i<len;i++) 
        {
        	for(int j=0;j<len;j++) 
        	{
        		System.out.print(dist[i][j]+" , ");
        		
        	}
        	System.out.println();
       
        }
    }
    
    static void dijkstra(int arr[][],int len,int s)
    {
    	int dist[]=new int[len];
    	
    	boolean visited[]=new boolean[len];
    	
        for(int i=0;i<len;i++) // Check all nodes
        {
                dist[i]=arr[s][i]; // Set the direct distances
                
                visited[i]=false; // Set visited to false for all nodes
                
        }
        
        dist[s]=0;  //Distance of source to source is 0
        
        visited[s]=true; //Source node is visited
        
        
        for(int i=0;i<len;i++) // For all nodes
        {
        	int u=FindMin(dist,visited); // Find the node having minimum distance from source and not visited
        	
        	visited[u]=true; // Visit the chosen vertex
        		
        		for(int k=0;k<len && !visited[k];k++) // for all nodes that are adjacent to the choose node and are not visited
        		{
        			if( dist[k] > dist[u]+arr[u][k]) // If the distance to a node is better via the chosen node then update it
        			{		
        				dist[k] = dist[u]+arr[u][k];
        			}
        			
        		}
        	
        }
        
        
        
        for(int i=0;i<len;i++)
        {
        	System.out.println(dist[i]);
        }
    }
    
    static int FindMin(int dist[],boolean visited[])
    {
    	int min=Integer.MAX_VALUE,minloc=-1;
    	
    	
    	
    	for(int i=0;i<dist.length;i++)
    	{
    		if(!visited[i] && dist[i]<min)
    		{
    			min=dist[i];
    			minloc=i;
    		}
    	}
    	
    	//System.out.println("min="+min);
    	
    	return minloc;
    }
    
    
    
}
