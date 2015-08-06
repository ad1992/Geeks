package Dynamic.subset_sum_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Recursive_Sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		int N=Integer.parseInt(br.readLine().trim());
		String s=br.readLine().trim();
		StringTokenizer st;
		int arr[]=new int[N];
		st=new StringTokenizer(s);
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		int M=Integer.parseInt(br.readLine().trim());
		if(is_SubsetSum(arr,M,N-1))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}

	}

	private static boolean is_SubsetSum(int[] arr, int m,int i) {
		
		if(m==0)
			return true;
		if(i==0)
			return false;
		if(arr[i]>m)
			return is_SubsetSum(arr, m, i-1);
		return is_SubsetSum(arr, m-arr[i], i-1)|is_SubsetSum(arr, m, i-1);
	}

}
