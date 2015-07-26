package Dynamic.cutting_a_rod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Dynamic_sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s;
		StringTokenizer st;		
		int N=Integer.parseInt(br.readLine().trim());
		int arr[]=new int[N];
		s=br.readLine().trim();
		st=new StringTokenizer(s);
		for(int i=0;i<N;i++)
		{
			
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int ans=cutRod(arr,N);
		System.out.println(ans);

		
	}

	private static int cutRod(int[] arr, int n) {
		int maxcost[]=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			maxcost[i]=arr[i-1];
		}
		for(int len=2;len<=n;len++)
		{
			for(int i=0;i<len;i++)
			{
				maxcost[len]=Math.max(maxcost[len],arr[i]+maxcost[len-i-1]);
				
			}
		}
		return maxcost[n];
	}

}
