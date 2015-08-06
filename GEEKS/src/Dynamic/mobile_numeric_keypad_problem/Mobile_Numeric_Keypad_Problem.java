package Dynamic.mobile_numeric_keypad_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class Mobile_Numeric_Keypad_Problem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		long ans=calculate_ways(N);
		System.out.println(ans);
	}

	private static long calculate_ways(int n) {
		
		long ways[][]=new long [10][n+1];
		for(int i=0;i<10;i++)
		{
			ways[i][1]=1l;
		}
		int adj[][]={{8},{2,4},{1,3,5},{2,6},{1,5,7},{2,4,6,8},{3,5,9},{4,8},{0,5,7,9},{6,8}};
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<=9;j++)
			{
				ways[j][i]=ways[j][i-1];
				for(int k=0;k<adj[j].length;k++)
				{
					ways[j][i]+=ways[adj[j][k]][i-1];
				}
				
			}
		}
		long ans=0l;
		for(int i=0;i<10;i++)
			ans+=ways[i][n];
		return ans;
	}

}
