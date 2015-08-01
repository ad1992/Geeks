package Dynamic.longest_increasing_subsequence;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String s=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(s,", ");
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int ans=increasingSequence(arr,N,1);
		System.out.println(ans);

	}

	private static int increasingSequence(int[] arr, int n, int max) {
		if(n==1)
			return 1;
		int max_ending_here=1,lis;
		for(int i=1;i<n;i++)
		{
			
			lis=increasingSequence(arr,i, max);
			if(arr[i-1]<arr[n-1]&&lis+1>max_ending_here)
			{
				max_ending_here=lis+1;
				
			}
			
		}
		//System.out.println(max_ending_here+" "+arr[n-1]);
		max=Math.max(max,max_ending_here);
		return max;
	}
	

}
