package Dynamic.largest_sum_contiguous_subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kadane_Modified {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
        String s;
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
		s=br.readLine().trim();
		st=new StringTokenizer(s,", ");
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		
		}
        int ans=maxSubArraySum(arr);
        System.out.println("Maximum contiguous sum is "+ ans);
        
        br.close();


	}

	private static int maxSubArraySum(int[] arr) {
		int max_so_far = arr[0], max_ending_here =0;
		int i;
		for(i = 0; i < arr.length; i++)
		{
			max_ending_here = max_ending_here + arr[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
				
			if(max_ending_here < 0)
				max_ending_here = 0;			
		     
		}
		return max_so_far;
		
	}

}
