package Dynamic.count_all_paths_in_a_matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dynamic_Sol {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(s);
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int ans=count_ways(m,n);
		System.out.println(ans);
	}

	private static int count_ways(int m, int n) {
		int ways[][]=new int[m][n];
		for(int i=0;i<m;i++)
		{
			ways[i][0]=1;
		}
		for(int i=0;i<n;i++)
		{
			ways[0][i]=1;
		}
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				ways[i][j]=ways[i-1][j]+ways[i][j-1];
			}
		}
		return ways[m-1][n-1];
	}

}


