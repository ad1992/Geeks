package Dynamic.min_cost_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dynamic_Soln {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		s=br.readLine().trim();
		st=new StringTokenizer(s);
		//size of matrix
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int costmatrix[][]=new int[X][Y];
		for(int i=0;i<X;i++)
		{
			s=br.readLine().trim();
			st=new StringTokenizer(s);
			for(int j=0;j<Y;j++)
			{
				costmatrix[i][j]=Integer.parseInt(st.nextToken());
			}
			
		}
		//The coordinates for which min path is to be calculated
		s=br.readLine().trim();
		st=new StringTokenizer(s);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int ans=min_cost(costmatrix,M,N);
		System.out.println(ans);
		

	}

	private static int min_cost(int[][] costmatrix, int m, int n) {
		int cost=0;
		int mincost[][]=new int[costmatrix.length][costmatrix[0].length];
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0|j==0)
					mincost[i][j]=costmatrix[i][j];
				else
				{
					mincost[i][j]=Math.min(mincost[i-1][j-1],Math.min(mincost[i][j-1],mincost[i-1][j]))+costmatrix[i][j];
				}
				
			}
		}
		return mincost[m][n];
	}

}
