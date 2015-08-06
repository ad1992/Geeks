package Dynamic.partition_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Partition_problem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		int N=Integer.parseInt(br.readLine().trim());
		int arr[]=new int[N];
		s=br.readLine().trim();
		st=new StringTokenizer(s," ");
		int total=0;
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
			total+=arr[i];
			
		}
		
		if((total&1)==1||!is_subsetPossible(arr, total/2))
		{
			System.out.println("No");
		}
		else
		{
			System.out.println("Yes");
		}
	}

	private static boolean is_subsetPossible(int[] arr, int sum) {
		int N=arr.length;			
				
		boolean subset[][]=new boolean[N+1][sum+1];
		
		for(int i=0;i<=N;i++)
			subset[i][0]=true;
		for(int i=1;i<=sum;i++)
			subset[0][i]=false;
		for(int i=1;i<=N;i++)
		{
			
			for(int j=1;j<=sum;j++)
			{
				subset[i][j]=subset[i-1][j];
				if(!subset[i][j]&&arr[i-1]<=j)
				{
					subset[i][j]=subset[i][j]|subset[i-1][j-arr[i-1]];
					
				}
			
			}
		}
		return subset[N][sum];
	}

}
