package Dynamic.subset_sum_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dynamic_Sol {

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
		if(is_SubsetSum(arr,M))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		

	}

	private static boolean is_SubsetSum(int[] arr, int M) {
		boolean sum[][]=new boolean[arr.length+1][M+1];
		int N=arr.length;
		for(int i=0;i<=N;i++)
			sum[i][0]=true;
		for(int i=1;i<=M;i++)
			sum[0][i]=false;
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=M;j++)
			{
				sum[i][j]=sum[i-1][j];				
				if(!sum[i][j]&&arr[i-1]<=j)
					sum[i][j]=sum[i][j]|sum[i-1][j-arr[i-1]];
			}
		}
		
		return sum[N][M];
	}

}
