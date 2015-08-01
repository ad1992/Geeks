package Dynamic.largest_sum_contiguous_subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Dynamic_Sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
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
		int len=arr.length;
		int maxsum[]=new int[len];
		int max=arr[0];
		maxsum[0]=arr[0];
		for(int i=1;i<len;i++)
		{
			maxsum[i]=arr[i];
			if(maxsum[i-1]>0)
				maxsum[i]+=maxsum[i-1];			
			max=Math.max(max,maxsum[i]);
		}
		return max ;
		
	}

}
