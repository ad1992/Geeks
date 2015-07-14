package sorting;

import java.util.Scanner;

/**
 * @author Aakansha Doshi
 *
 */
public class QuickSort {

	public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);
	     int n = in.nextInt();
	     int[] arr = new int[n];
	     for(int i=0;i<n;i++){
	        arr[i]=in.nextInt(); 
	     }
	     quickSort(arr,0,n-1);
	     printArray(arr);
	     in.close();
	 }

	private static void printArray(int[] arr) {
         for(int n: arr){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       

	private static void quickSort(int[] arr,int i,int j) {
		// TODO Auto-generated method stub
		if(i<j)
		{
			int pos=partition(arr,i,j);
			quickSort(arr,i,pos-1);
			quickSort(arr,pos+1,j);
		}
		
	}

	private static int partition(int[] arr,int i,int j) {
		// TODO Auto-generated method stub
		int pivot=arr[j];
		int small=i-1;
		for(int k=i;k<j;k++)
		{
			if(arr[k]<=pivot)
			{
				small++;
				swap(arr,k,small);
				
				
			}
			
		
		}
		swap(arr,j,small+1);
	//	printArray(arr);
		return small+1;
		
		
	}

	private static void swap(int[] arr, int k, int small) {
		// TODO Auto-generated method stub
		int temp;
		temp=arr[k];
		arr[k]=arr[small];
		arr[small]=temp;
		
	}    
	

}
