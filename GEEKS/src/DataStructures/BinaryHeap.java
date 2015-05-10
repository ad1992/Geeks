package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class BinaryHeap {
private static int arr[];
private static int currsize=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxsize=Integer.parseInt(br.readLine().trim());
		arr=new int[maxsize];
		while (true) {
			System.out.print("Enter 1 for insertion\n2Enter 2 for deletion\n"
					+ "Enter 3 for chnage key\nEnter 4 for display\nEnter 5 to extract minimum");
			int choice=Integer.parseInt(br.readLine().trim());
			switch(choice)
			{
			case 1:
				int num=Integer.parseInt(br.readLine().trim());
				insert(num);
				break;
			case 2:
				int key=Integer.parseInt(br.readLine().trim());
				 num=delete(key);
				System.out.println("The deleted value is"+num);
				break;
			case 3:
				int newkey=Integer.parseInt(br.readLine().trim());
				int newval=Integer.parseInt(br.readLine().trim());
				changekey(newkey,newval);
				break;
			case 4:
				display();
				break;
			case 5:
				int min=extract_min();
				System.out.println("min= "+min);
				break;
			default:
				System.exit(0);;
				
			}
			
		}

	}

	private static int extract_min() {
		// TODO Auto-generated method stub
		if(currsize<=0)
			return -1;
		if(currsize==1)
		{
			currsize--;
			return arr[0];
			
		}
		int root=arr[0];
		arr[0]=arr[currsize-1];
		currsize--;
		MinHeapify(0);
		return root;
		
	}

	private static void MinHeapify(int i) {
		// TODO Auto-generated method stub
		int j=0;
		while(2*i+1<currsize)
		{
			j=2*i+1;
			if(j<currsize&&arr[j]>arr[j+1])
				j++;
			if(arr[i]<arr[j])
			{
				break;
			}
			else
			{
				swap(i,j);
				i=j;
			}
		}
		
	}

	private static void display() {
		// TODO Auto-generated method stub
		for(int i=0;i<currsize;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	private static void changekey(int key,int val) {
		// TODO Auto-generated method stub
		arr[key]=val;
		
		while(key>0&&arr[(key-1)/2]>arr[key])
		{
			swap(key,(key-1)/2);
			key=(key-1)/2;
		}
		
	}

	private static int delete(int key) {
		// TODO Auto-generated method stub
		int num=arr[key];
		changekey(key,Integer.MIN_VALUE);
		extract_min();
		return num;
		
	}

	private static void insert(int num) {
		// TODO Auto-generated method stub
		if(currsize==arr.length)
		{
			System.out.println("Heap Overflow");
		}
		else
		{
			arr[currsize]=num;
			currsize++;
			int i=currsize-1;
			while(i>0&&arr[(i-1)/2]>arr[i])
			{
				//System.out.println(arr[(i-1)/2]+" "+arr[i]);
				swap((i-1)/2,i);
				i=(i-1)/2;
				//System.out.println("swapped");
			}
		}
		{
			
		}
		
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		//System.out.println(arr[i]+" "+arr[j]);
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		//System.out.println(arr[i]+" "+arr[j]);
	}
	
}
