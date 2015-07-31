package Dynamic.min_cost_path;

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
		if(n<0||m<0)
			return Integer.MAX_VALUE;
		if(n==0&&m==0)
			return costmatrix[m][n];
		return costmatrix[m][n]+Math.min(min_cost(costmatrix,m-1,n-1),Math.min(min_cost(costmatrix, m-1, n),min_cost(costmatrix, m, n-1)));
	
	}

}
