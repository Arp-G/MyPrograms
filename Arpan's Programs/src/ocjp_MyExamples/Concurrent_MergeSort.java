package ocjp_MyExamples;

import java.util.concurrent.*;
import java.util.*;

public class Concurrent_MergeSort extends RecursiveAction
{
	int low;
	int high;
	int arr[];
	
	Concurrent_MergeSort(int[] arr,int low,int high)
	{
		this.low=low;
		this.high=high;
		this.arr=arr;
	}
	
	protected void compute()
	{
		//System.out.println("called compute with low = "+low+" high = "+high);
		
		if (low < high)
	        {
	            
	            int mid = (low+high)/2;
	 
	            Concurrent_MergeSort lower=new Concurrent_MergeSort(arr,low,mid);
	            
	            Concurrent_MergeSort higher=new Concurrent_MergeSort(arr,mid+1,high);
	            
	           
	            
	            invokeAll(lower,higher);
	                      
	            merge(arr, low, mid, high);
	            
	            
	        }
	}
		 
		 static void merge(int arr[],int l, int m, int r)
		 {
		        // Find sizes of two subarrays to be merged
		        int n1 = m - l + 1;
		        int n2 = r - m;
		 
		        /* Create temp arrays */
		        int L[] = new int [n1];
		        int R[] = new int [n2];
		 
		        /*Copy data to temp arrays*/
		        for (int i=0; i<n1; ++i)
		            L[i] = arr[l + i];
		        for (int j=0; j<n2; ++j)
		            R[j] = arr[m + 1+ j];
		 
		 
		        /* Merge the temp arrays */
		 
		        // Initial indexes of first and second subarrays
		        int i = 0, j = 0;
		 
		        // Initial index of merged subarry array
		        int k = l;
		        while (i < n1 && j < n2)
		        {
		            if (L[i] <= R[j])
		            {
		                arr[k] = L[i];
		                i++;
		            }
		            else
		            {
		                arr[k] = R[j];
		                j++;
		            }
		            k++;
		        }
		 
		        /* Copy remaining elements of L[] if any */
		        while (i < n1)
		        {
		            arr[k] = L[i];
		            i++;
		            k++;
		        }
		 
		        /* Copy remaining elements of R[] if any */
		        while (j < n2)
		        {
		            arr[k] = R[j];
		            j++;
		            k++;
		        }
		        		   
		 }
		 
		 public static void main(String args[])
		 {
			 int arr[]=new int[100000];
			 
			 Random rand = new Random();
			 
			 for(int j=0;j<100000;j++)
			 {
			 	 arr[j]=rand.nextInt(1000000);
			 }
			 
			 int arr1[]=arr.clone();
			 
			 int arr2[]=arr.clone();
			 
			//--------------------------------------------------------------------------------------------------------------------------	
			 
			 long time=java.lang.System.currentTimeMillis() ;
			 
			 Iterative_MergeSort.mergeSort(arr);
			 			 			 
			 System.out.println("Completed Iterative MergeSort in "+ (java.lang.System.currentTimeMillis()-time ));
			 
			 
			//--------------------------------------------------------------------------------------------------------------------------			 
			
			 time=java.lang.System.currentTimeMillis() ;
			 
			 Normal_MergeSort.test(arr1);
			 			 
			 System.out.println("Completed Recursive MergeSort in "+ (java.lang.System.currentTimeMillis()-time ));
			 
			//--------------------------------------------------------------------------------------------------------------------------	
			 
			 ForkJoinTask <?> task=new Concurrent_MergeSort(arr2,0,arr2.length-1);
			 
			 ForkJoinPool pool=new ForkJoinPool();
			 
			 time=java.lang.System.currentTimeMillis() ;
			 
			 pool.invoke(task);
			 
			 System.out.println("Completed Concurrent MergeSort in "+ (java.lang.System.currentTimeMillis()-time ));
			 
			//--------------------------------------------------------------------------------------------------------------------------	
			 
			 /*for(double i:arr)
			 {
				 System.out.print(i);
			 }*/
		 }
}
	
	

class Normal_MergeSort
{
	    // Merges two subarrays of arr[].
	    // First subarray is arr[l..m]
	    // Second subarray is arr[m+1..r]
	   static  void merge(int arr[], int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        /* Create temp arrays */
	        int L[] = new int [n1];
	        int R[] = new int [n2];
	 
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i)
	            L[i] = arr[l + i];
	        for (int j=0; j<n2; ++j)
	            R[j] = arr[m + 1+ j];
	 
	 
	        /* Merge the temp arrays */
	 
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	    // Main function that sorts arr[l..r] using
	    // merge()
	   static  void sort(int arr[], int l, int r)
	    {
	        if (l < r)
	        {
	            // Find the middle point
	            int m = (l+r)/2;
	 
	            // Sort first and second halves
	            sort(arr, l, m);
	            sort(arr , m+1, r);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
	 
	    /* A utility function to print array of size n */
	    /*static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }*/
	 
	    // Driver method
	    static public  void test(int arr[])
	    {
	    	sort(arr, 0, arr.length-1);
	 
	    }
}



class Iterative_MergeSort
{
	 public static void mergeSort(int[] array)
	    {
	        if(array == null)
	        {
	            return;
	        }
	 
	        if(array.length > 1)
	        {
	            int mid = array.length / 2;
	 
	            // Split left part
	            int[] left = new int[mid];
	            for(int i = 0; i < mid; i++)
	            {
	                left[i] = array[i];
	            }
	             
	            // Split right part
	            int[] right = new int[array.length - mid];
	            for(int i = mid; i < array.length; i++)
	            {
	                right[i - mid] = array[i];
	            }
	            mergeSort(left);
	            mergeSort(right);
	 
	            int i = 0;
	            int j = 0;
	            int k = 0;
	 
	            // Merge left and right arrays
	            while(i < left.length && j < right.length)
	            {
	                if(left[i] < right[j])
	                {
	                    array[k] = left[i];
	                    i++;
	                }
	                else
	                {
	                    array[k] = right[j];
	                    j++;
	                }
	                k++;
	            }
	            // Collect remaining elements
	            while(i < left.length)
	            {
	                array[k] = left[i];
	                i++;
	                k++;
	            }
	            while(j < right.length)
	            {
	                array[k] = right[j];
	                j++;
	                k++;
	            }
	        }
	    }
	 
}
