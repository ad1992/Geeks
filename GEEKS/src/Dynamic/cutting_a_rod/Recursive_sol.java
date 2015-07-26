package Dynamic.cutting_a_rod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Recursive_sol {

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

	private static int cutRod(int[] arr,int l) {
		if(l<=0)
			return 0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<l;i++)
		{
			//System.out.println(i+" "+(l-i-1));
			max=Math.max(max,arr[i]+cutRod(arr, l-i-1));
			
		}	
		//System.out.println("over");
		return max;
	}

}
