package Dynamic.knapsack01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursive_Sol {

	public static void main(String[] args) throws IOException {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		
		int n=Integer.parseInt(br.readLine());
		String value=br.readLine();
		String w=br.readLine();		
		StringTokenizer st;
		
		int  wt[]=new int[n];
		int val[]=new int[n];
	
		st=new StringTokenizer(value);
		for(int i=0;i<n;i++)
		{
			
			val[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(w);
		for(int i=0;i<n;i++)
		{
			
			wt[i]=Integer.parseInt(st.nextToken());
			
		}
		int weight=Integer.parseInt(br.readLine());
		System.out.println(get_maxVal(wt,val,n,weight));

	}

	private static int get_maxVal(int[] wt, int[] val, int n, int weight) {
		if(n==0||weight==0)
			return 0;
		if(wt[n-1]>weight)
			return get_maxVal(wt, val, n-1, weight);
		return Math.max(val[n-1]+get_maxVal(wt, val, n-1, weight-wt[n-1]), get_maxVal(wt, val, n-1, weight));
	}

}
